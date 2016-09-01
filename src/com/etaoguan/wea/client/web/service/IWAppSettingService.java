package com.etaoguan.wea.client.web.service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IAppSettingService;
import com.etaoguan.wea.vo.AppSetting;

public interface IWAppSettingService extends IAppSettingService{

	@SuppressWarnings("rawtypes")
	public WPage listAppSettings(SortParam sortParam, WPagingRequest wpagingRequest);
	
	public void saveOrUpdateAppSetting(AppSetting appSetting);
}
