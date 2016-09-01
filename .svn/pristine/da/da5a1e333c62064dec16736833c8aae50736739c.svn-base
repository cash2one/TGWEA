package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IAppSettingDao;
import com.etaoguan.wea.vo.AppSetting;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class AppSettingDao extends SpringBaseDao implements IAppSettingDao{

	@Override
	@Resource(name="settingSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	@Override
	public void addAppSetting(AppSetting appSetting) {
		this.getSqlMapClientTemplate().insert("createAppSetting", appSetting);
	}

	@Override
	public void delAppSetting(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("deleteAppSetting", dataCriteria.getParams());
	}

	@Override
	public AppSetting getAppSetting(DataCriteria dataCriteria) {
		
		return (AppSetting)this.getSqlMapClientTemplate().queryForObject("getAppSetting",dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getAppSettingDataSet(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getAppSettingCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<AppSetting> appSettingList = this.getSqlMapClientTemplate().queryForList("getAppSettingDataSet", params);
		
		DataSet<AppSetting> dataSet = new DataSet<AppSetting>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(appSettingList);
		return dataSet;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AppSetting> getAppSettingList(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getAppSettingList", dataCriteria.getParams());
	}

	@Override
	public void updateAppSetting(AppSetting appSetting) {
		this.getSqlMapClientTemplate().update("updateAppSetting", appSetting);
		
	}
}
