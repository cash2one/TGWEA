package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.vo.MaxKeyValue;
import com.etaoguan.wea.vo.ProvRegion;
import com.etaoguan.wea.vo.Trade;

public interface IBasicDataDao {
	
	public MaxKeyValue getMaxKeyValue(DataCriteria dataCriteria);
	
	public void saveMaxKeyValue(MaxKeyValue maxKeyValue);
	
	public void updateMaxKeyValue(MaxKeyValue maxKeyValue);
	
	public void addTrade(Trade trade);
	
	public void updateTrade(Trade trade);
	
	public void delTrade(DataCriteria dataCriteria);
	
	public int getTradeCount(DataCriteria dataCriteria);
	
	public List<String> getTradeIds(DataCriteria dataCriteria);

	public List<Trade> getTrades(DataCriteria dataCriteria);
	
	public List<ProvRegion> getRegions(DataCriteria dataCriteria);
	
	/**
	 * 获取数据库TABLE META信息
	 */
	public List<String> getDBTableMetaData(DataCriteria dataCriteria);
	/**
	 * 获取数据库COLUMN META信息
	 */
	public List<String> getDBColumnMetaData(DataCriteria dataCriteria);

}
