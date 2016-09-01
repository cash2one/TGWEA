package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.CustProdPriceSearch;
import com.etaoguan.wea.client.web.vo.ProdPriceSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IProdPriceService;
import com.etaoguan.wea.vo.CustProdPrice;
import com.etaoguan.wea.vo.ProdPrice;

public interface IWProdPriceService extends IProdPriceService {

	@SuppressWarnings("rawtypes")
	public WPage listProdPrices(ProdPriceSearch prodPriceSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getListProdPricesSearchInitData(String ownerNum);

	@SuppressWarnings("rawtypes")
	public WPage listCustProdPrices(CustProdPriceSearch custProdPriceSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);

	@SuppressWarnings("rawtypes")
	public Map getListCustProdPricesSearchInitData(String ownerNum);

	public void saveOrUpdateCustProdPrice(CustProdPrice custProdPrice);
	
	public void saveOrUpdateProdPrice(ProdPrice prodPrice);

}
