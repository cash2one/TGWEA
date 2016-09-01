package com.etaoguan.wea.dao;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.AlipayKeys;

/**
 * @author cunli 客户支付宝的key
 *
 */
public interface IAlipayKeysDao {
	
	/**
	 * @param dataCriteria
	 * @return 根据owenrNum 获取用户的partner
	 */
	AlipayKeys alipayKeysInformation(DataCriteria dataCriteria);
	
	/**
	 * @param alipayKeys 添加客户支付宝的key
	 */
	public void addAlipayKeys(AlipayKeys alipayKeys);
	/**
	 * @param dataCriteria 删除客户支付宝的key
	 */
	public void deleteAlipayKeys(DataCriteria dataCriteria);
	/**
	 * @param dataCriteria 修改客户支付宝的key
	 */
	public void updateAlipaykeys(DataCriteria dataCriteria);
	/**
	 * @return 客户支付宝的key的列表
	 */
	@SuppressWarnings("rawtypes")
	public DataSet alipayKeysDataSet(DataCriteria dataCriteria,OffsetRequest offsetRequest);
}
