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
import com.etaoguan.wea.client.web.service.IWAlipayKeysService;
import com.etaoguan.wea.client.web.service.IWWechatKeysService;
import com.etaoguan.wea.client.web.service.IWWechatPayKeysService;
import com.etaoguan.wea.client.web.vo.AlipayKeysSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WechatKeysSearch;
import com.etaoguan.wea.client.web.vo.WechatPayKeysSearch;
import com.etaoguan.wea.vo.AlipayKeys;
import com.etaoguan.wea.vo.WechatKeys;
import com.etaoguan.wea.vo.WechatPayKeys;

@WeaModule(mname="微信企业管理")
@Service("adminWWechatKeysAction") @Scope("prototype")
public class WWechatKeysAction extends WCommonBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	@Resource(name="wwechatKeysService")
	private IWWechatKeysService iwWechatKeysService;
	
	@Resource(name="walipayKeysService")
	private IWAlipayKeysService iwAlipayKeysService;
	
	private WechatKeys wechatKeys;
	
	private AlipayKeys alipayKeys;
	
	private WechatPayKeys wechatPayKeys;
	
	public WechatPayKeys getWechatPayKeys() {
		return wechatPayKeys;
	}

	public void setWechatPayKeys(WechatPayKeys wechatPayKeys) {
		this.wechatPayKeys = wechatPayKeys;
	}

	AlipayKeysSearch alipayKeysSearch = new AlipayKeysSearch();
	
	WechatPayKeysSearch wechatPayKeysSearch = new WechatPayKeysSearch();
	
	@Resource(name="wwechatPayKeysService")
	private IWWechatPayKeysService iwWechatPayKeysService;

	
	public WechatPayKeysSearch getWechatPayKeysSearch() {
		return wechatPayKeysSearch;
	}

	public void setWechatPayKeysSearch(WechatPayKeysSearch wechatPayKeysSearch) {
		this.wechatPayKeysSearch = wechatPayKeysSearch;
	}

	public AlipayKeysSearch getAlipayKeysSearch() {
		return alipayKeysSearch;
	}

	public void setAlipayKeysSearch(AlipayKeysSearch alipayKeysSearch) {
		this.alipayKeysSearch = alipayKeysSearch;
	}

	public AlipayKeys getAlipayKeys() {
		return alipayKeys;
	}

	public void setAlipayKeys(AlipayKeys alipayKeys) {
		this.alipayKeys = alipayKeys;
	}

	private WechatKeysSearch wechatKeysSearch = new WechatKeysSearch();
	
	
	@WeaFunction(fname="添加 微信支付key信息",oname=WeaFunction.Operation.CREATE)
	@Action(value="wAddWechatPayKeys")
	public String addWechatPayKeys() throws IOException {
		String adminName = getCurrentAdmin().getAdminName();
		iwWechatPayKeysService.addPayKeys(wechatPayKeys,adminName);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="去添加 微信支付key信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGoAddWechatPayKeys",results = { @Result(name = "success", type = "dispatcher",location="/admin/wechatPayKeys/add_wechat_pay_keys.jsp")})
	public String goAddWechatPayKeys() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="修改微信支付key信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUpdateWechatPayKeys")
	public String updateWechatPayKeys() {
		String adminName = getCurrentAdmin().getAdminName();
		iwWechatPayKeysService.updatePayKeys(wechatPayKeys,adminName);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除微信支付key信息",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelWechatPayKeys")
	public String delWechatPayKeys() throws IOException {
		String ownerNum = getRequestParamValue("ownerNum");
		iwWechatPayKeysService.deletePayKeys(ownerNum);
		return JSONRESPONSE;
	}
	
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="微信支付key列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWechatPayKeysData")
	public String listWechatPayKeysData() throws IOException {
		
		WPage wpage = iwWechatPayKeysService.payKeysDataSet(wechatPayKeysSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="查看微信支付key列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWechatPayKeys",results = { @Result(name = "success", type = "dispatcher",location="/admin/wechatPayKeys/wechat_pay_keys.jsp")})
	public String listWechatPayKeys() throws IOException {
		return SUCCESS;
	}
	
//	****************************************************************************************
	
	@WeaFunction(fname="添加 支付宝key信息",oname=WeaFunction.Operation.CREATE)
	@Action(value="wAddAlipayKeys")
	public String addAlipayKeys() throws IOException {
		iwAlipayKeysService.addKeys(alipayKeys);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="去添加 支付宝key信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGoAddAlipaykeys",results = { @Result(name = "success", type = "dispatcher",location="/admin/alipayKeys/add_alipaykeys.jsp")})
	public String goAddAlipaykeys() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="修改支付宝key信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUpdateKeys")
	public String updateKeys() {
		iwAlipayKeysService.updatekeys(alipayKeys);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除支付宝key信息",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelAlipayDeys")
	public String delAlipayDeys() throws IOException {
		String id = getRequestParamValue("id");
		iwAlipayKeysService.deleteKeys(id);
		return JSONRESPONSE;
	}

	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="支付宝key列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListkeysData")
	public String listkeysData() throws IOException {
		WPage wpage = iwAlipayKeysService.keysDataSet(alipayKeysSearch,sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="查看支付宝key列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListAlipaykeys",results = { @Result(name = "success", type = "dispatcher",location="/admin/alipayKeys/alipay_keys.jsp")})
	public String listOwners() throws IOException {
		return SUCCESS;
	}
	
	
	@WeaFunction(fname="查看微信企业列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWechatKeys",results = { @Result(name = "success", type = "dispatcher",location="/admin/list_wechatkeys.jsp")})
	public String listWechatKeys() throws IOException {
		return SUCCESS;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看微信企业列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWechatKeysData")
	public String listWechatKeysData() throws IOException {
		WPage wpage = iwWechatKeysService.listWechatKeys(wechatKeysSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改微信企业信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditWechatKeys",results = { @Result(name = "success", type = "dispatcher",location="/admin/edit_wechatkeys.jsp")})
	public String editWechatKeys() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="修改微信企业信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditWechatKeys")
	public String saveEditWechatKeys() throws IOException {

		iwWechatKeysService.updateWechatKeys(wechatKeys);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="新增微信企业信息",oname=WeaFunction.Operation.CREATE)
	@Action(value="wSaveAddWechatKeys")
	public String saveAddWechatKeys() throws IOException {

		iwWechatKeysService.addWechatKeys(wechatKeys);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取微信企业信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditWechatKeysInitData")
	public String getEditWechatKeysInitData() throws IOException {
		String ownerNum = getRequestParamValue("ownerNum");
		Map initWechatKeysDataMap = iwWechatKeysService.getEditWechatKeysInitData(ownerNum);
		weaResponse.setRespData(initWechatKeysDataMap);
		return JSONRESPONSE;
	}
	
	
	@WeaFunction(fname="删除微信企业信息",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelWechatKeys")
	public String delWechatKeys() throws IOException {
		String ownerNum = getRequestParamValue("ownerNum");
		iwWechatKeysService.delWechatKeys(ownerNum);
		return JSONRESPONSE;
	}

	public WechatKeys getWechatKeys() {
		return wechatKeys;
	}

	public void setWechatKeys(WechatKeys wechatKeys) {
		this.wechatKeys = wechatKeys;
	}

	public WechatKeysSearch getWechatKeysSearch() {
		return wechatKeysSearch;
	}

	public void setWechatKeysSearch(WechatKeysSearch wechatKeysSearch) {
		this.wechatKeysSearch = wechatKeysSearch;
	}

	

}
