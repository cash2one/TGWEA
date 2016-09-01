package com.etaoguan.wea.service;

import com.etaoguan.wea.wechat.vo.WechatMassMsgRequest;


/**
 * @author cunli
 * 微信群发后的结果
 */
public interface IWechatMassMsgRequestService {
	/** 删除群发消息
	 * @param dataCriteria 
	 */
	void deleteWechatMassMsgRequest(long massMessageId);
	/** 保存微信服务器返回的群发结果（第二次）
	 * @param wechatMassMsgRequest
	 */
	public void updateWechatMassMsgRequest(WechatMassMsgRequest wechatMassMsgRequest);
	/** 保存群发结果
	 * @param wechatMassMsgRequest
	 */
	public void addWechatMassMsgRequest(WechatMassMsgRequest wechatMassMsgRequest);
}
