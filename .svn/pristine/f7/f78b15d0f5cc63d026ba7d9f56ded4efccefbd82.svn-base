package com.etaoguan.wea.service.impl;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jpush.api.utils.StringUtils;

import com.etaoguan.wea.client.web.service.IWOrderService;
import com.etaoguan.wea.dao.IOrderPayInfoDao;
import com.etaoguan.wea.dao.IWechatpayRequestDao;
import com.etaoguan.wea.dao.IWechatpayResultDao;
import com.etaoguan.wea.service.IWechatKeysService;
import com.etaoguan.wea.service.IWechatPayKeysService;
import com.etaoguan.wea.service.IWechatPaymentService;
import com.etaoguan.wea.util.WechatOrderXml;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.OrderPayInfo;
import com.etaoguan.wea.vo.WechatKeys;
import com.etaoguan.wea.vo.WechatPayKeys;
import com.etaoguan.wea.wechat.util.PostXml;
import com.etaoguan.wea.wechat.util.ResultCode;
import com.etaoguan.wea.wechat.util.WeChatXppDriver;
import com.etaoguan.wea.wechat.util.WechatPictureTextUtil;
import com.etaoguan.wea.wechat.vo.BrandWCPayRequest;
import com.etaoguan.wea.wechat.vo.WechatpayRequest;
import com.etaoguan.wea.wechat.vo.WechatpayResult;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author cunli 微信异步返回的信息
 *
 */
@Service("wechatPaymentService")
public class WechatPaymentService extends BaseService implements IWechatPaymentService{
	
	private final static Log logger = LogFactory.getLog(WechatPaymentService.class);
	
	@Autowired
	private IWechatpayResultDao iWechatpayResultDao;
	
	@Autowired
	private IOrderPayInfoDao iOrderPayInfoDao;
	
	@Autowired
	private IWechatpayRequestDao iWechatpayRequestDao;
	
	@Resource(name="wechatPayKeysService")
	private IWechatPayKeysService iWechatPayKeysService;
	
	@Resource(name="worderService")
	private IWOrderService iwOrderService;
	
	@Resource(name="wechatKeysService")
	private IWechatKeysService iWechatKeysService;
	
	SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
	String strTime = f.format(new Date());
	
	
	@Override
	public void saveWechatpayRequest(WechatpayRequest wechatpayRequest) {
		iWechatpayRequestDao.saveWechatpayRequest(wechatpayRequest);
	}
	
