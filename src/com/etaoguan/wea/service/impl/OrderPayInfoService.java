package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.dao.IOrderPayInfoDao;
import com.etaoguan.wea.service.IOrderPayInfoService;
import com.etaoguan.wea.vo.OrderPayInfo;

@Service("orderPayInfoService")
public class OrderPayInfoService  extends BaseService implements IOrderPayInfoService {

	@Autowired
	private IOrderPayInfoDao iOrderPayInfoDao;

	@Override
	public void saveOrderPayInfoDao(OrderPayInfo orderPayInfo) {
		iOrderPayInfoDao.saveOrderPayInfoDao(orderPayInfo);
	}

	
	
	
}
