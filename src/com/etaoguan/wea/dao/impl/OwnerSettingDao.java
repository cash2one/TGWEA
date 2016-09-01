package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IOwnerSettingDao;
import com.etaoguan.wea.vo.OwnerSetting;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class OwnerSettingDao extends SpringBaseDao implements IOwnerSettingDao{

	@Override
	@Resource(name="settingSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	@Override
	public void addOwnerSetting(OwnerSetting ownerSetting) {
		this.getSqlMapClientTemplate().insert("createOwnerSetting", ownerSetting);
		
	}

	@Override
	public void delOwnerSetting(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("deleteOwnerSetting", dataCriteria.getParams());
		
	}

	@Override
	public OwnerSetting getOwnerSetting(DataCriteria dataCriteria) {

		return (OwnerSetting)this.getSqlMapClientTemplate().queryForObject("getOwnerSetting",dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getOwnerSettingDataSet(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getOwnerSettingCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<OwnerSetting> ownerSettingList = this.getSqlMapClientTemplate().queryForList("getOwnerSettingDataSet", params);
		
		DataSet<OwnerSetting> dataSet = new DataSet<OwnerSetting>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(ownerSettingList);
		return dataSet;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OwnerSetting> getOwnerSettingList(DataCriteria dataCriteria) {

		return this.getSqlMapClientTemplate().queryForList("getOwnerSettingList", dataCriteria.getParams());
	}

	@Override
	public void updateOwnerSetting(OwnerSetting ownerSetting) {
		this.getSqlMapClientTemplate().update("updateOwnerSetting", ownerSetting);
		
	}
	
}
