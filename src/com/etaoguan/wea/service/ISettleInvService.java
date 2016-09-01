package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.vo.ProdQty;

public interface ISettleInvService {
	
	public double getSettleInvPriceDelta(String orderNum);
	
	public List<ProdQty> getSettleInvProdDelta(String orderNum);

}
