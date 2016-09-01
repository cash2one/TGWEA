package com.etaoguan.wea.e688.vo;

import java.io.Serializable;

public class OfferImageInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private long offerId;
	private String offerUrl;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public long getOfferId() {
		return offerId;
	}
	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}
	public String getOfferUrl() {
		return offerUrl;
	}
	public void setOfferUrl(String offerUrl) {
		this.offerUrl = offerUrl;
	}

}
