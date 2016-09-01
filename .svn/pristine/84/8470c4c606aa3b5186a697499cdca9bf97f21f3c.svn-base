package com.etaoguan.wea.client.web.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.ImgNode;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WWechatMessageItem;
import com.etaoguan.wea.client.web.vo.WechatMessageSearch;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.service.IWechatMessageService;
import com.etaoguan.wea.vo.WechatMessage;

public interface IWWechatMessageService extends IWechatMessageService{
	
	@SuppressWarnings("rawtypes")
	public WPage listWechatMessages(WechatMessageSearch wechatMessageSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);
	
	public ImgNode genWechatMessageTmpImgFile(FileGenRequest fileGenRequest,
			String ownerNum) throws IOException;
	
	public void saveOrUpdateWechatMessage(WechatMessage wechatMessage,List<WWechatMessageItem> wWechatMessageItems);
	
	@SuppressWarnings("rawtypes")
	public Map getListWechatMessagesSearchInitData(String ownerNum);
	
	@SuppressWarnings("rawtypes")
	public Map getWWechatMessageData(String messageId);
	
	public void updateWechatMessageSubjectNReplyKey(WechatMessage wechatMessage);
}
