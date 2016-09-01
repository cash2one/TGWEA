package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.AppSetting;

public interface IAppSettingService {
	
	@SuppressWarnings("rawtypes")
	public DataSet listAppSettings(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public List<AppSetting> getAllAppSettingList();
	
	public void addAppSetting(AppSetting appSetting);
	
	public void updateAppSetting(AppSetting appSetting);
	
	public void delAppSetting(long settingId);


}
