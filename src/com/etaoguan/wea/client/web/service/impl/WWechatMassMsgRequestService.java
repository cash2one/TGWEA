package com.etaoguan.wea.client.web.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWWechatMassMsgRequestService;
import com.etaoguan.wea.service.impl.WechatMassMsgRequestService;
import com.etaoguan.wea.wechat.util.HelpPictureText;
import com.etaoguan.wea.wechat.util.WechatPictureTextUtil;
import com.etaoguan.wea.wechat.vo.WechatMassMessage;
import com.etaoguan.wea.wechat.vo.WechatMassMsgRequest;


/**
 * @author cunli
 * 图文消息详情
 */
@Service("wWechatMassMsgRequestService")
public class WWechatMassMsgRequestService extends WechatMassMsgRequestService implements IWWechatMassMsgRequestService{

	@Override
	public void deleteWmmr(long massMessageId) {
		deleteWechatMassMsgRequest(massMessageId);
		
	}

	/* (non-Javadoc) 报错群发结果
	 * @see com.etaoguan.wea.client.web.service.IWWechatMassMsgRequestService#addWechatWMMR(com.etaoguan.wea.wechat.vo.WechatMassMessage, java.lang.String, java.lang.String, long)
	 */
	@Override
	@SuppressWarnings({"unused" })
	public void addWechatWMMR(WechatMassMessage wechatMassMessage,String accessToken,String ownerNum,long massMessageId) {
		/* 获取关注者列表 */
		WechatPictureTextUtil wechatMessagesUtil = new WechatPictureTextUtil();
		String openids = WechatPictureTextUtil.customers(accessToken);

		/* 群发 */
		String mediaId = wechatMassMessage.getContent();
		HelpPictureText helpPictureText=WechatPictureTextUtil.sendImgText(mediaId,openids, accessToken);
		long msgId = Long.parseLong(helpPictureText.getMsgId());
		int errcode=Integer.parseInt(helpPictureText.getErrcode());

		/* 保存群发结果 */
		WechatMassMsgRequest wechatMassMsgRequest = new WechatMassMsgRequest();
		wechatMassMsgRequest.setMassMessageId(massMessageId);
		wechatMassMsgRequest.setWechatMsgId(msgId);//返回的群发结果 msgId 保存到数据库
		int processStatus = 0;
		if (msgId > 0) {
			processStatus = 1;
		}
		wechatMassMsgRequest.setProcessStatus(processStatus);//更新这条消息的发送状态
		wechatMassMsgRequest.setOwnerNum(ownerNum);
		wechatMassMsgRequest.setRequestBy(ownerNum);
		wechatMassMsgRequest.setRequestErrorCode(errcode);
		addWechatMassMsgRequest(wechatMassMsgRequest);
		
	}

	@Override
	public void updateWWechatMassMsgRequest(
			WechatMassMsgRequest wechatMassMsgRequest) {
		wechatMassMsgRequest.setResponseBy("weiChat");
		updateWechatMassMsgRequest(wechatMassMsgRequest);
		
	}


	
}
