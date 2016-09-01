package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.ProductGps;

/**
 * @author cunli
 * 产品定位
 */
public interface IProductGpsService {
	/**
	 * @param productGps
	 * @return 获取产品定位列表
	 */
	public List<ProductGps> productGpsService(ProductGps productGps);
	/**
	 * 删除产品定位
	 * 
	 * @param productGps
	 */
	public void delProductGps(ProductGps productGps);

	/**
	 * @param offsetRequest
	 * @return 产品定位 列表
	 */
	@SuppressWarnings("rawtypes")
	public DataSet listProdcutsGps(DataCriteria dataCriteria,
			OffsetRequest offsetRequest);

}
