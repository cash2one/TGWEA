package com.etaoguan.wea.vo;

public class DeliverInvoiceItem {
	
	private String deliverNum;
	private String prodNum;
	private String prodName;
	private String differName;
	private String unit;
	private int cases;
	private int pieces;
	public String getDeliverNum() {
		return deliverNum;
	}
	public void setDeliverNum(String deliverNum) {
		this.deliverNum = deliverNum;
	}
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public int getCases() {
		return cases;
	}
	public void setCases(int cases) {
		this.cases = cases;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDifferName() {
		return differName;
	}
	public void setDifferName(String differName) {
		this.differName = differName;
	}

}
