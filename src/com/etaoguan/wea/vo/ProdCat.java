package com.etaoguan.wea.vo;

public class ProdCat extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prodCatId;
	private String ownerNum;
	private String prodCatName;
	private String parentProdCatId;
	private String externalSysCode;

	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getProdCatName() {
		return prodCatName;
	}
	public void setProdCatName(String prodCatName) {
		this.prodCatName = prodCatName;
	}
	public String getExternalSysCode() {
		return externalSysCode;
	}
	public void setExternalSysCode(String externalSysCode) {
		this.externalSysCode = externalSysCode;
	}
	public String getProdCatId() {
		return prodCatId;
	}
	public void setProdCatId(String prodCatId) {
		this.prodCatId = prodCatId;
	}
	public String getParentProdCatId() {
		return parentProdCatId;
	}
	public void setParentProdCatId(String parentProdCatId) {
		this.parentProdCatId = parentProdCatId;
	}
	
}
