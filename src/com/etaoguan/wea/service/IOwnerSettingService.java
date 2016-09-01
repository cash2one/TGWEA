package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.OwnerSetting;

public interface IOwnerSettingService {

	@SuppressWarnings("rawtypes")
	public DataSet listOwnerSettings(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public List<OwnerSetting> getAllOwnerSettingList(String ownerNum);
	
	public List<OwnerSetting> getAllOwnerSettingList();
	
	public void addOwnerSetting(OwnerSetting ownerSetting);
	
	public void updateOwnerSetting(OwnerSetting ownerSetting);
	
	public void delOwnerSetting(long settingId);


}
