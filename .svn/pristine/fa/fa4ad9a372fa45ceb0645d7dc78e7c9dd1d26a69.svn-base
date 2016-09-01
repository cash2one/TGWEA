package com.etaoguan.wea.vo;

import java.util.List;

import com.etaoguan.wea.common.WeaDataCache;

public class ReturnedInvoice extends OrderReferVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String retNum;
	private String ownerNum;
	private String custNum;
	private String whNum;
	private String whName;
	private String referOrderNum;
	private String referDeliverNum;
	private String retReason;
	@SuppressWarnings("unused")
	private String retReasonName;
	private int retWhStatus;
	private String remark;
	private DeliverInvoice deliverInv;
	private Customer customer;
	private List<ReturnedInvoiceItem> returnedInvItemList;
	public String getRetNum() {
		return retNum;
	}
	public void setRetNum(String retNum) {
		this.retNum = retNum;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getCustNum() {
		return custNum;
	}
	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}
	public String getReferOrderNum() {
		return referOrderNum;
	}
	public void setReferOrderNum(String referOrderNum) {
		this.referOrderNum = referOrderNum;
	}
	public String getRetReason() {
		return retReason;
	}
	public void setRetReason(String retReason) {
		this.retReason = retReason;
	}
	public int getRetWhStatus() {
		return retWhStatus;
	}
	public void setRetWhStatus(int retWhStatus) {
		this.retWhStatus = retWhStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<ReturnedInvoiceItem> getReturnedInvItemList() {
		return returnedInvItemList;
	}
	public void setReturnedInvItemList(List<ReturnedInvoiceItem> returnedInvItemList) {
		this.returnedInvItemList = returnedInvItemList;
	}
	public String getWhNum() {
		return whNum;
	}
	public void setWhNum(String whNum) {
		this.whNum = whNum;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DeliverInvoice getDeliverInv() {
		return deliverInv;
	}
	public void setDeliverInv(DeliverInvoice deliverInv) {
		this.deliverInv = deliverInv;
	}
	public String getRetReasonName() {
		return WeaDataCache.getCache().getReturnedReasonCodeNameMap().get(this.retReason);
	}
	public void setRetReasonName(String retReasonName) {
		this.retReasonName = retReasonName;
	}
	public String getReferDeliverNum() {
		return referDeliverNum;
	}
	public void setReferDeliverNum(String referDeliverNum) {
		this.referDeliverNum = referDeliverNum;
	}

 
}
