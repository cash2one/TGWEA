package com.etaoguan.wea.vo;

import java.util.List;

public class OrigOrder extends OrderReferVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String origOrderNum;
	private String custNum;
	private String ownerNum;
	private double priceTotal;
	private String deliverAddr;
	private Customer customer;
	private List<OrigOrderItem> origOrderItemList;
	private int haveReferOrder;
	
	public String getOrigOrderNum() {
		return origOrderNum;
	}
	public void setOrigOrderNum(String origOrderNum) {
		this.origOrderNum = origOrderNum;
	}
	public String getCustNum() {
		return custNum;
	}
	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}
	public double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	public List<OrigOrderItem> getOrigOrderItemList() {
		return origOrderItemList;
	}
	public void setOrigOrderItemList(List<OrigOrderItem> origOrderItemList) {
		this.origOrderItemList = origOrderItemList;
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
	public int getHaveReferOrder() {
		return haveReferOrder;
	}
	public void setHaveReferOrder(int haveReferOrder) {
		this.haveReferOrder = haveReferOrder;
	}
	public String getDeliverAddr() {
		return deliverAddr;
	}
	public void setDeliverAddr(String deliverAddr) {
		this.deliverAddr = deliverAddr;
	}
	
	

}
