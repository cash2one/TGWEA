package com.etaoguan.wea.vo;

public class PushGroupCustRef  extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String groupNum;
	
	private String custNum;
	
	private Customer cust;

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
}
