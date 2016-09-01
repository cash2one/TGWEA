package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWPushMessageService;
import com.etaoguan.wea.client.web.vo.JpushKeysSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.JpushKeys;

@WeaModule(mname="极光推送企业管理")
@Service("adminWJpushKeysAction") @Scope("prototype")
public class WJpushKeysAction extends WCommonBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	@Resource(name="wpushMessageService")
	private IWPushMessageService iwPushMessageService;
	
	private JpushKeys jpushKeys;

	private JpushKeysSearch jpushKeysSearch = new JpushKeysSearch();

	
	@WeaFunction(fname="查看极光推送企业列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListJpushKeys",results = { @Result(name = "success", type = "dispatcher",location="/admin/list_jpushkeys.jsp")})
	public String listJpushKeys() throws IOException {
		return SUCCESS;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看极光推送企业列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListJpushKeysData")
	public String listJpushKeysData() throws IOException {
		WPage wpage = iwPushMessageService.listJpushKeys(jpushKeysSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改极光推送企业信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditJpushKeys",results = { @Result(name = "success", type = "dispatcher",location="/admin/edit_jpushkeys.jsp")})
	public String editJpushKeys() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="修改极光推送企业信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditJpushKeys")
	public String saveEditJpushKeys() throws IOException {

		iwPushMessageService.updateJpushKeys(jpushKeys);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="新增极光推送企业信息",oname=WeaFunction.Operation.CREATE)
	@Action(value="wSaveAddJpushKeys")
	public String saveAddJpushKeys() throws IOException {

		iwPushMessageService.addJpushKeys(jpushKeys);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取极光推送企业信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditJpushKeysInitData")
	public String getEditJpushKeysInitData() throws IOException {
		String ownerNum = getRequestParamValue("ownerNum");
		Map initJpushKeysDataMap = iwPushMessageService.getEditJpushKeysInitData(ownerNum);
		weaResponse.setRespData(initJpushKeysDataMap);
		return JSONRESPONSE;
	}
	
	
	@WeaFunction(fname="删除极光推送企业信息",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelJpushKeys")
	public String delJpushKeys() throws IOException {
		String ownerNum = getRequestParamValue("ownerNum");
		iwPushMessageService.delJpushKeys(ownerNum);
		return JSONRESPONSE;
	}

	public JpushKeys getJpushKeys() {
		return jpushKeys;
	}

	public void setJpushKeys(JpushKeys jpushKeys) {
		this.jpushKeys = jpushKeys;
	}

	public JpushKeysSearch getJpushKeysSearch() {
		return jpushKeysSearch;
	}

	public void setJpushKeysSearch(JpushKeysSearch jpushKeysSearch) {
		this.jpushKeysSearch = jpushKeysSearch;
	}
	
	

}
