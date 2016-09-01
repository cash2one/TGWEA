package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;

/**
 * @author cunli
 * 图文消息详情
 */
public interface IWechatPictureTextDao {  
	public void updateWechatPictureText(WechatMassMpnews wechatPictureText);
	/** 删除群发消息
	 * @param dataCriteria
	 */
	public void deleteWechatMassMpnews(DataCriteria dataCriteria);
	/**
	 * @param massMessageId
	 * @return 根据某次发送图文的id 获取详细信息
	 */
	public List<WechatMassMpnews> wechatPictureTexts(DataCriteria dataCriteria);
	
	/**添加 图文消息详情
	 * @param wechatPictureText
	 */
	public void addWechatPictureText(WechatMassMpnews wechatPictureText);
	
}
