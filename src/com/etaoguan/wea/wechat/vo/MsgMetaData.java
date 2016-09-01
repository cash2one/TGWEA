package com.etaoguan.wea.wechat.vo;

/**
 * @author cunli
 *接收到的微信的xml內容
 */
public class MsgMetaData {

	/**
	 * 消息类型
	 */
	private String msgType;
	/**
	 * 发送者ID
	 */
	private String fromUserName;
	/**
	 * 消息ID
	 */
	private String msgId;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	
}
