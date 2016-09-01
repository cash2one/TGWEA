package com.etaoguan.wea.vo;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.etaoguan.wea.common.WeaDataCache;

public class Customer extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String custNum;
	private String custName;
	private String password;
	private String companyName;
	private String ownerNum;
	private String tradeId;
	@SuppressWarnings("unused")
	private String tradeName;
	private String contactPerson;
	private String phoneNum;
	private String address;
	private int keyLevel;
	private int delFlag;
	private String regionCode;
	private int creditLevel;
	private String remark;
	private Date loginDate;
	@SuppressWarnings("unused")
	private String regionName;
	private String createFrom;
	
	private List<AccessOperation> accessOperationList;
	
	public String getCustNum() {
		return custNum;
	}
	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	@JSON(serialize=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
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
	public int getKeyLevel() {
		return keyLevel;
	}
	public void setKeyLevel(int keyLevel) {
		this.keyLevel = keyLevel;
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
	public int getCreditLevel() {
		return creditLevel;
	}
	public void setCreditLevel(int creditLevel) {
		this.creditLevel = creditLevel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@JSON(format="yyyy-MM-dd HH:mm:ss")  
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getRegionName() {
		return WeaDataCache.getCache().getProvRegionMap().get(this.regionCode);
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getTradeName() {
		return WeaDataCache.getCache().getTradeMap().get(this.tradeId);
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	@JSON(serialize=false)
	public List<AccessOperation> getAccessOperationList() {
		return accessOperationList;
	}
	public void setAccessOperationList(List<AccessOperation> accessOperationList) {
		this.accessOperationList = accessOperationList;
	}
	public String getCreateFrom() {
		return createFrom;
	}
	public void setCreateFrom(String createFrom) {
		this.createFrom = createFrom;
	}

}
