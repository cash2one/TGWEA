package com.etaoguan.wea.wechat.vo;

import java.util.Date;

/**
 * @author cunli 群发消息结果
 */
public class WechatMassMsgRequest {
	/**
	 * 这个表的id(主键)
	 */
	private long requestId;
	private String ownerNum;
	/**
	 * wechat_mass_message  id
	 */
	private long massMessageId;
	/**
	 * 发送消息后，返回的ID
	 */
	private long wechatMsgId;
	/**
	 * 0-未发送；1-已发送  (发送状态)
	 */
	private int processStatus;
	
	/**
	 * 反回的错误编号
	 */
	private int requestErrorCode;
	/**
	 * 群发后的结果状态
	 */
	private int responseStatus;
	/**
	 * 群发后的未成功数量
	 */
	private int responseErrorCount;
	/**
	 * 发送时间
	 */
	private Date RequestDate;
	/**
	 * 发送人
	 */
	private String requestBy;
	/**
	 * 返回时间
	 */
	private Date responseDate;
	/**
	 * 返回人
	 */
	private String responseBy;

	public String getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}

	public int getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public long getMassMessageId() {
		return massMessageId;
	}

	public void setMassMessageId(long massMessageId) {
		this.massMessageId = massMessageId;
	}

	public long getWechatMsgId() {
		return wechatMsgId;
	}

	public void setWechatMsgId(long wechatMsgId) {
		this.wechatMsgId = wechatMsgId;
	}

	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

	public int getRequestErrorCode() {
		return requestErrorCode;
	}

	public void setRequestErrorCode(int requestErrorCode) {
		this.requestErrorCode = requestErrorCode;
	}

	public int getResponseErrorCount() {
		return responseErrorCount;
	}

	public void setResponseErrorCount(int responseErrorCount) {
		this.responseErrorCount = responseErrorCount;
	}

	public Date getRequestDate() {
		return RequestDate;
	}

	public void setRequestDate(Date requestDate) {
		RequestDate = requestDate;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getResponseBy() {
		return responseBy;
	}

	public void setResponseBy(String responseBy) {
		this.responseBy = responseBy;
	}
}
