package com.etaoguan.wea.wechat.vo;

import com.etaoguan.wea.vo.BaseVo;

/**
 * @author cunli
 * 微信群发消息
 */
public class WechatMassMessage extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long massMessageId;
	private String ownerNum;
	private String wechatSubject;
	private int msgType;
	private int filterType;
	private String filterText;
	private String content;
	private String remark;
	private WechatMassMsgRequest wechatMassMsgRequest;
	
	public WechatMassMsgRequest getWechatMassMsgRequest() {
		return wechatMassMsgRequest;
	}
	public void setWechatMassMsgRequest(WechatMassMsgRequest wechatMassMsgRequest) {
		this.wechatMassMsgRequest = wechatMassMsgRequest;
	}
	public long getMassMessageId() {
		return massMessageId;
	}
	public void setMassMessageId(long massMessageId) {
		this.massMessageId = massMessageId;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getWechatSubject() {
		return wechatSubject;
	}
	public void setWechatSubject(String wechatSubject) {
		this.wechatSubject = wechatSubject;
	}
	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public int getFilterType() {
		return filterType;
	}
	public void setFilterType(int filterType) {
		this.filterType = filterType;
	}
	public String getFilterText() {
		return filterText;
	}
	public void setFilterText(String filterText) {
		this.filterText = filterText;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
