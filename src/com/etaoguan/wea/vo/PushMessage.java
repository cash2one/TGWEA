package com.etaoguan.wea.vo;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.etaoguan.wea.common.WeaDataCache;

public class PushMessage  extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long messageId;
	
	private String ownerSystem;
	
	private String ownerNum;
	
	private int targetType;
	
	@SuppressWarnings("unused")
	private String targetTypeName;
	
	private String targetId;
	
	private String targetDesc;
	
	private String title;
	
	private String content;
	
	private Date sendTime;
	
	private int sendTimeType;
	
	private int processStatus;
	
	@SuppressWarnings("unused")
	private String processStatusName;

	private String remark;
	
	private int messageType;
	
	@SuppressWarnings("unused")
	private String messageTypeName;
	
	private int resultStatus;
	
	private JpushKeys jpushKeys;
	
	private List<PushMessageResult> pushMessageResults;

	private List<PushMessageExtra> pushMessageExtras;

	public String getOwnerSystem() {
		return ownerSystem;
	}

	public void setOwnerSystem(String ownerSystem) {
		this.ownerSystem = ownerSystem;
	}

	public String getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}

	public int getTargetType() {
		return targetType;
	}

	public void setTargetType(int targetType) {
		this.targetType = targetType;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@JSON(format="yyyy-MM-dd HH:mm:ss")  
	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

	public List<PushMessageExtra> getPushMessageExtras() {
		return pushMessageExtras;
	}

	public void setPushMessageExtras(List<PushMessageExtra> pushMessageExtras) {
		this.pushMessageExtras = pushMessageExtras;
	}

	public int getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}

	public List<PushMessageResult> getPushMessageResults() {
		return pushMessageResults;
	}

	public void setPushMessageResults(List<PushMessageResult> pushMessageResults) {
		this.pushMessageResults = pushMessageResults;
	}

	public String getTargetTypeName() {
		return WeaDataCache.getCache().getPushMessageTargetTypeNameMap().get(String.valueOf(this.targetType));
	}

	public void setTargetTypeName(String targetTypeName) {
		this.targetTypeName = targetTypeName;
	}

	public String getProcessStatusName() {
		return WeaDataCache.getCache().getPushMessageProcessStatusNameMap().get(String.valueOf(this.processStatus));
	}

	public void setProcessStatusName(String processStatusName) {
		this.processStatusName = processStatusName;
	}

	public String getMessageTypeName() {
		return WeaDataCache.getCache().getPushMessageMessageTypeNameMap().get(String.valueOf(this.messageType));
	}

	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}

	public String getTargetDesc() {
		return targetDesc;
	}

	public void setTargetDesc(String targetDesc) {
		this.targetDesc = targetDesc;
	}

	public JpushKeys getJpushKeys() {
		return jpushKeys;
	}

	public void setJpushKeys(JpushKeys jpushKeys) {
		this.jpushKeys = jpushKeys;
	}

	public int getSendTimeType() {
		return sendTimeType;
	}

	public void setSendTimeType(int sendTimeType) {
		this.sendTimeType = sendTimeType;
	}


}
