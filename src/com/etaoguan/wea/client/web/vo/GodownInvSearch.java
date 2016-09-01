package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.BaseSearch;

public class GodownInvSearch extends BaseSearch{
	
	private String prodName;
	
	private String whNum;


	public String getWhNum() {
		return whNum;
	}

	public void setWhNum(String whNum) {
		this.whNum = whNum;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

}
