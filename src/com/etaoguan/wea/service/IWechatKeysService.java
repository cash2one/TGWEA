package com.etaoguan.wea.service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.WechatKeys;

public interface IWechatKeysService {

	@SuppressWarnings("rawtypes")
	public DataSet listWechatKeys(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addWechatKeys(WechatKeys wechatKeys);
	
	public void delWechatKeys(String ownerNum);
	
	public void updateWechatKeys(WechatKeys wechatKeys);
	
	public WechatKeys getWechatKeys(String ownerNum);
}
