package com.etaoguan.wea.dao;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.wechat.vo.WechatMassMessage;

/**
 * @author cunli
 * 微信群发消息
 */
public interface IWechatMassMessageDao {
	
	/** 删除群发消息
	 * @param dataCriteria
	 */
	public void deleteWechatMassMessage(DataCriteria dataCriteria);
	
	/**
	 * @param massMessageId
	 * @return 根据Id获取要发送所需要的mediaId
	 */
	public WechatMassMessage getMassMessageById(DataCriteria dataCriteria);
	
	public int addWechatMassMessage(WechatMassMessage wechatMassMessage);
	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 图文消息列表
	 */
	@SuppressWarnings("rawtypes")
	public DataSet getWechatMassMessage(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	/** save massMEssageId to dataBase
	 * @param massMessageId
	 */
	public void updateWechatMassMessage(DataCriteria dataCriteria);
	
}
