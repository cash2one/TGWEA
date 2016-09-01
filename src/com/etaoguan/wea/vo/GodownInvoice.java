package com.etaoguan.wea.vo;

import java.util.List;

import com.etaoguan.wea.common.WeaDataCache;

public class GodownInvoice extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gdNum;
	private String ownerNum;
	private String whNum;
	private String whName;
	private int gdStatus;
	@SuppressWarnings("unused")
	private String gdStatusName;
	private String remark;
	private int prodCount;
	private List<GodownInvoiceItem> godownInvItemList;

	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGdNum() {
		return gdNum;
	}
	public void setGdNum(String gdNum) {
		this.gdNum = gdNum;
	}
	public int getGdStatus() {
		return gdStatus;
	}
	public void setGdStatus(int gdStatus) {
		this.gdStatus = gdStatus;
	}
	public String getWhNum() {
		return whNum;
	}
	public void setWhNum(String whNum) {
		this.whNum = whNum;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public int getProdCount() {
		return prodCount;
	}
	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
	public String getGdStatusName() {
		return WeaDataCache.getCache().getGodownStatusCodeNameMap().get(String.valueOf(this.gdStatus));
	}
	public void setGdStatusName(String gdStatusName) {
		this.gdStatusName = gdStatusName;
	}
	public List<GodownInvoiceItem> getGodownInvItemList() {
		return godownInvItemList;
	}
	public void setGodownInvItemList(List<GodownInvoiceItem> godownInvItemList) {
		this.godownInvItemList = godownInvItemList;
	}

}
