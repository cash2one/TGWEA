package com.etaoguan.wea.client.mobile.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.etaoguan.wea.client.mobile.vo.OrderPay;
import com.etaoguan.wea.client.mobile.vo.PayNav;
import com.etaoguan.wea.wechat.vo.BrandWCPayRequest;

public interface IMPaymentService{

	public PayNav processPayOrder(OrderPay orderPay,String domainBaseUrl);
	
	@SuppressWarnings("rawtypes")
	public void processAlipayWapResp(Map requestParams);
	
	public void processWechatPayResp(HttpServletRequest httpRequest);
	
	@SuppressWarnings("rawtypes")
	public BrandWCPayRequest addWechatOrder(Map requestParams, String ip,
			String domainBaseUrl);
	
	public String getWechatAssembleUrl(String orderNum, String domainBaseUrl);
}
