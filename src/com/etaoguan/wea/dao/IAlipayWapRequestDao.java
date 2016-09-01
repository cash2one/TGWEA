package com.etaoguan.wea.dao;

import com.etaoguan.wea.vo.AlipayWapRequest;

/**
 * @author cunli 发送到支付宝的数据
 *
 */
public interface IAlipayWapRequestDao {
	
	
	/**
	 * @param alipayWapRequest 保存 发送到支付宝的数据
	 */
	public void saveAlipayWapRequest(AlipayWapRequest alipayWapRequest);

	
}
