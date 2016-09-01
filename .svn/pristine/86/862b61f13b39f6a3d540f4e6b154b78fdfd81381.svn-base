package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWProdStockService;
import com.etaoguan.wea.client.web.vo.ProdStockSearch;
import com.etaoguan.wea.client.web.vo.StockTraceSearch;
import com.etaoguan.wea.client.web.vo.WPage;

@SuppressWarnings("serial")
@WeaModule(mname="产品库存管理")
@Service("ownerWProdStockAction") @Scope("prototype")
public class WProdStockAction extends WOwnerBaseAction{

	@Resource(name="wprodStockService")
	private IWProdStockService iWProdStockService;
	
	private ProdStockSearch prodStockSearch = new ProdStockSearch();
	
	private StockTraceSearch stockTraceSearch = new StockTraceSearch();
	
	@WeaFunction(fname="查看产品库存列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListProdStocks",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_prodstocks.jsp")})
	public String listProdStocks() throws IOException {

		return SUCCESS;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看产品库存列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListProdStocksData")
	public String listProdStocksData() throws IOException {
		prodStockSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWProdStockService.listProdStocks(prodStockSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="搜索选择产品库存",oname=WeaFunction.Operation.READ)
	@Action(value="wListSearchProdStockData")
	public String listSearchProdStockData() throws IOException {
		prodStockSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWProdStockService.listProdStocks(prodStockSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取产品库存列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListProdStocksSearchInitData")
	public String getListProdStocksSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listProdStocksData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iWProdStockService.getListProdStocksSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="查看产品库存跟踪列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListStockTrace",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_stocktrace.jsp")})
	public String listStockTrace() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看产品库存跟踪列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListStockTraceData")
	public String listStockTraceData() throws IOException {
		stockTraceSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWProdStockService.listStockTraces(stockTraceSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取产品库存跟踪列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListStockTraceSearchInitData")
	public String getListStockTraceSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listStockTraceData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iWProdStockService.getListStockTracesSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}


	public ProdStockSearch getProdStockSearch() {
		return prodStockSearch;
	}

	public void setProdStockSearch(ProdStockSearch prodStockSearch) {
		this.prodStockSearch = prodStockSearch;
	}

	public StockTraceSearch getStockTraceSearch() {
		return stockTraceSearch;
	}

	public void setStockTraceSearch(StockTraceSearch stockTraceSearch) {
		this.stockTraceSearch = stockTraceSearch;
	}


}
