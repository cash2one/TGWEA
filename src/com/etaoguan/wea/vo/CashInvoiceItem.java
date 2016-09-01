package com.etaoguan.wea.vo;

public class CashInvoiceItem {

	private String cashNum;
	private String acctName;
	private double payPrice;
	private String remark;
	
	public String getCashNum() {
		return cashNum;
	}
	public void setCashNum(String cashNum) {
		this.cashNum = cashNum;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public double getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(double payPrice) {
		this.payPrice = payPrice;
	}
}
