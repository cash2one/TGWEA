package com.etaoguan.wea.wechat.vo;

import com.etaoguan.wea.vo.BaseVo;

/**
 * @author cunli
 * 提交给微信的订单
 */
@SuppressWarnings("serial")
public class WechatpayRequest extends BaseVo {
	private int wechatpayId;
	private String appid;
	private String mchId;
	private String reqData;
	private String outTradeNo;
	private int totalFee;
	private String spbillCreateIp;
	private String openid;
	private String respDate;
	private String respStatus;

	public int getWechatpayId() {
		return wechatpayId;
	}

	public void setWechatpayId(int wechatpayId) {
		this.wechatpayId = wechatpayId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getReqData() {
		return reqData;
	}

	public void setReqData(String reqData) {
		this.reqData = reqData;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getRespDate() {
		return respDate;
	}

	public void setRespDate(String respDate) {
		this.respDate = respDate;
	}

	public String getRespStatus() {
		return respStatus;
	}

	public void setRespStatus(String respStatus) {
		this.respStatus = respStatus;
	}
}
