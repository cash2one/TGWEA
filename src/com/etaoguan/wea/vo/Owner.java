package com.etaoguan.wea.vo;

import com.etaoguan.wea.common.WeaDataCache;

@SuppressWarnings("serial")
public class Owner extends BaseVo{

	private String adminName;
	private String ownerNum;
	private String companyName;
	private String shopNum;
	private int tradeId;
	@SuppressWarnings("unused")
	private String tradeName;
	private String contactPerson;
	private String phoneNum;
	private String mobileNum;
	private String address;
	private String ownerImg;
	private String mapImg;
	private String introduction;
	private String webSite;
	private int activeFlag;
	private int delFlag;
	private String regionCode;
	@SuppressWarnings("unused")
	private String regionName;
	private String remark;
	private String externalSysCode;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitudes;
	
	private OwnerMobileGeneration ownerMobileGeneration;
	
	public OwnerMobileGeneration getOwnerMobileGeneration() {
		return ownerMobileGeneration;
	}
	public void setOwnerMobileGeneration(OwnerMobileGeneration ownerMobileGeneration) {
		this.ownerMobileGeneration = ownerMobileGeneration;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitudes() {
		return latitudes;
	}
	public void setLatitudes(String latitudes) {
		this.latitudes = latitudes;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOwnerImg() {
		return ownerImg;
	}
	public void setOwnerImg(String ownerImg) {
		this.ownerImg = ownerImg;
	}
	public String getMapImg() {
		return mapImg;
	}
	public void setMapImg(String mapImg) {
		this.mapImg = mapImg;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getExternalSysCode() {
		return externalSysCode;
	}
	public void setExternalSysCode(String externalSysCode) {
		this.externalSysCode = externalSysCode;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getTradeName() {
		return WeaDataCache.getCache().getTradeMap().get(String.valueOf(this.tradeId));
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getRegionName() {
		return WeaDataCache.getCache().getProvRegionMap().get(this.regionCode);
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getShopNum() {
		return shopNum;
	}
	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}

}
