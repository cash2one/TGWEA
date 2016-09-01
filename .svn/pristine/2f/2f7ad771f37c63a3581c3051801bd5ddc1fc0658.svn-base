package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.OwnerSettingSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IOwnerSettingService;
import com.etaoguan.wea.vo.OwnerSetting;

public interface IWOwnerSettingService extends IOwnerSettingService{

	@SuppressWarnings("rawtypes")
	public WPage listOwnerSettings(OwnerSettingSearch ownerSettingSearch,SortParam sortParam, WPagingRequest wpagingRequest);
	
	public void saveOrUpdateOwnerSetting(OwnerSetting ownerSetting);
	
	@SuppressWarnings("rawtypes")
	public Map getListOwnerSettingSearchInitData();
}
