package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.ISettleInvDao;
import com.etaoguan.wea.service.ISettleInvService;
import com.etaoguan.wea.vo.ProdQty;

@Service("settleInvService")
public class SettleInvService  extends BaseService implements ISettleInvService {

	@Autowired
	private ISettleInvDao iSettleInvDao;
	
	@Override
	public double getSettleInvPriceDelta(String orderNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("orderNum",orderNum);
		return iSettleInvDao.getSettleInvPriceDelta(dataCriteria);
	}

	@Override
	public List<ProdQty> getSettleInvProdDelta(String orderNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("orderNum",orderNum);
		return iSettleInvDao.getSettleInvProdDelta(dataCriteria);
	}


}
