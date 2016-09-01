package com.etaoguan.wea.dao;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.WechatMessageData;
import com.etaoguan.wea.vo.WechatMessage;

public interface IWechatMessageDao {
	
	/**
	 * @param wechatMessage
	 * @return 检查消息要不要转发给多客服
	 */
	public int getWechatMsgCount(DataCriteria dataCriteria);
	
	public long addWechatMessage(WechatMessage wechatMessage);
	
	public void addWechatMessageData(WechatMessageData wechatMessageData);
	
	public void updateWechatMessage(WechatMessage wechatMessage);
	
	public void updateWechatMessage(DataCriteria dataCriteria);
	
	public void delWechatMessage(DataCriteria dataCriteria);
	
	public void delWechatMessageData(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getWechatMessages(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public int getMaxWechatMessageDataItemNum(DataCriteria dataCriteria);
	
	public WechatMessage getWechatMessage(DataCriteria dataCriteria);

}
