package com.etaoguan.wea.dao;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;

/**
 * @author cunli
 * 特供产品表
 */
public interface ISpecialProdCustRefDao {

	/**
	 * @param dataCriteria
	 * @return 根据组名查询特供产品，获得属于某个人的特供产品列表
	 */
	@SuppressWarnings("rawtypes")
	public DataSet specialprods(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
}
