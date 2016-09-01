package com.etaoguan.wea.client.web.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWAlipayKeysService;
import com.etaoguan.wea.client.web.vo.AlipayKeysSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.AlipayKeysService;
import com.etaoguan.wea.vo.AlipayKeys;

/**
 * @author cunli 客户支付宝的key
 *
 */
@Service("walipayKeysService")
public class WAlipayKeysService extends AlipayKeysService implements IWAlipayKeysService{

	/* (non-Javadoc)添加客户支付宝的key
	 * @see com.etaoguan.wea.client.web.service.IWAlipayKeysService#addKeys(com.etaoguan.wea.vo.AlipayKeys)
	 */
	@Override
	public void addKeys(AlipayKeys alipayKeys) {
		addAlipayKeys(alipayKeys);
	}

	/* (non-Javadoc)删除客户支付宝的key
	 * @see com.etaoguan.wea.client.web.service.IWAlipayKeysService#deleteKeys(int)
	 */
	@Override
	public void deleteKeys(String userId) {
		deleteAlipayKeys(userId);
	}

	/* (non-Javadoc)修改客户支付宝的key
	 * @see com.etaoguan.wea.client.web.service.IWAlipayKeysService#updatekeys(com.etaoguan.wea.vo.AlipayKeys)
	 */
	@Override
	public void updatekeys(AlipayKeys alipayKeys) {
		updateAlipaykeys(alipayKeys);
	}

	/* (non-Javadoc)客户支付宝的key的列表
	 * @see com.etaoguan.wea.client.web.service.IWAlipayKeysService#keysDataSet(com.etaoguan.wea.common.DataCriteria, com.etaoguan.wea.common.OffsetRequest)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public WPage keysDataSet(AlipayKeysSearch alipayKeysSearch,SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.extractSortParam(sortParam);
		
		dataCriteria.setParam("companyName", alipayKeysSearch.getUserName());
		
		DataSet dataSet =  alipayKeysDataSet(dataCriteria, offsetRequest);
		return new WPage(wpagingRequest,dataSet);
	}

}
