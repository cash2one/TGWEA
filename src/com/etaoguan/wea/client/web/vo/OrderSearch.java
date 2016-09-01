package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.BaseSearch;

public class OrderSearch extends BaseSearch{
	

	private String custNum;
	
	private String companyName;
	
	private int deliverStatus=-1;
	
	private int cashStatus=-1;
	
	private int settleStatus=-1;
	
	private String deliverLocation;

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public int getDeliverStatus() {
		return deliverStatus;
	}

	public void setDeliverStatus(int deliverStatus) {
		this.deliverStatus = deliverStatus;
	}

	public int getSettleStatus() {
		return settleStatus;
	}

	public void setSettleStatus(int settleStatus) {
		this.settleStatus = settleStatus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(int cashStatus) {
		this.cashStatus = cashStatus;
	}

	public String getDeliverLocation() {
		return deliverLocation;
	}

	public void setDeliverLocation(String deliverLocation) {
		this.deliverLocation = deliverLocation;
	}





}
