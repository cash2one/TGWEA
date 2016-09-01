package com.etaoguan.wea.dao;

import com.etaoguan.wea.wechat.vo.WechatpayResult;

/**
 * @author cunli
 * 微信异步返回的信息
 */
public interface IWechatpayResultDao {

	/**
	 * @param wechatpayResult 保存微信异步返回的信息
	 */
	public int saveWechatpayResult(WechatpayResult wechatpayResult);
}
