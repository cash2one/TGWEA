package com.etaoguan.wea.client.web.action.owner;

import java.io.File;
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
import com.etaoguan.wea.client.web.service.IWWechatMessageService;
import com.etaoguan.wea.client.web.vo.ImgNode;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WWechatMessageItem;
import com.etaoguan.wea.client.web.vo.WechatMessageSearch;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.vo.WechatMessage;

@SuppressWarnings("serial")
@WeaModule(mname="微站消息管理")
@Service("ownerWWechatMessageAction") @Scope("prototype")
public class WWechatMessageAction extends WOwnerBaseAction{

	@Resource(name="wwechatMessageService")
	private IWWechatMessageService iwWechatMessageService;
	
	private WechatMessageSearch wechatMessageSearch;
	
	private WechatMessage wechatMessage;
	
	private File imgFile; 
	
	private String imgFileFileContentType;  
	
    private String imgFileFileName;  
	
	private List<WWechatMessageItem> wwechatMessageItems;
	
	@WeaFunction(fname="搜索选择微站消息",oname=WeaFunction.Operation.READ)
	@Action(value="wListSearchWechatMessages",results = { @Result(name = "success", type = "dispatcher",location="/owner/select_wechatmsg.jsp")})
	public String listSearchWechatMessages() throws IOException {
		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="搜索选择微站消息",oname=WeaFunction.Operation.READ)
	@Action(value="wListSearchWechatMessagesData")
	public String listSearchWechatMessagesData() throws IOException {
		wechatMessageSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwWechatMessageService.listWechatMessages(wechatMessageSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="查看微站消息列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWechatMessages",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_wechatmessages.jsp")})
	public String listWechatMessages() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看微站消息列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWechatMessagesData")
	public String listWechatMessagesData() throws IOException {
		wechatMessageSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwWechatMessageService.listWechatMessages(wechatMessageSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取微站消息列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListWechatMessageSearchInitData")
	public String getListWechatMessageSearchInitData() throws IOException {
		Map initSearchDataMap = iwWechatMessageService.getListWechatMessagesSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="编辑微站消息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditWechatMessage",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_wechatmessage.jsp")})
	public String editWechatMessage() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="编辑微站消息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditWechatMessage")
	public String saveEditWechatMessage() throws IOException {
		wechatMessage.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwWechatMessageService.saveOrUpdateWechatMessage(wechatMessage, wwechatMessageItems);
		return JSONRESPONSE;
	}
	

	@WeaFunction(fname="更新微站消息概要及回复关联消息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUpdateWechatMessageSubjectNReplyKey")
	public String updateWechatMessageSubjectNReplyKey() throws IOException {
		iwWechatMessageService.updateWechatMessageSubjectNReplyKey(wechatMessage);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="上传微站消息图片",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUploadWechatMessageImg")
	public String uploadWechatMessageImg() throws IOException {
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		FileGenRequest fileGenRequest =  new FileGenRequest(imgFile,imgFileFileName);
		ImgNode imgNode = iwWechatMessageService.genWechatMessageTmpImgFile(fileGenRequest, ownerNum);
		weaResponse.setRespData(imgNode);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除微站消息",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelWechatMessage")
	public String delWechatMessage() throws IOException {
		String messageId = getRequestParamValue("messageId");
		iwWechatMessageService.delWechatMessage(Long.parseLong(messageId));
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取微站消息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetWechatMessageData")
	public String getWechatMessageData() throws IOException {
		String messageId = getRequestParamValue("messageId");
		Map dataMap = iwWechatMessageService.getWWechatMessageData(messageId);
		weaResponse.setRespData(dataMap);
		return JSONRESPONSE;
	}
	public WechatMessageSearch getWechatMessageSearch() {
		return wechatMessageSearch;
	}
	public void setWechatMessageSearch(WechatMessageSearch wechatMessageSearch) {
		this.wechatMessageSearch = wechatMessageSearch;
	}
	public WechatMessage getWechatMessage() {
		return wechatMessage;
	}
	public void setWechatMessage(WechatMessage wechatMessage) {
		this.wechatMessage = wechatMessage;
	}

	public File getImgFile() {
		return imgFile;
	}
	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}
	public String getImgFileFileContentType() {
		return imgFileFileContentType;
	}
	public void setImgFileFileContentType(String imgFileFileContentType) {
		this.imgFileFileContentType = imgFileFileContentType;
	}
	public String getImgFileFileName() {
		return imgFileFileName;
	}
	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}
	public List<WWechatMessageItem> getWwechatMessageItems() {
		return wwechatMessageItems;
	}
	public void setWwechatMessageItems(List<WWechatMessageItem> wwechatMessageItems) {
		this.wwechatMessageItems = wwechatMessageItems;
	}

}
