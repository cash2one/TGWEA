package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.BaseSearch;

public class DeliverInvSearch extends BaseSearch{
	
	private String referOrderNum;
	
	private String custNum;

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



}
