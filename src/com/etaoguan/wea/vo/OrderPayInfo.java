package com.etaoguan.wea.vo;

import java.util.Date;

/**
 * @author cunli 记录支付宝订单状态
 * 
 */
public class OrderPayInfo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNum;
	private String ownerNum;
	private String custNum;
	private int payType;
	private long payTransId;
	private Date createDate;
	private String createBy;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public long getPayTransId() {
		return payTransId;
	}

	public void setPayTransId(long payTransId) {
		this.payTransId = payTransId;
	}

	@Override
	public Date getCreateDate() {
		return createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
}
