package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IBasicDataDao;
import com.etaoguan.wea.vo.MaxKeyValue;
import com.etaoguan.wea.vo.ProvRegion;
import com.etaoguan.wea.vo.Trade;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class BasicDataDao extends SpringBaseDao implements IBasicDataDao{

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(BasicDataDao.class);
	
	@Override
	@Resource(name="basicBataSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addTrade(Trade trade) {
		this.getSqlMapClientTemplate().insert("createTrade", trade);
		
	}

	@Override
	public void delTrade(DataCriteria dataCriteria) {
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProvRegion> getRegions(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getProvRegions",dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Trade> getTrades(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getTrades",dataCriteria.getParams());
	}

	@Override
	public int getTradeCount(DataCriteria dataCriteria) {
		return 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getTradeIds(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getTradeIds",dataCriteria.getParams());
	}

	@Override
	public MaxKeyValue getMaxKeyValue(DataCriteria dataCriteria) {
		return (MaxKeyValue)this.getSqlMapClientTemplate().queryForObject("getMaxKeyValue", dataCriteria.getParams());
	}

	@Override
	public void saveMaxKeyValue(MaxKeyValue maxKeyValue) {
		this.getSqlMapClientTemplate().insert("createMaxKeyValue", maxKeyValue);
		
	}

	@Override
	public void updateMaxKeyValue(MaxKeyValue maxKeyValue) {
		this.getSqlMapClientTemplate().update("updateMaxKeyValue", maxKeyValue);
		
	}

	@Override
	public void updateTrade(Trade trade) {
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getDBColumnMetaData(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getDBColumnMetaData",dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getDBTableMetaData(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getDBTableMetaData",dataCriteria.getParams());
	}

}
