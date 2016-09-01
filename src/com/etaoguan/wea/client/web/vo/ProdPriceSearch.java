package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.BaseSearch;

public class ProdPriceSearch extends BaseSearch{
	
	private String prodName;
	
	private String[] productCatIds;


	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String[] getProductCatIds() {
		return productCatIds;
	}

	public void setProductCatIds(String[] productCatIds) {
		this.productCatIds = productCatIds;
	}

}
