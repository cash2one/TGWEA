package com.etaoguan.wea.vo;

import com.etaoguan.wea.vo.BaseVo;

/**
 * @author cunli 产品定位
 */
public class ProductGps extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String custNum;
	private String ownerNum;
	private String prodNum;
	private String prodName;
	
	private String contactPerson;

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public String getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}

	public String getProdNum() {
		return prodNum;
	}

	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

}
