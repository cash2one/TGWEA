package com.etaoguan.wea.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.CustomMessageParams;
import cn.jpush.api.push.MessageParams;
import cn.jpush.api.push.MessageResult;
import cn.jpush.api.push.NotificationParams;
import cn.jpush.api.push.ReceiverTypeEnum;

import com.etaoguan.wea.vo.PushMessage;
import com.etaoguan.wea.vo.PushMessageExtra;
import com.etaoguan.wea.vo.PushMessageResult;

public class JpushUtils {

	private final static Log logger = LogFactory.getLog(JpushUtils.class);
	
	private static Map<String,JPushClient> JPUSHCLIENTMAP= new HashMap<String,JPushClient>();
	
	public static PushMessageResult startPushMessage(PushMessage pushMessage){
		pushMessage.setTargetId(pushMessage.getTargetId().replace("-", "_"));
		int messageType = pushMessage.getMessageType();
		PushMessageResult pushMessageResult = null;
		if(messageType==0){
			pushMessageResult = pushNotification(pushMessage);
		}
		if(messageType==1){
			pushMessageResult = pushCustomMessage(pushMessage);
		}
		return pushMessageResult;
	}
	
	private static synchronized JPushClient getOwnerJPushClient(String ownerNum,String masterSecret,String appKey){
		JPushClient jPushClient = JPUSHCLIENTMAP.get(ownerNum);
		if(jPushClient == null){
//			jPushClient = new JPushClient(masterSecret, appKey, 0, DeviceEnum.Android, false);
			jPushClient = new JPushClient(masterSecret, appKey);
		}
		return jPushClient;
	}
	
	
	private static void setParamsReceiverType(int targetType,MessageParams messageParams){
		
		switch(targetType){
			case 0:
				messageParams.setReceiverType(ReceiverTypeEnum.APP_KEY);
				break;
			case 1:
				messageParams.setReceiverType(ReceiverTypeEnum.TAG);
				break;
			case 2:
				messageParams.setReceiverType(ReceiverTypeEnum.ALIAS);
				break;
			default:
				messageParams.setReceiverType(ReceiverTypeEnum.APP_KEY);
		}
		
	}
	
	private static PushMessageResult pushNotification(PushMessage pushMessage){
		
		JPushClient jpushClient = getOwnerJPushClient(pushMessage.getOwnerNum(),pushMessage.getJpushKeys().getMasterSecret(),pushMessage.getJpushKeys().getAppKey());
		NotificationParams params = new NotificationParams();
		setParamsReceiverType(pushMessage.getTargetType(),params);
		params.setReceiverValue(pushMessage.getTargetId());
		MessageResult msgResult = jpushClient.sendNotification(pushMessage.getContent(), params, null);
		return processMessageResult(msgResult);
		
	}

	private static PushMessageResult pushCustomMessage(PushMessage pushMessage){
		JPushClient jpushClient = getOwnerJPushClient(pushMessage.getOwnerNum(),pushMessage.getJpushKeys().getMasterSecret(),pushMessage.getJpushKeys().getAppKey());
		CustomMessageParams params = new CustomMessageParams();
		setParamsReceiverType(pushMessage.getTargetType(),params);
		params.setReceiverValue(pushMessage.getTargetId());
		Map<String,Object> extraMap = new HashMap<String,Object>();
		List<PushMessageExtra> pushMessageExtras= pushMessage.getPushMessageExtras();
		if(pushMessageExtras!=null){
			for(PushMessageExtra pushMessageExtra:pushMessageExtras){
				extraMap.put(pushMessageExtra.getExtraName(), pushMessageExtra.getExtraValue());
			}
		}
		MessageResult msgResult = jpushClient.sendCustomMessage(pushMessage.getTitle(), pushMessage.getContent(), params, extraMap);
		
		return processMessageResult(msgResult);
		
	}
	
	private static PushMessageResult processMessageResult(MessageResult msgResult){
		PushMessageResult pushMessageResult = new PushMessageResult();
		logger.debug("responseContent - " + msgResult.responseResult.responseContent);
		if (msgResult.isResultOK()) {
			pushMessageResult.setResultStatus("S");
			pushMessageResult.setJpushMessageId(msgResult.getMessageId());
		    logger.info("msgResult - " + msgResult);
		    logger.info("messageId - " + msgResult.getMessageId());
		} else {
			pushMessageResult.setResultStatus("E");
		    if (msgResult.getErrorCode() > 0) {
		        // 业务异常
		        logger.warn("Service error - ErrorCode: "
		                + msgResult.getErrorCode() + ", ErrorMessage: "
		                + msgResult.getErrorMessage());
		        pushMessageResult.setErrorCode(String.valueOf(msgResult.getErrorCode()));
		        pushMessageResult.setErrorMessage(msgResult.getErrorMessage());
		    } else {
		        // 未到达 JPush 
		        logger.error("Other excepitons - "
		                + msgResult.responseResult.exceptionString);
		        pushMessageResult.setErrorCode("");
		        pushMessageResult.setErrorMessage(msgResult.responseResult.exceptionString);
		    }
		}
		return pushMessageResult;
	}
/*	
	public static void getMessageStatistic(){
		
		JPushClient jpushClient = new JPushClient(MASTERSECRET, APPKEY);
		ReceivedsResult receivedsResult = jpushClient.getReportReceiveds("1708010723,1774452771");
		logger.debug("responseContent - " + receivedsResult.responseResult.responseContent);
		if (receivedsResult.isResultOK()) {
		    logger.info("Receiveds - " + receivedsResult);
		} else {
		    if (receivedsResult.getErrorCode() > 0) {
		        // 业务异常
		        logger.warn("Service error - ErrorCode: "
		                + receivedsResult.getErrorCode() + ", ErrorMessage: "
		                + receivedsResult.getErrorMessage());
		    } else {
		        // 未到达 JPush
		        logger.error("Other excepitons - "
		                + receivedsResult.responseResult.exceptionString);
		    }
		}
	}
*/
}
