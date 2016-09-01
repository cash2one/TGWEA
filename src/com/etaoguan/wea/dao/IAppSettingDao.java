package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.AppSetting;

public interface IAppSettingDao {
	
	/**
	 * 获取系统配置
	 */
	public AppSetting getAppSetting(DataCriteria dataCriteria);
	/**
	 * 获取分页系统配置信息
	 * @param id
	 */
	@SuppressWarnings("rawtypes")
	public DataSet getAppSettingDataSet(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	/**
	 * 获取系统配置信息列表
	 * @param id
	 */
	public List<AppSetting> getAppSettingList(DataCriteria dataCriteria);
	
	/**
	 * 删除系统配置
	 * @param id
	 */
	public void delAppSetting(DataCriteria dataCriteria);
	/**
	 * 保存系统配置
	 */
	public void addAppSetting(AppSetting appSetting);

	/**
	 * 修改系统配置
	 */
	public void updateAppSetting(AppSetting appSetting);

}
