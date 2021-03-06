package com.etaoguan.wea.client.web.service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.AlipayKeysSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IAlipayKeysService;
import com.etaoguan.wea.vo.AlipayKeys;

/**
 * @author cunli  客户支付宝的key
 *
 */
public interface IWAlipayKeysService extends IAlipayKeysService{
	/**
	 * @param alipayKeys 添加客户支付宝的key
	 */
	public void addKeys(AlipayKeys alipayKeys);
	/**
	 * @param dataCriteria 删除客户支付宝的key
	 */
	public void deleteKeys(String userId);
	/**
	 * @param dataCriteria 修改客户支付宝的key
	 */
	public void updatekeys(AlipayKeys alipayKeys);
	/**
	 * @return 客户支付宝的key的列表
	 */
	@SuppressWarnings("rawtypes")
	public WPage keysDataSet(AlipayKeysSearch alipayKeysSearch,SortParam sortParam, WPagingRequest wpagingRequest);
}
