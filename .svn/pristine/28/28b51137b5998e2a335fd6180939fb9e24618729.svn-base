package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.ProdStock;
import com.etaoguan.wea.vo.StockTrace;

public interface IProdStockDao {
	
	public void addProdStock(ProdStock prodStock);
	
	public void updateProdStock(ProdStock prodStock);
	
	public List<ProdStock> getProdStockList(DataCriteria dataCriteria);
	
	public ProdStock getProdStock(DataCriteria dataCriteria);
	
	public void addProdStockTrace(StockTrace stockTrace);
	
	public int getProdStockCount(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getProdStocks(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	@SuppressWarnings("rawtypes")
	public DataSet getStockTraces(DataCriteria dataCriteria,OffsetRequest offsetRequest);

}
