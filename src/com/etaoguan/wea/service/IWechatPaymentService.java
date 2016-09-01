package com.etaoguan.wea.service;

import java.util.Map;

import com.etaoguan.wea.wechat.vo.BrandWCPayRequest;
import com.etaoguan.wea.wechat.vo.WechatpayRequest;

/**
 * @author cunli 微信异步返回的信息
 *
 */
public interface IWechatPaymentService {

	/**
	 * @param wechatpayResult 保存微信异步返回的信息
	 */
	public void saveWechatpayResult(String resultData);
	
	public void saveWechatpayRequest(WechatpayRequest wechatpayRequest);
	
	/**
	 * @param orderNum 订单编号
	 * @return 组合授权地址
	 */
	public String getAssembleUrl(String orderNum,String domainBaseUrl);
	/**
	 * @param wechatOrder 创建微信订单
	 */
	@SuppressWarnings("rawtypes")
	public BrandWCPayRequest addWechatOrder(Map requestParams,String ip,String domainBaseUrl);
}
