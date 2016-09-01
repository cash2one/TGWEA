package com.etaoguan.wea.service.impl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IPaymentInfoDao;
import com.etaoguan.wea.service.IPaymentInfoService;
import com.etaoguan.wea.vo.SupportOnlinePayType;


@Service("paymentInfoService")
public class PaymentInfoService implements IPaymentInfoService{

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(PaymentInfoService.class);
	
	@Autowired
	private IPaymentInfoDao iPaymentInfoDao;
	
	@Override
	public SupportOnlinePayType getSupportOnlinePayType(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		
		return iPaymentInfoDao.getSupportOnlinePayType(dataCriteria);
	}

}
