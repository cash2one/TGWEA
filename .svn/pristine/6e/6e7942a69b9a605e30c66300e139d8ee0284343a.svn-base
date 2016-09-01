package com.etaoguan.wea.client.web.service;

import com.etaoguan.wea.service.IWechatMassMsgRequestService;
import com.etaoguan.wea.wechat.vo.WechatMassMessage;
import com.etaoguan.wea.wechat.vo.WechatMassMsgRequest;

public interface IWWechatMassMsgRequestService extends IWechatMassMsgRequestService{
	/** 保存微信服务器返回的群发结果（第二次）
	 * @param wechatMassMsgRequest
	 */
	public void updateWWechatMassMsgRequest(WechatMassMsgRequest wechatMassMsgRequest);
	public void addWechatWMMR(WechatMassMessage wechatMassMessage,String accessToken,String ownerNum,long massMessageId);
	public void deleteWmmr(long massMessageId);
}
