package com.etaoguan.wea.vo;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.etaoguan.wea.common.WeaDataCache;

public class Order extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNum;
	private String deliverLocation;
	private String custNum;
	private String custName;
	private double stdPriceTotal;
	private double realPriceTotal;
	private double custPriceTotal;
	private int deliverStatus;
	@SuppressWarnings("unused")
	private String deliverStatusName;
	private Date deliverDate;
	private String deliverBy;
	private int cashType;
	@SuppressWarnings("unused")
	private String cashTypeName;
	private int cashStatus;
	@SuppressWarnings("unused")
	private String cashStatusName;
	private Date cashDate;
	private String cashBy;
	private int settleStatus;
	@SuppressWarnings("unused")
	private String settleStatusName;
	private Date settleDate;
	private String settleBy;
	private String origReferOrderNum;
	private List<OrderItem> orderItemList;
	private String ownerNum;
	private int retInvCount;
	private String createFrom;
	private String remark;
	private String deliverAddr;
	private int onlinePayStatus;
	
	private Customer customer;
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

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

	public double getRealPriceTotal() {
		return realPriceTotal;
	}
	public void setRealPriceTotal(double realPriceTotal) {
		this.realPriceTotal = realPriceTotal;
	}
	public int getDeliverStatus() {
		return deliverStatus;
	}
	public void setDeliverStatus(int deliverStatus) {
		this.deliverStatus = deliverStatus;
	}
	
	@JSON(format="yyyy-MM-dd HH:mm:ss")  
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	public String getDeliverBy() {
		return deliverBy;
	}
	public void setDeliverBy(String deliverBy) {
		this.deliverBy = deliverBy;
	}
	public int getCashStatus() {
		return cashStatus;
	}
	public void setCashStatus(int cashStatus) {
		this.cashStatus = cashStatus;
	}
	
	@JSON(format="yyyy-MM-dd HH:mm:ss")  
	public Date getCashDate() {
		return cashDate;
	}
	public void setCashDate(Date cashDate) {
		this.cashDate = cashDate;
	}
	public String getCashBy() {
		return cashBy;
	}
	public void setCashBy(String cashBy) {
		this.cashBy = cashBy;
	}
	public int getSettleStatus() {
		return settleStatus;
	}
	public void setSettleStatus(int settleStatus) {
		this.settleStatus = settleStatus;
	}
	
	@JSON(format="yyyy-MM-dd HH:mm:ss")  
	public Date getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(Date settleDate) {
		this.settleDate = settleDate;
	}
	public String getSettleBy() {
		return settleBy;
	}
	public void setSettleBy(String settleBy) {
		this.settleBy = settleBy;
	}
	public String getOrigReferOrderNum() {
		return origReferOrderNum;
	}
	public void setOrigReferOrderNum(String origReferOrderNum) {
		this.origReferOrderNum = origReferOrderNum;
	}
	public String getDeliverLocation() {
		return deliverLocation;
	}
	public void setDeliverLocation(String deliverLocation) {
		this.deliverLocation = deliverLocation;
	}
	public int getCashType() {
		return cashType;
	}
	public void setCashType(int cashType) {
		this.cashType = cashType;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public double getCustPriceTotal() {
		return custPriceTotal;
	}
	public void setCustPriceTotal(double custPriceTotal) {
		this.custPriceTotal = custPriceTotal;
	}
	public double getStdPriceTotal() {
		return stdPriceTotal;
	}
	public void setStdPriceTotal(double stdPriceTotal) {
		this.stdPriceTotal = stdPriceTotal;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getRetInvCount() {
		return retInvCount;
	}
	public void setRetInvCount(int retInvCount) {
		this.retInvCount = retInvCount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDeliverStatusName() {
		return WeaDataCache.getCache().getOrderDeliverStatusCodeNameMap().get(String.valueOf(this.deliverStatus));
	}
	public void setDeliverStatusName(String deliverStatusName) {
		this.deliverStatusName = deliverStatusName;
	}
	public String getCashTypeName() {
		return WeaDataCache.getCache().getOrderCashTypeNameMap().get(String.valueOf(this.cashType));
	}
	public void setCashTypeName(String cashTypeName) {
		this.cashTypeName = cashTypeName;
	}
	public String getCashStatusName() {
		return WeaDataCache.getCache().getOrderCashStatusCodeNameMap().get(String.valueOf(this.cashStatus));
	}
	public void setCashStatusName(String cashStatusName) {
		this.cashStatusName = cashStatusName;
	}
	public String getSettleStatusName() {
		return WeaDataCache.getCache().getOrderSettleStatusCodeNameMap().get(String.valueOf(this.settleStatus));
	}
	public void setSettleStatusName(String settleStatusName) {
		this.settleStatusName = settleStatusName;
	}
	public String getCreateFrom() {
		return createFrom;
	}
	public void setCreateFrom(String createFrom) {
		this.createFrom = createFrom;
	}
	public String getDeliverAddr() {
		return deliverAddr;
	}
	public void setDeliverAddr(String deliverAddr) {
		this.deliverAddr = deliverAddr;
	}
	public int getOnlinePayStatus() {
		return onlinePayStatus;
	}
	public void setOnlinePayStatus(int onlinePayStatus) {
		this.onlinePayStatus = onlinePayStatus;
	}


}
