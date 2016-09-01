package com.etaoguan.wea.e688.vo;

import java.io.Serializable;


@SuppressWarnings("serial")
public class OfferDetailInfo implements Serializable{
	private Integer id;
	private long offerId;
	private String datailsUrl;
	private String type;
	private Integer tradeType;
	private Integer postCategryId;
	private String offerStatus;
	private String memberId;
	private String subject;
	private String details;
	private String unit;
	private Integer amount;
	private Integer amountOnSale;
	private Integer saledCount;
	private double retailPrice;
	private double unitPrice;
	private Integer termOfferProcess;
	private String gmtApproved;
	private String gmtExpire;
	public long getOfferId() {
		return offerId;
	}
	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}
	public String getDatailsUrl() {
		return datailsUrl;
	}
	public void setDatailsUrl(String datailsUrl) {
		this.datailsUrl = datailsUrl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getTradeType() {
		return tradeType;
	}
	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}
	
	public Integer getPostCategryId() {
		return postCategryId;
	}
	public void setPostCategryId(Integer postCategryId) {
		this.postCategryId = postCategryId;
	}
	public String getOfferStatus() {
		return offerStatus;
	}
	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Integer getAmountOnSale() {
		return amountOnSale;
	}
	public void setAmountOnSale(Integer amountOnSale) {
		this.amountOnSale = amountOnSale;
	}
	
	public Integer getSaledCount() {
		return saledCount;
	}
	public void setSaledCount(Integer saledCount) {
		this.saledCount = saledCount;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getTermOfferProcess() {
		return termOfferProcess;
	}
	public void setTermOfferProcess(Integer termOfferProcess) {
		this.termOfferProcess = termOfferProcess;
	}

	public String getGmtApproved() {
		return gmtApproved;
	}
	public void setGmtApproved(String gmtApproved) {
		this.gmtApproved = gmtApproved;
	}
	public String getGmtExpire() {
		return gmtExpire;
	}
	public void setGmtExpire(String gmtExpire) {
		this.gmtExpire = gmtExpire;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
