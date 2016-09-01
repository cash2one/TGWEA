package com.etaoguan.wea.vo;

public class Trade extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tradeId;
	private String tradeName;
	private String parentTradeId;

	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public String getParentTradeId() {
		return parentTradeId;
	}
	public void setParentTradeId(String parentTradeId) {
		this.parentTradeId = parentTradeId;
	}

}
