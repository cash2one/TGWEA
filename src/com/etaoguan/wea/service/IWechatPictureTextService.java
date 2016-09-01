package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.wechat.vo.WechatMassMpnews;


/**
 * @author cunli
 * 图文消息详情
 */
public interface IWechatPictureTextService {
	public void updateWechatPictureText(WechatMassMpnews wechatPictureText);
	/** 删除群发消息
	 * @param dataCriteria
	 */
	public void deleteWechatMassMpnews(long massMessageId);
	/**
	 * @param massMessageId
	 * @return 根据某次发送图文的id 获取详细信息
	 */
	public List<WechatMassMpnews> wechatPictureTexts(long massMessageId);
	/**添加 图文消息详情
	 * @param wechatPictureText
	 */
	public void addWechatPictureText(WechatMassMpnews wechatPictureText);
	
}
