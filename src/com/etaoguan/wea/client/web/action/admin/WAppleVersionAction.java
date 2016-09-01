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
import com.etaoguan.wea.client.web.vo.AppleSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.common.FileGenResult;
import com.etaoguan.wea.service.IAppleVersionService;
import com.etaoguan.wea.vo.AppleVersion;


/**
 * @author cunli
 * 苹果 应用升级信息管理
 */
@SuppressWarnings("serial")
@WeaModule(mname="苹果 应用升级信息管理")
@Service("appleiversionAction") @Scope("prototype")
public class WAppleVersionAction extends WCommonBaseAction{
	                
	@Resource(name="appleVersionService")
	private IAppleVersionService iAppleVersionService;
	@Autowired
	IWFileUploadService iWFileUploadService;
	private AppleVersion appleVersion;
	
	private AppleSearch appleSearch = new AppleSearch();
	

	public AppleSearch getAppleSearch() {
		return appleSearch;
	}

	public void setAppleSearch(AppleSearch appleSearch) {
		this.appleSearch = appleSearch;
	}

	public AppleVersion getAppleVersion() {
		return appleVersion;
	}

	public void setAppleVersion(AppleVersion appleVersion) {
		this.appleVersion = appleVersion;
	}
	
	@SuppressWarnings("unused")
	@WeaFunction(fname="正在 修改苹果版本信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditApplevs")
	public String saveEditAdmin() {
		String fullPath=appleVersion.getFullPath();
		if (!StringUtils.isBlank(fullPath)) {//如果上传了文件，就更改文件后缀名
			FileGenResult targetImgFileGenResult = iWFileUploadService.rename2TargetFile(fullPath);
		}
		iAppleVersionService.updateAppleVs(appleVersion);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="获取苹果版本信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditApplevsInitData")
	public String getEditAndroidvsInitData() {
		String versionId = getRequestParamValue("versionId");
		AppleVersion appleVersion = new AppleVersion();
		appleVersion.setVersionId(Long.valueOf(versionId));
		appleVersion=iAppleVersionService.getAppleVersionById(appleVersion);
		weaResponse.setRespData(appleVersion);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="到 修改苹果版本 页面",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditAppleVs",results = { @Result(name = "success", type = "dispatcher",location="/admin/upgradeinformation/edit_applevs.jsp")})
	public String editAdmin() {
		return SUCCESS;
	}
	
	@WeaFunction(fname="删除苹果版本",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelApplevs")
	public String delAndroidvs() {
		String versionId = getRequestParamValue("versionId");
		iAppleVersionService.delAppleVs(Integer.parseInt(versionId));
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="苹果版本信息列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListApplevsData")
	public String listApplevsData() {
		
		WPage wpage = iAppleVersionService.getAppleVersions(appleSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("unused")
	@WeaFunction(fname="正在 添加苹果版本信息",oname=WeaFunction.Operation.CREATE)
	@Action(value="wAddapplevs")
	public String addapple() throws Exception {
			if (appleVersion.getRemark().trim().equals(null) || appleVersion.getRemark().trim().equals("")) {
				appleVersion.setRemark("无备注");
			}
			String fullPath=appleVersion.getFullPath();
			FileGenResult targetImgFileGenResult = iWFileUploadService.rename2TargetFile(fullPath);
			iAppleVersionService.addAppleVs(appleVersion);
		
		return JSONRESPONSE;
	}
	
	
	@WeaFunction(fname="到 苹果APP信息管理  页面",oname=WeaFunction.Operation.READ)
	@Action(value="wAppleInformation",results = { @Result(name = "success", type = "dispatcher",location="/admin/upgradeinformation/appleinformation.jsp")})
	public String appleInformation() {
		return SUCCESS;
	}
	
	
	@WeaFunction(fname="到 添加安卓版本信息 页面",oname=WeaFunction.Operation.READ)
	@Action(value="wAddappleversion",results = { @Result(name = "success", type = "dispatcher",location="/admin/upgradeinformation/addAppleversion.jsp")})
	public String addandroidversion() {
		return SUCCESS;
	}
	
	

}
