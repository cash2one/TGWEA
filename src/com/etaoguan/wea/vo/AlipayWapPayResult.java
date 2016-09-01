package com.etaoguan.wea.vo;

import java.util.Date;

/**
 * @author cunli 支付宝异步返回的数据
 * 
 */
public class AlipayWapPayResult extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long alipaywapResultId;
	private String notifyNotifyData;
	private String buyerEmail;
	private String gmtCreate;
	private String outTradeNo;
	private String notifyTime;
	private String tradeStatus;
	private double totalFee;
	private String gmtPayment;
	private Date createDate;

	@Override
	public Date getCreateDate() {
		return createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getAlipaywapResultId() {
		return alipaywapResultId;
	}

	public void setAlipaywapResultId(long alipaywapResultId) {
		this.alipaywapResultId = alipaywapResultId;
	}

	public String getNotifyNotifyData() {
		return notifyNotifyData;
	}

	public void setNotifyNotifyData(String notifyNotifyData) {
		this.notifyNotifyData = notifyNotifyData;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(String notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public String getGmtPayment() {
		return gmtPayment;
	}

	public void setGmtPayment(String gmtPayment) {
		this.gmtPayment = gmtPayment;
	}

}
