package com.etaoguan.wea.vo;

import java.util.List;



import com.etaoguan.wea.common.WeaDataCache;

public class WechatMessage extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long messageId;
	
	private String ownerNum;
	
	private String subject;
	
	private int messageType;
	
	private String replyKey;
	
	@SuppressWarnings("unused")
	private String messageTypeName;
	
	private String remark;
	
	List<WechatMessageData> wechatMessageDatas;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageTypeName() {
		return WeaDataCache.getCache().getWechatMessageTypeNameMap().get(String.valueOf(this.messageType));
	}

	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}

	public List<WechatMessageData> getWechatMessageDatas() {
		return wechatMessageDatas;
	}

	public void setWechatMessageDatas(List<WechatMessageData> wechatMessageDatas) {
		this.wechatMessageDatas = wechatMessageDatas;
	}

	public String getReplyKey() {
		return replyKey;
	}

	public void setReplyKey(String replyKey) {
		this.replyKey = replyKey;
	}
}
