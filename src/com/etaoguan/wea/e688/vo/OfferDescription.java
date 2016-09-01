package com.etaoguan.wea.e688.vo;

import java.io.Serializable;

public class OfferDescription implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long offerId;
	
	private String description;

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
