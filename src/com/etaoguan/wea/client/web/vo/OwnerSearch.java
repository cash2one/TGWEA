package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.BaseSearch;

public class OwnerSearch extends BaseSearch{

	private String companyName;
	private String[] regionCodes;	
	private String phoneNum;
	private String contactPerson;
	private String delFlag;
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String[] getRegionCodes() {
		return regionCodes;
	}
	public void setRegionCodes(String[] regionCodes) {
		this.regionCodes = regionCodes;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
}
