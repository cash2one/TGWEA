package com.etaoguan.wea.client.mobile.action.common;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.action.MCommonBaseAction;
import com.etaoguan.wea.client.mobile.service.IMPaymentService;
import com.etaoguan.wea.wechat.vo.BrandWCPayRequest;


@SuppressWarnings("serial")
@Service("mpaymentCallbackAction") @Scope("prototype")
public class MPaymentCallbackAction extends MCommonBaseAction{
	
	private final static Log logger = LogFactory.getLog(MPaymentCallbackAction.class);

	@Autowired
	private IMPaymentService imPaymentService;
	
	private BrandWCPayRequest brandWCPayRequest;

	@SuppressWarnings("rawtypes")
	@Action(value="alipayWapCallback")
	public String alipayWapCallback() throws IOException {
		
		Map requestParams = getRequest().getParameterMap();
		logger.info("=========alipayWap Callback=========");
		imPaymentService.processAlipayWapResp(requestParams);
		
		writeResponse("success");
		
		return null;
	}

	
	@Action(value="wechatPayCallback")
	public String wechatPayCallback() throws IOException {

		logger.info("=========alipayWap Callback=========");
		imPaymentService.processWechatPayResp(getRequest());
		
		writeResponse("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
		
		return null;
	}
	
	/**
	 * @return 获取到用户的Openid和订单号，并执行支付
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@Action(value="getWechatAuthCode",results = { @Result(name = "success", type = "dispatcher",location="/wechat_pay.jsp")})
	public String getWechatAuthCode() throws IOException 
	{
			
		Map requestParams = getRequest().getParameterMap();
		
		/*微支付 付款*/
		brandWCPayRequest = imPaymentService.addWechatOrder(requestParams,getIpAddr(),getDomainBaseUrl());
		
		return SUCCESS;
	}


	public BrandWCPayRequest getBrandWCPayRequest() {
		return brandWCPayRequest;
	}


	public void setBrandWCPayRequest(BrandWCPayRequest brandWCPayRequest) {
		this.brandWCPayRequest = brandWCPayRequest;
	}
	
	
}
