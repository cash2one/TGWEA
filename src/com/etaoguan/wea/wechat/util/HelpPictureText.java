package com.etaoguan.wea.wechat.util;

import java.util.List;

import com.etaoguan.wea.wechat.vo.WechatMassMpnews;

/**
 * @author cunli 上传图片到微信服务器后，这个class帮助图片显示
 */
public class HelpPictureText {
	private String imgUrl;
	private String mediaId;
	
	private String accessToken;
	private List<WechatMassMpnews> wechatPictureTexts;
	
	private String msgId;
	private String errcode;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public List<WechatMassMpnews> getWechatPictureTexts() {
		return wechatPictureTexts;
	}

	public void setWechatPictureTexts(List<WechatMassMpnews> wechatPictureTexts) {
		this.wechatPictureTexts = wechatPictureTexts;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
