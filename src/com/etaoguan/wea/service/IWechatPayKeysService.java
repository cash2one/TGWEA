package com.etaoguan.wea.service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.WechatPayKeys;


/**
 * @author cunli 微信付款的key
 *
 */
public interface IWechatPayKeysService {
	
	/**
	 * @param dataCriteria
	 * @return 获取客户微信付款的key
	 */
	public WechatPayKeys wechatPayKeysInformation(String ownerNum);

	/**
	 * @param wechatPayKeys
	 *            添加微信key
	 */
	public void addWechatPayKeys(WechatPayKeys wechatPayKeys,String adminName);

	/**
	 * @param dataCriteria
	 *            删除微信key
	 */
	public void deleteWechatPayKeys(String ownerNum);

	/**
	 * @param dataCriteria
	 *            更新微信key
	 */
	public void updateWechatPayKeys(WechatPayKeys wechatPayKeys,String adminName);

	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 微信key列表显示
	 */
	@SuppressWarnings("rawtypes")
	public DataSet wechatPayKeysDataSet(DataCriteria dataCriteria, OffsetRequest offsetRequest);
	
}
