package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWPushMessageService;
import com.etaoguan.wea.client.web.vo.WPushGroup;
import com.etaoguan.wea.vo.PushGroup;


@WeaModule(mname="推送组管理")
@Service("adminWPushGroupAction") @Scope("prototype")
public class WPushGroupAction extends WOwnerBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	@Resource(name="wpushMessageService")
	private IWPushMessageService iwPushMessageService;
	
	private WPushGroup wpushGroup;
	
	@WeaFunction(fname="查看推送组列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListPushGroups",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_pushgroups.jsp")})
	public String listPushGroups() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="查看推送组列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListPushGroupsData")
	public String listGroupsData() throws IOException {
		List<PushGroup>  pushGroupList = iwPushMessageService.getAllPushGroups(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRows(pushGroupList);
		weaResponse.setTotal(pushGroupList.size());
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改推送组",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditPushGroup",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_pushgroup.jsp")})
	public String editPushGroup() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="修改推送组",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditPushGroup")
	public String saveEditPushGroup() throws IOException {
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		wpushGroup.getPushGroup().setOwnerNum(ownerNum);
		iwPushMessageService.saveOrUpdatePushGroup(wpushGroup);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取推送组信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditPushGroupInitData")
	public String getEditPushGroupInitData() throws IOException {
		String groupNum = getRequestParamValue("groupNum");
		Map initGroupDataMap = iwPushMessageService.getEditPushGroupInitData(groupNum);
		weaResponse.setRespData(initGroupDataMap);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取推送组客户信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetPushGroupCusts")
	public String getPushGroupCusts() throws IOException {
		String groupNum = getRequestParamValue("groupNum");
		List custList = iwPushMessageService.getPushGroupCusts(groupNum);
		weaResponse.setRespData(custList);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除推送组",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelPushGroup")
	public String delPushGroup() throws IOException {
		String groupNum = getRequestParamValue("groupNum");
		iwPushMessageService.delPushGroup(groupNum);
		return JSONRESPONSE;
	}
	public WPushGroup getWpushGroup() {
		return wpushGroup;
	}
	public void setWpushGroup(WPushGroup wpushGroup) {
		this.wpushGroup = wpushGroup;
	}
	
}
