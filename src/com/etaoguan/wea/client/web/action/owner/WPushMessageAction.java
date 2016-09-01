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
import com.etaoguan.wea.client.web.vo.PushMessageSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.PushMessage;


@WeaModule(mname="推送消息管理")
@Service("adminWPushMessageAction") @Scope("prototype")
public class WPushMessageAction extends WOwnerBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	@Resource(name="wpushMessageService")
	private IWPushMessageService iwPushMessageService;
	
	private PushMessageSearch pushMessageSearch;
	
	private PushMessage pushMessage;
	
	@WeaFunction(fname="查看推送消息列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListPushMessages",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_pushmessages.jsp")})
	public String listPushMessages() throws IOException {
		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看推送消息列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListPushMessagesData")
	public String listPushMessagesData() throws IOException {
		pushMessageSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwPushMessageService.listPushMessages(pushMessageSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取推送消息列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListPushMessagesSearchInitData")
	public String getListPushMessagesSearchInitData() throws IOException {
		Map initSearchDataMap = iwPushMessageService.getListPushMessagesSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	
	
	@WeaFunction(fname="修改推送消息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditPushMessage",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_pushmessage.jsp")})
	public String editPushMessage() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="修改推送消息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditPushMessage")
	public String saveEditPushMessage() throws IOException {
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		pushMessage.setOwnerNum(ownerNum);
		iwPushMessageService.saveOrUpdatePushMessage(pushMessage);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改推送时间",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUpdateSendTime")
	public String updateSendTime() throws IOException {
		iwPushMessageService.updatePushMessageSendTime(pushMessage.getMessageId(),pushMessage.getSendTime());
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取推送消息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditPushMessageInitData")
	public String getEditPushMessageInitData() throws IOException {
		String messageId = getRequestParamValue("messageId");
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		Map initMessageDataMap = iwPushMessageService.getEditPushMessageInitData(messageId,ownerNum);
		weaResponse.setRespData(initMessageDataMap);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取推送结果信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetPushMessageResults")
	public String getPushMessageResults() throws IOException {
		String messageId = getRequestParamValue("messageId");
		List PushMessageResults = iwPushMessageService.getPushMessageResults(Long.parseLong(messageId));
		weaResponse.setRespData(PushMessageResults);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除推送消息",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelPushMessage")
	public String delPushMessage() throws IOException {
		String messageId = getRequestParamValue("messageId");
		iwPushMessageService.delPushMessage(Long.parseLong(messageId));
		return JSONRESPONSE;
	}
	public PushMessageSearch getPushMessageSearch() {
		return pushMessageSearch;
	}
	public void setPushMessageSearch(PushMessageSearch pushMessageSearch) {
		this.pushMessageSearch = pushMessageSearch;
	}
	public PushMessage getPushMessage() {
		return pushMessage;
	}
	public void setPushMessage(PushMessage pushMessage) {
		this.pushMessage = pushMessage;
	}
}
