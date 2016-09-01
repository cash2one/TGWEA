package com.etaoguan.wea.client.web.vo;

public class CustProdPriceSearch extends ProdPriceSearch {

	private String custNum;
	private String prodNum;

	public String getProdNum() {
		return prodNum;
	}

	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

}
