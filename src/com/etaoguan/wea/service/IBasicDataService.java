package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.vo.ProvRegion;
import com.etaoguan.wea.vo.Trade;

public interface IBasicDataService {
	
	public void addTrade(Trade trade);
	
	public void updateTrade(Trade trade);
	
	public void delTrade(int tradeId);
	
	public boolean haveChildTrade(int parentTradeId);
	
	@SuppressWarnings("rawtypes")
	public List getChildTradeIds(int parentTradeId);
	
	public List<Trade> listChildTrade(int parentTradeId);
	
	public List<Trade> listTopLevelTrade();
	
	public List<Trade> getAllTrades();
	
	public List<ProvRegion> getAllRegions();
	
	public List<String> getAllTables();
	
	public List<String> getColumnsByTableName(String tableName);

}
