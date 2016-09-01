package com.etaoguan.wea.vo;

import java.util.List;

import com.etaoguan.wea.common.WeaDataCache;

@SuppressWarnings("serial")
public class CashInvoice extends OrderReferVo{
	
	private String cashNum;
	private String ownerNum;
	private String custNum;
	private String referOrderNum;
	private int cashType;
	@SuppressWarnings("unused")
	private String cashTypeName;
	private double priceTotal;
	private String remark;
	private Customer customer;
	private Order order;
	private List<CashInvoiceItem>  cashInvItemList;
	
	public String getCashNum() {
		return cashNum;
	}
	public void setCashNum(String cashNum) {
		this.cashNum = cashNum;
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
	public int getCashType() {
		return cashType;
	}
	public void setCashType(int cashType) {
		this.cashType = cashType;
	}
	public double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<CashInvoiceItem> getCashInvItemList() {
		return cashInvItemList;
	}
	public void setCashInvItemList(List<CashInvoiceItem> cashInvItemList) {
		this.cashInvItemList = cashInvItemList;
	}
	public String getCashTypeName() {
		return WeaDataCache.getCache().getCashTypeCodeNameMap().get(String.valueOf(this.cashType));
	}
	public void setCashTypeName(String cashTypeName) {
		this.cashTypeName = cashTypeName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public Order getOrder() {
		return order;
	}
	@Override
	public void setOrder(Order order) {
		this.order = order;
	}

}
