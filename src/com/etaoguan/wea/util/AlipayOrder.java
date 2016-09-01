package com.etaoguan.wea.util;

/**
 * @author cunli 发送支付宝的订单数据（这是辅助发送数据用的）
 *
 */
public class AlipayOrder {
	private String subject;
	private String out_trade_no;
	private String total_fee;
	private String seller_account_name;
	private String call_back_url;
	private String notify_url;
	private String out_user;
	private String merchant_url;
	private String pay_expire;
	private String agent_id;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSeller_account_name() {
		return seller_account_name;
	}

	public void setSeller_account_name(String seller_account_name) {
		this.seller_account_name = seller_account_name;
	}

	public String getCall_back_url() {
		return call_back_url;
	}

	public void setCall_back_url(String call_back_url) {
		this.call_back_url = call_back_url;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getOut_user() {
		return out_user;
	}

	public void setOut_user(String out_user) {
		this.out_user = out_user;
	}

	public String getMerchant_url() {
		return merchant_url;
	}

	public void setMerchant_url(String merchant_url) {
		this.merchant_url = merchant_url;
	}

	public String getPay_expire() {
		return pay_expire;
	}

	public void setPay_expire(String pay_expire) {
		this.pay_expire = pay_expire;
	}

	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

}
