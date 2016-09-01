package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IProductGpsDao;
import com.etaoguan.wea.service.IProductGpsService;
import com.etaoguan.wea.vo.ProductGps;

/**
 * @author cunli
 * 产品定位
 */
@Service("productGpsService")
public class ProductGpsService  extends BaseService implements IProductGpsService {

	@Autowired
	private IProductGpsDao iProductGpsDao;
	
	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 产品定位 列表
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listProdcutsGps(DataCriteria dataCriteria,OffsetRequest offsetRequest) {
		return iProductGpsDao.getProductGps(dataCriteria, offsetRequest);
	}

	/* (non-Javadoc)删除产品定位
	 * @see com.etaoguan.wea.service.IProductGpsService#delProductGps(com.etaoguan.wea.vo.ProductGps)
	 */
	@Override
	public void delProductGps(ProductGps productGps) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum",productGps.getCustNum());
		dataCriteria.setParam("prodNum",productGps.getProdNum());
		iProductGpsDao.delProductGps(dataCriteria);
		
	}

	/* (non-Javadoc)获取产品定位列表
	 * @see com.etaoguan.wea.service.IProductGpsService#productGpsService(com.etaoguan.wea.vo.ProductGps)
	 */
	@Override
	public List<ProductGps> productGpsService(ProductGps productGps) {
		return iProductGpsDao.productGps(productGps);
	}


}
