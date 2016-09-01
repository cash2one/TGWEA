package com.etaoguan.wea.client.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWProductGpsService;
import com.etaoguan.wea.client.web.vo.ProductGpsSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IProductGpsDao;
import com.etaoguan.wea.service.impl.ProductGpsService;
import com.etaoguan.wea.vo.ProductGps;

@Service("wproductGpsService")
public class WProductGpsService extends ProductGpsService implements IWProductGpsService{

	@Autowired
	IProductGpsDao iProductGpsDao;
	
	
	/**
	 * @param prodPriceSearch
	 * @param sortParam
	 * @param wpagingRequest
	 * @return 产品定位
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listProductsGps(ProductGpsSearch productGpsSearch,WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", productGpsSearch.getOwnerNum());
		dataCriteria.setParam("custNum", productGpsSearch.getCustNum());
		dataCriteria.setParam("prodName", productGpsSearch.getProdName());
		DataSet dataSet = listProdcutsGps(dataCriteria,offsetRequest);
		return new WPage(wpagingRequest,dataSet);
	}

	/* (non-Javadoc)添加 产品定位信息
	 * @see com.etaoguan.wea.client.web.service.IWProductGpsService#addProductgps(com.etaoguan.wea.vo.ProductGps)
	 */
	@Override
	public void addProductgps(ProductGps productGps) {
		iProductGpsDao.addProductgps(productGps);
	}

}
