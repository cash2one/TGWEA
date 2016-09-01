package com.etaoguan.wea.client.web.action.admin;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWFileUploadService;
import com.etaoguan.wea.client.web.vo.AndroidSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.common.FileGenResult;
import com.etaoguan.wea.service.IAddAndroidversionService;
import com.etaoguan.wea.vo.AppAndroidVersion;


/**
 * @author cunli
 * 安卓 应用升级信息管理
 */
@SuppressWarnings("serial")
@WeaModule(mname="安卓 应用升级信息管理")
@Service("androdiversionAction") @Scope("prototype")
public class WAndroidVersionAction extends WCommonBaseAction{
	                
	@Resource(name="addAndroidversionService")
	private IAddAndroidversionService iAddAndroidversionService;
	
	private  AppAndroidVersion  androidVersion;
	private AndroidSearch androidSearch = new AndroidSearch();
	@Autowired
	IWFileUploadService iWFileUploadService;
	public IAddAndroidversionService getiAddAndroidversionService() {
		return iAddAndroidversionService;
	}

	public void setiAddAndroidversionService(
			IAddAndroidversionService iAddAndroidversionService) {
		this.iAddAndroidversionService = iAddAndroidversionService;
	}

	public AndroidSearch getAndroidSearch() {
		return androidSearch;
	}

	public void setAndroidSearch(AndroidSearch androidSearch) {
		this.androidSearch = androidSearch;
	}

	public AppAndroidVersion getAndroidVersion() {
		return androidVersion;
	}

	public void setAndroidVersion(AppAndroidVersion androidVersion) {
		this.androidVersion = androidVersion;
	}
	
	@SuppressWarnings("unused")
	@WeaFunction(fname="正在 修改安卓版本信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditAndroidvs")
	public String saveEditAdmin() {
		
		String fullPath=androidVersion.getFullPath();
		if (!StringUtils.isBlank(fullPath)) {//如果上传了文件，就更改文件后缀名
			FileGenResult targetImgFileGenResult = iWFileUploadService.rename2TargetFile(fullPath);
		}
		
		iAddAndroidversionService.updateandroidversoin(androidVersion);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="获取安卓版本信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditAndroidvsInitData")
	public String getEditAndroidvsInitData() {
		String versionId = getRequestParamValue("versionId");
		AppAndroidVersion androidVersion1 = new AppAndroidVersion();
		androidVersion1.setVersionId(Long.valueOf(versionId));
		AppAndroidVersion androidVersion=iAddAndroidversionService.getAndrodivsbyId(androidVersion1);
		weaResponse.setRespData(androidVersion);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="到 修改安卓版本 页面",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditAndroidvs",results = { @Result(name = "success", type = "dispatcher",location="/admin/upgradeinformation/edit_androidvs.jsp")})
	public String editAdmin() {
		return SUCCESS;
	}
	
	@WeaFunction(fname="删除安卓版本",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelAndroidvs")
	public String delAndroidvs() {
		String versionId = getRequestParamValue("versionId");
		iAddAndroidversionService.delandroidversoin(Integer.parseInt(versionId));
		return JSONRESPONSE;
	}

	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="安卓版本信息列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListAndroidvsData")
	public String listAndroidvsData() {
		
		WPage wpage = iAddAndroidversionService.getAndroidvs(androidSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("unused")
	@WeaFunction(fname="正在 添加安卓版本信息",oname=WeaFunction.Operation.CREATE)
	@Action(value="wAddandriodversionnow")
	public String addandroidv() throws Exception {
			if (androidVersion.getRemark().trim().equals(null) || androidVersion.getRemark().trim().equals("")) {
				androidVersion.setRemark("无备注");
			}
			String fullPath=androidVersion.getFullPath();
			FileGenResult targetImgFileGenResult = iWFileUploadService.rename2TargetFile(fullPath);
			
			androidVersion.setVersionNum(iAddAndroidversionService.getMaxVersionNumService(androidVersion)+1);
			iAddAndroidversionService.addandroidversion(androidVersion);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="到  安卓APP版本管理  页面",oname=WeaFunction.Operation.READ)
	@Action(value="wAndroidversion",results = { @Result(name = "success", type = "dispatcher",location="/admin/upgradeinformation/androidversion.jsp")})
	public String androidversion() {
		return SUCCESS;
	}
	@WeaFunction(fname="到 添加安卓版本信息 页面",oname=WeaFunction.Operation.READ)
	@Action(value="wAddandroidversion",results = { @Result(name = "success", type = "dispatcher",location="/admin/upgradeinformation/add_androidversion.jsp")})
	public String addandroidversion() {
		return SUCCESS;
	}
	
	

}
