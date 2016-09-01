package com.etaoguan.wea.vo;

import java.util.List;

public class ProdStockDelta {
	
	private String whNum;
	private String whName;
	private String ownerNum;
	private String referNum;
	private String referModule;
	private List<ProdQty> prodQtyList;
	public String getWhNum() {
		return whNum;
	}
	public void setWhNum(String whNum) {
		this.whNum = whNum;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getReferNum() {
		return referNum;
	}
	public void setReferNum(String referNum) {
		this.referNum = referNum;
	}
	public String getReferModule() {
		return referModule;
	}
	public void setReferModule(String referModule) {
		this.referModule = referModule;
	}
	public List<ProdQty> getProdQtyList() {
		return prodQtyList;
	}
	public void setProdQtyList(List<ProdQty> prodQtyList) {
		this.prodQtyList = prodQtyList;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}

	

}
