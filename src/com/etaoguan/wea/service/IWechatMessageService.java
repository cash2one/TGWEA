package com.etaoguan.wea.service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.WechatMessage;

public interface IWechatMessageService {
	/**
	 * @param wechatMessage
	 * @return 检查消息要不要转发给多客服
	 */
	public boolean isManyCustomerMsg(String ownerNum,String replyKey);
	
	public void addWechatMessage(WechatMessage wechatMessage);
	
	public void updateWechatMessage(WechatMessage wechatMessage);
	
	public void updateWechatMessageSubjectNReplyKey(long messageId,String subject,String replyKey);
	
	public void delWechatMessage(long messageId);
	
	@SuppressWarnings("rawtypes")
	public DataSet listWechatMessages(DataCriteria dataCriteria,OffsetRequest offsetRequest);

	public int getMaxWechatMessageDataItemNum(long messageId);
	
	public WechatMessage getWechatMessage(long messageId);
	
	public WechatMessage getWechatMessage(String ownerNum,String replyKey);
}
