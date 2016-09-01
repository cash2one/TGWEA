package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.BaseSearch;

public class ProdSearch extends BaseSearch {

	private int newFlag = -1;
	private int hotFlag = -1;
	private int showFlag = 1;
	private String productName;
	private String[] productCatIds;
	private String productModel;
	private String isPublic;
	private String[] productNums;
	private String custNum;
	private String chanpin;

	public String getChanpin() {
		return chanpin;
	}

	public void setChanpin(String chanpin) {
		this.chanpin = chanpin;
	}

	public String[] getProductNums() {
		return productNums;
	}

	public void setProductNums(String[] productNums) {
		this.productNums = productNums;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String[] getProductCatIds() {
		return productCatIds;
	}

	public void setProductCatIds(String[] productCatIds) {
		this.productCatIds = productCatIds;
	}

	public int getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(int showFlag) {
		this.showFlag = showFlag;
	}

}
