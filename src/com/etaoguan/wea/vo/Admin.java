package com.etaoguan.wea.vo;

import java.util.Date;
import java.util.List;

public class Admin  extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int adminId;
	private String adminName;
	private String adminPwd;
	private Date loginDate;
	private String remark;
	private int reserveFlag;
	private List<AccessOperation> accessOperationList;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public List<AccessOperation> getAccessOperationList() {
		return accessOperationList;
	}
	public void setAccessOperationList(List<AccessOperation> accessOperationList) {
		this.accessOperationList = accessOperationList;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getReserveFlag() {
		return reserveFlag;
	}
	public void setReserveFlag(int reserveFlag) {
		this.reserveFlag = reserveFlag;
	}


}
