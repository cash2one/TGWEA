package com.etaoguan.wea.client.web.action.owner;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.wechat.vo.InboundRequest;
import com.etaoguan.wea.wechat.util.WeChatUtil;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWOwnerService;
import com.etaoguan.wea.client.web.service.IWWechatCallbackService;
import com.etaoguan.wea.common.WeaDataCache;

@Service("ownerWWechatCallbackAction") @Scope("prototype")
public class WWechatCallbackAction extends WOwnerBaseAction{

	private static final long serialVersionUID = 3584801772783753794L;
	
	String responseMsg = "";
	
	@Autowired
	private IWOwnerService iwOwnerService;

	@Autowired
	private IWWechatCallbackService iwWechatCallbackService;

	private final static Log logger = LogFactory.getLog(WWechatCallbackAction.class);
	
	
	@Action(value="wWechatCallback")
	public String wechatCallback() throws Exception{
		
		if(isGetRequest()){
			InboundRequest inboundRequest = new InboundRequest();
			inboundRequest.setNonce(getRequest().getParameter("nonce"));
			inboundRequest.setTimestamp(getRequest().getParameter("timestamp"));
			inboundRequest.setEchostr(getRequest().getParameter("echostr"));
			inboundRequest.setSignature(getRequest().getParameter("signature"));
			if(WeChatUtil.isWeChatRequest(inboundRequest)){
				responseMsg = inboundRequest.getEchostr();//原样返回echostr参数内容，则接入生效。
			}
			else{// 验证失败
				responseMsg = "verify failed!";
			}
		}
		else{
			//String ownerNum = getRequestParamValue("ownerNum");
			logger.info("******************************");
			logger.info("ownerNum = "+ownerNum);
			logger.info("******************************");
			boolean activeOwner = iwOwnerService.isActiveOwner(ownerNum);
			if(!activeOwner||!WeaDataCache.getCache().getOwnerSettingAllowWechat(ownerNum)){//ownerNum不存在或者权限不够
				responseMsg = "access forbidden";//禁止访问
			}else{

		        String wxMsgXml = IOUtils.toString(getRequest().getInputStream(),"utf-8");//获取微信发过来的请求字符串
		        responseMsg = iwWechatCallbackService.buildWechatSendMsg(ownerNum, getDomainBaseUrl(), wxMsgXml);//进行解析判断
		        
			}
		}
		logger.info(responseMsg);
		writeResponse(responseMsg);
		return null;
	}
	
}
