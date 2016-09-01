package com.etaoguan.wea.service;

import com.etaoguan.wea.vo.OrderPayInfo;

/**
 * @author cunli 支付宝订单状态
 *
 */
public interface IOrderPayInfoService {
	/**
	 * @param orderPayInfo 保存支付宝订单状态
	 */
	public void saveOrderPayInfoDao(OrderPayInfo orderPayInfo);

}
