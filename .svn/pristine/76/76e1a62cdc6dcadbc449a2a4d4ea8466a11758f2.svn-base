package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IAppSettingDao;
import com.etaoguan.wea.service.IAppSettingService;
import com.etaoguan.wea.vo.AppSetting;


@Service("appSettingService")
public class AppSettingService extends BaseService implements IAppSettingService {
	
	@Autowired
	private IAppSettingDao iAppSettingDao;



	@Override
	public void delAppSetting(long settingId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("settingId", settingId);
		iAppSettingDao.delAppSetting(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listAppSettings(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		
		return iAppSettingDao.getAppSettingDataSet(dataCriteria, offsetRequest);
	}

	@Override
	public void addAppSetting(AppSetting appSetting) {
		appSetting.setCreateBy(getCurrentOperator());
		appSetting.setUpdateBy(getCurrentOperator());
		iAppSettingDao.addAppSetting(appSetting);
	}

	@Override
	public void updateAppSetting(AppSetting appSetting) {
		appSetting.setUpdateBy(getCurrentOperator());
		iAppSettingDao.updateAppSetting(appSetting);
		
	}

	@Override
	public List<AppSetting> getAllAppSettingList() {
		DataCriteria dataCriteria = new DataCriteria();
		return iAppSettingDao.getAppSettingList(dataCriteria);
	}
	
}