	/* (non-Javadoc)保存微信异步返回的信息
	 * @see com.etaoguan.wea.service.IWechatpayResultService#saveWechatpayResult(com.etaoguan.wea.wechat.vo.WechatpayResult)
	 */
	@Override
	public void saveWechatpayResult(String resultData) {
		WechatpayResult wechatpayResult = new WechatpayResult();      

		XStream xstreamResult=new XStream(new DomDriver());
		
		xstreamResult.processAnnotations(ResultCode.class); //如果是用注解的方式，这句不能少
		ResultCode resultCode=(ResultCode)xstreamResult.fromXML(resultData);
		
		String returnCode="";
		double totalFee=0;
		String transactionId="";
		String timeEnd="";
		
		returnCode = resultCode.getReturn_code();
		totalFee = Double.valueOf(resultCode.getTotal_fee());

		transactionId=resultCode.getTransaction_id();
		timeEnd=resultCode.getTime_end();
		
		
		wechatpayResult.setReturnCode(returnCode);
		wechatpayResult.setTotalFee(totalFee);
		wechatpayResult.setNotifyData(resultData);
		wechatpayResult.setTransactionId(transactionId);
		wechatpayResult.setTimeEnd(timeEnd);
		
		String outTradeNo = resultCode.getOut_trade_no();
		wechatpayResult.setOutTradeNo(outTradeNo);
		
		String realOutTradeNo = outTradeNo.split("_")[0];
		
		int resultId = iWechatpayResultDao.saveWechatpayResult(wechatpayResult);//保存异步返回的数据
		
		if (resultId > 0) {
			
			String[] attach = resultCode.getAttach().split("_"); 
			String ownerNum = attach[0];
			String custNum = attach[1];
			
			OrderPayInfo orderPayInfo = new OrderPayInfo();
			orderPayInfo.setOrderNum(realOutTradeNo);
			orderPayInfo.setOwnerNum(ownerNum);
			orderPayInfo.setCustNum(custNum);
			orderPayInfo.setPayType(1);//微信支付
			orderPayInfo.setPayTransId(resultId);
			orderPayInfo.setCreateBy("微支付");
			
			iOrderPayInfoDao.saveOrderPayInfoDao(orderPayInfo);
		}
		
	}



	
	/* (non-Javadoc)创建微信订单
	 * @see com.etaoguan.wea.client.web.service.IWWechatOrderService#addWechatOrder(com.etaoguan.wea.vo.WechatOrder)
	 */
	@Override
	@SuppressWarnings({ "unused", "rawtypes" })
	public BrandWCPayRequest addWechatOrder(Map requestParams,String ip,String domainBaseUrl) {
		String code = ((String[])requestParams.get("code"))[0];
		String state = ((String[])requestParams.get("state"))[0];
		
		BrandWCPayRequest brandWCPayRequest = new BrandWCPayRequest();
		/*
		1.拆分state,获取参数
		2.获取openid
		3.创建微信订单并保存到数据库wechat_order表中，然后发送这个给微信
		4.发送创建的订单并保存返回结果到数据库*/
		
		
		String[] var = state.split("_");
		
		String realOrderNum = var[0];
		String orderNum = realOrderNum+"_"+String.valueOf(Math.random()).substring(3);
		String realPriceTotal = var[1];
		String ownerNum = var[2];
		String secret = var[3];
		String appid = var[4];
		String custNum = var[5];
		String attach =ownerNum+"_"+custNum;
		
		WechatPayKeys wechatPayKeys = iWechatPayKeysService.wechatPayKeysInformation(ownerNum);
		String key = wechatPayKeys.getPayKey();//微信支付的key
		String mchId = wechatPayKeys.getMchId();//微信支付分配的商户号
		
			
		String v1 = String.valueOf(Double.parseDouble(realPriceTotal) * 100);//以分计算
		int totalFee = Integer.parseInt(v1.substring(0,v1.indexOf(".")));
		String body = "订单："+realOrderNum;
		
		String outTradeNo = strTime + String.valueOf(Math.random()).substring(2,10);
		
		
		/*获取openid*/
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
			
		
		
		/*获取客户端ip*/
			
		Map<String, Object> resultOfMap = WechatPictureTextUtil.SendURLPost("",url);
		
		String openid  = resultOfMap.get("openid").toString();
		
		if(StringUtils.isEmpty(openid)){
			logger.error("==========get openid failed==========");
			brandWCPayRequest.setStatus("E");
	       	brandWCPayRequest.setErrorMessage("get openid failed");
	       	return brandWCPayRequest;
		}
	
    
		String tradeType = "JSAPI";
		String nonceStr = String.valueOf(Math.random()).substring(7);
		String notifyUrl = domainBaseUrl+"common/wechatPayCallback.action";//接收微信支付异步通知回调地址 
		
		/*生成签名*/
		Map<String, String> singMap = new HashMap<String, String>();
		singMap.put("appid", appid);
		singMap.put("attach", attach);
		singMap.put("body", body);
		singMap.put("mch_id", mchId);
		singMap.put("nonce_str", nonceStr);
		singMap.put("notify_url", notifyUrl);
		singMap.put("openid", openid);
		singMap.put("out_trade_no", orderNum);
		singMap.put("spbill_create_ip", ip);
		singMap.put("trade_type", tradeType);
		singMap.put("total_fee", String.valueOf(totalFee));
		
		
		String[] asc = new String[]{"appid", "attach", "body", "mch_id", "nonce_str", "notify_url", "openid", "out_trade_no", "spbill_create_ip", "trade_type", "total_fee"};
		
		Arrays.sort(asc);
		String urlTmp = "";
		for (int i = 0; i < asc.length; i++) {
			urlTmp+=asc[i]+"="+singMap.get(asc[i])+"&";
		}
		String stringSignTemp = urlTmp+"key="+key;
	
		String sign = DigestUtils.md5Hex(stringSignTemp).toUpperCase();

		
		if(StringUtils.isEmpty(sign)){
			logger.error("==========generate sign failed==========");
			brandWCPayRequest.setStatus("E");
	       	brandWCPayRequest.setErrorMessage("generate sign failed");
	       	return brandWCPayRequest;
		}
		
		
		/*生成xml数据*/
		XStream xstream = new XStream(new WeChatXppDriver());
		xstream.alias("xml", WechatOrderXml.class);
		
		WechatOrderXml wechatOrderXml = new WechatOrderXml();
		wechatOrderXml.setAppid(appid);
		wechatOrderXml.setAttach(attach);
		wechatOrderXml.setBody(body);
		wechatOrderXml.setMch_id(mchId);//调用接口提交的商户号
		wechatOrderXml.setNonce_str(nonceStr);//最多32位的随机字符串
		wechatOrderXml.setNotify_url(notifyUrl);//接收微信支付异步通知回调地址
		wechatOrderXml.setOpenid(openid);
		wechatOrderXml.setOut_trade_no(orderNum);//商户系统内部的订单号,32个字符内
		wechatOrderXml.setSpbill_create_ip(ip);//APP和网页支付提交用户端ip
		wechatOrderXml.setTotal_fee(String.valueOf(totalFee));//订单总金额，只能为整数
		wechatOrderXml.setTrade_type(tradeType);
		wechatOrderXml.setSign(sign);//签名
		

		String content = xstream.toXML(wechatOrderXml).replaceAll("__", "_");
		
			String urlStr="https://api.mch.weixin.qq.com/pay/unifiedorder";
			String json = "";
			try {
				
				json = PostXml.sendXMLDataByPost(urlStr, content);

			} catch (Exception e) {
				logger.info("************获取微信prepayId出错***************");	
			}
			
			
			XStream xstreamResult=new XStream(new DomDriver());
			
			xstreamResult.processAnnotations(ResultCode.class); //如果是用注解的方式，这句不能少
			
			ResultCode resultCode=(ResultCode)xstreamResult.fromXML(json);
			
			String	return_code  = resultCode.getReturn_code();
			

			String returnMsg   = "";
			String result_code  = "";
			String prepayId  = "";
			String result_sign  = "";
			
			 String err_code = "";
			 String err_code_des = "";
			 
		if (return_code.equals("SUCCESS")) {
			
			appid  = resultCode.getAppid();
			mchId  = resultCode.getMch_id();
			result_sign  = resultCode.getSign();
			return_code  = resultCode.getReturn_code();
			result_code = resultCode.getResult_code();
			
			if (result_code.equals("SUCCESS")) {
				tradeType  = resultCode.getTrade_type();
				prepayId  = resultCode.getPrepay_id();
			}else {
				 err_code = resultCode.getErr_code();
				 err_code_des = resultCode.getErr_code_des();
			}
			
		}else {
			returnMsg = resultCode.getReturn_msg();
		}
		
		
		 
		if (return_code.equals("FAIL")) {
       	 logger.info("returnMsg = "+returnMsg);	
       	 brandWCPayRequest.setStatus("E");
       	 brandWCPayRequest.setErrorMessage(returnMsg);
		}else {
			long timeStamp = System.currentTimeMillis();
			String packageStr = "prepay_id="+prepayId;  
			
			/*生成签名*/
			Map<String, String> paySignMap = new HashMap<String, String>();
			paySignMap.put("appId", appid);
			paySignMap.put("timeStamp", String.valueOf(timeStamp));
			paySignMap.put("nonceStr", nonceStr);
			paySignMap.put("package", packageStr);
			paySignMap.put("signType", "MD5");
			
			
			String[] paySingArry = new String[]{"appId", "timeStamp", "nonceStr", "package", "signType"};
			
			Arrays.sort(paySingArry);
			String payStr = "";
			for (int i = 0; i < paySingArry.length; i++) {
				payStr+=paySingArry[i]+"="+paySignMap.get(paySingArry[i])+"&";
			}
			String unPaySign = payStr+"key="+key;
			
			
			String paySign = "";
			
	                 try {
	                	 paySign = DigestUtils.md5Hex(unPaySign).toUpperCase();
					} catch (Exception e) {

						e.printStackTrace();
					}
			
	                 
	                
	                 if (result_code.equals("FAIL")) {
	                	 brandWCPayRequest.setStatus("E");
	                	 brandWCPayRequest.setErrorMessage(err_code_des);
					}else {

						brandWCPayRequest.setAppid(appid);
						brandWCPayRequest.setTimeStamp(String.valueOf(timeStamp));
						brandWCPayRequest.setNonceStr(nonceStr);
						brandWCPayRequest.setPackageStr(packageStr);
						brandWCPayRequest.setPaySign(paySign);
						brandWCPayRequest.setRealPriceTotal(realPriceTotal);
						
						WechatpayRequest wechatpayRequest = new WechatpayRequest();
						wechatpayRequest.setAppid(appid);
						wechatpayRequest.setMchId(mchId);
						wechatpayRequest.setOutTradeNo(orderNum);
						wechatpayRequest.setTotalFee(totalFee);
						wechatpayRequest.setSpbillCreateIp(ip);
						wechatpayRequest.setOpenid(openid);
						wechatpayRequest.setReqData(content);//提交的数据
						
						iWechatpayRequestDao.saveWechatpayRequest(wechatpayRequest);
					}
	                 
		}
		
		return brandWCPayRequest;
	}

	/* (non-Javadoc) 组合授权地址
	 * @see com.etaoguan.wea.service.IPaymentInfoService#assembleUrl(java.lang.String)
	 */
	@Override
	public String getAssembleUrl(String orderNum,String domainBaseUrl) {
		
		Order order = iwOrderService.getOrder(orderNum);
		
		String ownerNum = order.getOwnerNum();
		WechatKeys wechatKeys = iWechatKeysService.getWechatKeys(ownerNum);
		
		String appid = wechatKeys.getAppId();
		String secret = wechatKeys.getAppSecret();
		
		String redirectUri="";
		try {
			
			String URL= domainBaseUrl+"common/getWechatAuthCode.action";
			redirectUri= URLEncoder.encode(URL, "utf-8");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		   /*组合这个属性           0 订单号                             1 真是价格                                                         2ownerNum    3secret    4appid    5custNum*/
		String state = orderNum+"_"+order.getRealPriceTotal()+"_"+ownerNum+"_"+secret+"_"+appid+"_"+order.getCustNum();
		
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+redirectUri+"&response_type=code&scope=snsapi_base&state="+state+"#wechat_redirect";

		return url;
	}

}
