package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.ProdStockSearch;
import com.etaoguan.wea.client.web.vo.StockTraceSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IProdStockService;

public interface IWProdStockService extends IProdStockService{
	
	@SuppressWarnings("rawtypes")
	public Map getListProdStocksSearchInitData(String ownerNum);

	@SuppressWarnings("rawtypes")
	public WPage listProdStocks(ProdStockSearch prodStockSearch,SortParam sortParam,WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getListStockTracesSearchInitData(String ownerNum);

	@SuppressWarnings("rawtypes")
	public WPage listStockTraces(StockTraceSearch stockTraceSearch,SortParam sortParam,WPagingRequest wpagingRequest);

}
