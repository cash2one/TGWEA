package com.etaoguan.wea.dao;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.WechatPayKeys;

/**
 * @author cunli 微信付款的key
 *
 */
public interface IWechatPayKeysDao {

	/**
	 * @param dataCriteria
	 * @return 获取客户微信付款的key
	 */
	public WechatPayKeys wechatPayKeysInformation(DataCriteria dataCriteria);

	/**
	 * @param wechatPayKeys
	 *            添加微信key
	 */
	public void addWechatPayKeys(WechatPayKeys wechatPayKeys);

	/**
	 * @param dataCriteria
	 *            删除微信key
	 */
	public void deleteWechatPayKeys(DataCriteria dataCriteria);

	/**
	 * @param dataCriteria
	 *            更新微信key
	 */
	public void updateWechatPayKeys(DataCriteria dataCriteria);

	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 微信key列表显示
	 */
	@SuppressWarnings("rawtypes")
	public DataSet wechatPayKeysDataSet(DataCriteria dataCriteria, OffsetRequest offsetRequest);
}
