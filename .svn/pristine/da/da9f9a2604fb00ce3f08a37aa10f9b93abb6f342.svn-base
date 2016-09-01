package com.etaoguan.wea.client.web.service;

import com.etaoguan.wea.client.web.vo.ProductGpsSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IProductGpsService;
import com.etaoguan.wea.vo.ProductGps;

public interface IWProductGpsService extends IProductGpsService {
	
	/**添加产品定位
	 * @param productGps
	 */
	public void addProductgps(ProductGps productGps);
	
	/**
	 * @param wpagingRequest
	 * @return  产品定位
	 */
	@SuppressWarnings("rawtypes")
	public WPage listProductsGps(ProductGpsSearch productGpsSearch,WPagingRequest wpagingRequest);

}
