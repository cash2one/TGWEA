package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.ProductGps;

/**
 * @author cunli
 * 产品定位
 */
public interface IProductGpsDao {
	/**
	 * @param productGps
	 * @return 获取产品定位列表
	 */
	public List<ProductGps> productGps(ProductGps productGps);
	/**
	 * 添加 产品定位
	 * 
	 * @param dataCriteria
	 */
	public void addProductgps(ProductGps productGps);

	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 产品定位 列表
	 */
	@SuppressWarnings("rawtypes")
	public DataSet getProductGps(DataCriteria dataCriteria,
			OffsetRequest offsetRequest);

	/**
	 * 删除 产品定位
	 * 
	 * @param dataCriteria
	 */
	public void delProductGps(DataCriteria dataCriteria);
}
