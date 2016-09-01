package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IBasicDataDao;
import com.etaoguan.wea.service.IBasicDataService;
import com.etaoguan.wea.vo.ProvRegion;
import com.etaoguan.wea.vo.Trade;

@Service("basicDataService")
public class BasicDataService extends BaseService implements IBasicDataService{
	
	@Autowired 
	private IBasicDataDao iBasicDataDao;
	
	
	@Override
	public void addTrade(Trade trade) {
		
	}

	@Override
	public void delTrade(int tradeId) {
		
	}

	@Override
	public List<ProvRegion> getAllRegions() {
		DataCriteria dataCriteria = new DataCriteria();
		return iBasicDataDao.getRegions(dataCriteria);
	}

	@Override
	public List<Trade> getAllTrades() {
		DataCriteria dataCriteria = new DataCriteria();
		return iBasicDataDao.getTrades(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List getChildTradeIds(int parentTradeId) {
		return null;
	}

	@Override
	public boolean haveChildTrade(int parentTradeId) {
		return false;
	}

	@Override
	public List<Trade> listChildTrade(int parentTradeId) {
		return null;
	}

	@Override
	public List<Trade> listTopLevelTrade() {
		return null;
	}

	@Override
	public void updateTrade(Trade trade) {
		
	}

	@Override
	public List<String> getAllTables() {
		DataCriteria dataCriteria = new DataCriteria();
		return iBasicDataDao.getDBTableMetaData(dataCriteria);
	}

	@Override
	public List<String> getColumnsByTableName(String tableName) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("table", tableName);
		return iBasicDataDao.getDBColumnMetaData(dataCriteria);
	}

}
