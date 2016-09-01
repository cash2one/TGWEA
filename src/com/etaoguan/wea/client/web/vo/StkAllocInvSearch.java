package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.BaseSearch;

public class StkAllocInvSearch extends BaseSearch{
	
	private String prodName;
	
	private String fromWhNum;
	
	private String toWhNum;

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getFromWhNum() {
		return fromWhNum;
	}

	public void setFromWhNum(String fromWhNum) {
		this.fromWhNum = fromWhNum;
	}

	public String getToWhNum() {
		return toWhNum;
	}

	public void setToWhNum(String toWhNum) {
		this.toWhNum = toWhNum;
	}



}
