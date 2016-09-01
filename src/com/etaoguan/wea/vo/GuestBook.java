package com.etaoguan.wea.vo;

public class GuestBook extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long messageId;
	private String content;
	private String ownerNum;
	private Customer customer;
	
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
