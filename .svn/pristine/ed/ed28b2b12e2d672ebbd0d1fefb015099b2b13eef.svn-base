package com.etaoguan.wea.client.web.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWWechatPayKeysService;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WechatPayKeysSearch;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.WechatPayKeysService;
import com.etaoguan.wea.vo.WechatPayKeys;

/**
 * @author cunli 微信支付用到的key
 *
 */
@Service("wwechatPayKeysService")
public class WWechatPayKeysService extends WechatPayKeysService implements IWWechatPayKeysService{

	/**
	 * @param wechatPayKeys 添加微信key
	 */
	@Override
	public void addPayKeys(WechatPayKeys wechatPayKeys,String adminName) {
		addWechatPayKeys(wechatPayKeys,adminName);
	}

	/**
	 * @param ownerNum 删除微信key
	 */
	@Override 
	public void deletePayKeys(String ownerNum) {
		deleteWechatPayKeys(ownerNum);
	}

	/**
	 * @param wechatPayKeys 更新微信key
	 */
	@Override
	public void updatePayKeys(WechatPayKeys wechatPayKeys,String adminName) {
		updateWechatPayKeys(wechatPayKeys,adminName);
	}

	/**
	 * @param wechatPayKeysSearch
	 * @param sortParam
	 * @param wpagingRequest
	 * @return 微信key列表显示
	 */
	@SuppressWarnings("rawtypes")                                                                                                                            
	@Override
	public WPage payKeysDataSet(WechatPayKeysSearch wechatPayKeysSearch,SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.extractSortParam(sortParam);
		
		dataCriteria.setParam("companyName", wechatPayKeysSearch.getCompanyName());
		
		DataSet dataSet =  wechatPayKeysDataSet(dataCriteria, offsetRequest);
		return new WPage(wpagingRequest,dataSet);
	}
	
}
