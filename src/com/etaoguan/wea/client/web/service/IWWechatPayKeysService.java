package com.etaoguan.wea.client.web.service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WechatPayKeysSearch;
import com.etaoguan.wea.service.IWechatPayKeysService;
import com.etaoguan.wea.vo.WechatPayKeys;

/**
 * @author cunli  微信支付用到的key
 *
 */
public interface IWWechatPayKeysService extends IWechatPayKeysService{
	
	/**
	 * @param wechatPayKeys
	 *            添加微信key
	 */
	public void addPayKeys(WechatPayKeys wechatPayKeys,String adminName);

	/**
	 * @param dataCriteria
	 *            删除微信key
	 */
	public void deletePayKeys(String ownerNum);

	/**
	 * @param dataCriteria
	 *            更新微信key
	 */
	public void updatePayKeys(WechatPayKeys wechatPayKeys,String adminName);

	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 微信key列表显示
	 */
	@SuppressWarnings("rawtypes")
	public WPage payKeysDataSet(WechatPayKeysSearch wechatPayKeysSearch,SortParam sortParam, WPagingRequest wpagingRequest);
	
	
}
