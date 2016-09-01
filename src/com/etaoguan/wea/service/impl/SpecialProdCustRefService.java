package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.ISpecialProdCustRefDao;
import com.etaoguan.wea.service.ISpecialProdCustRefService;

/**
 * @author cunli
 * 特供产品表
 */
@Service("specialProdCustRefService")
public class SpecialProdCustRefService extends BaseService implements ISpecialProdCustRefService {

	@Autowired
	private ISpecialProdCustRefDao iSpecialProdCustRefDao;
	
	
	/* (non-Javadoc)根据组名查询特供产品，获得属于某个人的特供产品列表
	 * @see com.etaoguan.wea.service.ISpecialProdCustRefService#specialprods(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public DataSet specialprods(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iSpecialProdCustRefDao.specialprods(dataCriteria, offsetRequest);
	}

}
