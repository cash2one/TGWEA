package com.etaoguan.wea.vo;

import java.util.List;

import com.etaoguan.wea.common.WeaDataCache;

public class StockAllocateInvoice extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stkAllocNum;
	private String ownerNum;
	private String fromWhNum;
	private String fromWhName;
	private String toWhNum;
	private String toWhName;
	private int stkAllocStatus;
	@SuppressWarnings("unused")
	private String stkAllocStatusName;
	private String remark;
	private int prodCount;
	private List<StockAllocateInvoiceItem> stkAllocInvItemList;

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
	public String getStkAllocNum() {
		return stkAllocNum;
	}
	public void setStkAllocNum(String stkAllocNum) {
		this.stkAllocNum = stkAllocNum;
	}

	public int getStkAllocStatus() {
		return stkAllocStatus;
	}
	public void setStkAllocStatus(int stkAllocStatus) {
		this.stkAllocStatus = stkAllocStatus;
	}
	public String getStkAllocStatusName() {
		return WeaDataCache.getCache().getStkAllocStatusCodeNameMap().get(String.valueOf(this.stkAllocStatus));
	}
	public void setStkAllocStatusName(String stkAllocStatusName) {
		this.stkAllocStatusName = stkAllocStatusName;
	}
	public int getProdCount() {
		return prodCount;
	}
	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
	public List<StockAllocateInvoiceItem> getStkAllocInvItemList() {
		return stkAllocInvItemList;
	}
	public void setStkAllocInvItemList(
			List<StockAllocateInvoiceItem> stkAllocInvItemList) {
		this.stkAllocInvItemList = stkAllocInvItemList;
	}
	public String getFromWhNum() {
		return fromWhNum;
	}
	public void setFromWhNum(String fromWhNum) {
		this.fromWhNum = fromWhNum;
	}
	public String getFromWhName() {
		return fromWhName;
	}
	public void setFromWhName(String fromWhName) {
		this.fromWhName = fromWhName;
	}
	public String getToWhNum() {
		return toWhNum;
	}
	public void setToWhNum(String toWhNum) {
		this.toWhNum = toWhNum;
	}
	public String getToWhName() {
		return toWhName;
	}
	public void setToWhName(String toWhName) {
		this.toWhName = toWhName;
	}
	
}
