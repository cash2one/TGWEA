package com.etaoguan.wea.service;

import java.util.List;
import java.util.Map;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.ProdQty;
import com.etaoguan.wea.vo.ProdStock;
import com.etaoguan.wea.vo.ProdStockDelta;
import com.etaoguan.wea.vo.StockTrace;

public interface IProdStockService {
	
	public void updateReduceStock(ProdStockDelta prodStockDelta);

	public void updateBatchReduceStock(List<ProdStockDelta> prodStockDeltaList);
	
	public void updateRaiseStock(ProdStockDelta prodStockDelta);
	
	public void updateBatchRaiseStock(List<ProdStockDelta> prodStockDeltaList);
	
	public void updateAllotProdStock(ProdStockDelta fromProdStockDelta,ProdStockDelta toProdStockDelta);
	
	@SuppressWarnings("rawtypes")
	public List<ProdStock> getProdStockList(String whNum, String ownerNum,List prodNums);
	
	@SuppressWarnings("rawtypes")
	public Map<String,ProdStock> getProdStockMap(String whNum, String ownerNum,List prodNums);
	
	public List<ProdStock> getProdStockList(String whNum, String ownerNum);
	
	public Map<String,ProdStock> getProdStockMap(String whNum, String ownerNum);
	
	public ProdStock getProdStock(String whNum, String ownerNum,String prodNum);
	
	public boolean existsProdStock(String whNum, String ownerNum);
	
	public void addProdStockTrace(StockTrace stockTrace);
	
	public void addProdStockTraces(List<StockTrace> stockTraceList);
	
	@SuppressWarnings("rawtypes")
	public DataSet listProdStock(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	@SuppressWarnings("rawtypes")
	public DataSet listStockTrace(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public boolean haveEnoughProdStocks(String whNum, String ownerNum, List<ProdQty> prodQtyList);
	
	public boolean haveEnoughProdStock(String whNum, String ownerNum, ProdQty prodQty);
}
