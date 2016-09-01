package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IProdStockDao;
import com.etaoguan.wea.vo.ProdStock;
import com.etaoguan.wea.vo.StockTrace;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ProdStockDao extends SpringBaseDao implements IProdStockDao{

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(ProdStockDao.class);
	
	@Override
	@Resource(name="prodStockSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	@Override
	public void addProdStockTrace(StockTrace stockTrace) {
		this.getSqlMapClientTemplate().insert("createStockTrace", stockTrace);
		
	}

	@Override
	public ProdStock getProdStock(DataCriteria dataCriteria) {

		return (ProdStock)this.getSqlMapClientTemplate().queryForObject("getProdStock", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProdStock> getProdStockList(DataCriteria dataCriteria) {

		return this.getSqlMapClientTemplate().queryForList("getProdStockList", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getProdStocks(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getProdStockCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<ProdStock> prodStockList = this.getSqlMapClientTemplate().queryForList("getProdStockDataSet", params);
		
		DataSet<ProdStock> dataSet = new DataSet<ProdStock>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(prodStockList);
		return dataSet;
	}

	@Override
	public void updateProdStock(ProdStock prodStock) {
		this.getSqlMapClientTemplate().update("updateProdStock", prodStock);
	}

	@Override
	public void addProdStock(ProdStock prodStock) {
		this.getSqlMapClientTemplate().insert("createProdStock", prodStock);
		
	}

	@Override
	public int getProdStockCount(DataCriteria dataCriteria) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("getProdStockCount", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getStockTraces(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getStockTraceCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<StockTrace> stockTraceList = this.getSqlMapClientTemplate().queryForList("getStockTraceDataSet", params);
		
		DataSet<StockTrace> dataSet = new DataSet<StockTrace>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(stockTraceList);
		return dataSet;
	}
}
