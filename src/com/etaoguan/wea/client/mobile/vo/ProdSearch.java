package com.etaoguan.wea.client.mobile.vo;

import com.etaoguan.wea.client.vo.BaseSearch;

public class ProdSearch extends BaseSearch {

	private int newFlag = -1;
	private int hotFlag = -1;
	private String prodName;
	private String prodCatId;
	private String custNum;
	private int isPublic;

	public int getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public int getNewFlag() {
		return newFlag;
	}

	public void setNewFlag(int newFlag) {
		this.newFlag = newFlag;
	}

	public int getHotFlag() {
		return hotFlag;
	}

	public void setHotFlag(int hotFlag) {
		this.hotFlag = hotFlag;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdCatId() {
		return prodCatId;
	}

	public void setProdCatId(String prodCatId) {
		this.prodCatId = prodCatId;
	}

}
