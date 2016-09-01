package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IOwnerSettingDao;
import com.etaoguan.wea.service.IOwnerSettingService;
import com.etaoguan.wea.vo.OwnerSetting;


@Service("ownerSettingService")
public class OwnerSettingService extends BaseService implements IOwnerSettingService {
	
	@Autowired
	private IOwnerSettingDao iOwnerSettingDao;

	@Override
	public void delOwnerSetting(long settingId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("settingId", settingId);
		iOwnerSettingDao.delOwnerSetting(dataCriteria);
		
	}

	@Override
	public List<OwnerSetting> getAllOwnerSettingList(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		return iOwnerSettingDao.getOwnerSettingList(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listOwnerSettings(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iOwnerSettingDao.getOwnerSettingDataSet(dataCriteria, offsetRequest);
	}

	@Override
	public void addOwnerSetting(OwnerSetting ownerSetting) {
		ownerSetting.setCreateBy(getCurrentOperator());
		ownerSetting.setUpdateBy(getCurrentOperator());
		iOwnerSettingDao.addOwnerSetting(ownerSetting);
	}

	@Override
	public void updateOwnerSetting(OwnerSetting ownerSetting) {
		ownerSetting.setUpdateBy(getCurrentOperator());
		iOwnerSettingDao.updateOwnerSetting(ownerSetting);
		
	}

	@Override
	public List<OwnerSetting> getAllOwnerSettingList() {
		DataCriteria dataCriteria = new DataCriteria();
		return iOwnerSettingDao.getOwnerSettingList(dataCriteria);
	}


}
