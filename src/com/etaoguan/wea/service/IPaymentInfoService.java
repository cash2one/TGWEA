package com.etaoguan.wea.service;

import com.etaoguan.wea.vo.SupportOnlinePayType;

public interface IPaymentInfoService {

	public SupportOnlinePayType getSupportOnlinePayType(String ownerNum);
}
