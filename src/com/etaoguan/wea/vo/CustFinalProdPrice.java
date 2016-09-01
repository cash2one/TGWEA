package com.etaoguan.wea.vo;

public class CustFinalProdPrice{
	private String prodNum;
	private String prodName;
	private double finalPrice;
	private int isStdPrice;
	public int getIsStdPrice() {
		return isStdPrice;
	}
	public void setIsStdPrice(int isStdPrice) {
		this.isStdPrice = isStdPrice;
	}
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}



}
