package com.etaoguan.wea.client.mobile.service;

import java.util.List;

import com.etaoguan.wea.service.IPushMessageService;

public interface IMPushMessageService extends IPushMessageService{

	public List<String> getCustPushGroupNums(String custNum);
}
