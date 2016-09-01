package com.etaoguan.wea.e688.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductCategory implements Serializable{
	private Integer id;
	private Integer catsId;
	private String memberId;
	private String catsName;
	private Integer parentCatsId;
	private Integer order;
	private String iconUrl;
	private String isSelfCategory;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCatsName() {
		return catsName;
	}
	public void setCatsName(String catsName) {
		this.catsName = catsName;
	}
	public Integer getParentCatsId() {
		return parentCatsId;
	}
	public void setParentCatsId(Integer parentCatsId) {
		this.parentCatsId = parentCatsId;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	
	public String getIsSelfCategory() {
		return isSelfCategory;
	}
	public void setIsSelfCategory(String isSelfCategory) {
		this.isSelfCategory = isSelfCategory;
	}
	public Integer getCatsId() {
		return catsId;
	}
	public void setCatsId(Integer catsId) {
		this.catsId = catsId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	

}
