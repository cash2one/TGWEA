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
import com.etaoguan.wea.client.web.service.IWProdPriceService;
import com.etaoguan.wea.client.web.vo.CustProdPriceSearch;
import com.etaoguan.wea.client.web.vo.ProdPriceSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.CustProdPrice;
import com.etaoguan.wea.vo.ProdPrice;

@SuppressWarnings("serial")
@WeaModule(mname="产品价格管理")
@Service("ownerWProdPriceAction") @Scope("prototype")
public class WProdPriceAction extends WOwnerBaseAction{

	private ProdPriceSearch prodPriceSearch = new ProdPriceSearch();
	
	private CustProdPriceSearch custProdPriceSearch = new CustProdPriceSearch();
	
	private ProdPrice prodPrice;
	
	private CustProdPrice custProdPrice;
	
	@Resource(name="wprodPriceService")
	private IWProdPriceService iwProdPriceService;
	
	@WeaFunction(fname="查看产品标准价格列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListProdPrices",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_prodprices.jsp")})
	public String listProdPrices() throws IOException {

		return SUCCESS;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看产品标准价格列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListProdPricesData")
	public String listProdPricesData() throws IOException {
		prodPriceSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwProdPriceService.listProdPrices(prodPriceSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}

	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="搜索选择产品标准价格",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListProdPricesSearchInitData")
	public String getListProdPricesSearchInitData() throws IOException {
		Map initSearchDataMap = iwProdPriceService.getListProdPricesSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="更新产品标准价格",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveProdStdPrice")
	public String saveProdStdPrice() throws IOException {
		prodPrice.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwProdPriceService.saveOrUpdateProdPrice(prodPrice);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="更新产品标准价格",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wListCustProdPrices",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_cust_prodprices.jsp")})
	public String listCustProdPrices() throws IOException {

		return SUCCESS;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看产品客户价格列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListCustProdPricesData")
	public String listCustProdPricesData() throws IOException {
		custProdPriceSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwProdPriceService.listCustProdPrices(custProdPriceSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}

	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="搜索选择产品客户价格",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListCustProdPricesSearchInitData")
	public String getListCustProdPricesSearchInitData() throws IOException {
		Map initSearchDataMap = iwProdPriceService.getListCustProdPricesSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="更新产品客户价格",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveCustProdPrice")
	public String saveCustProdStdPrice() throws IOException {
		custProdPrice.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwProdPriceService.saveOrUpdateCustProdPrice(custProdPrice);
		return JSONRESPONSE;
	}
	
	public ProdPriceSearch getProdPriceSearch() {
		return prodPriceSearch;
	}

	public void setProdPriceSearch(ProdPriceSearch prodPriceSearch) {
		this.prodPriceSearch = prodPriceSearch;
	}

	public ProdPrice getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(ProdPrice prodPrice) {
		this.prodPrice = prodPrice;
	}

	public CustProdPriceSearch getCustProdPriceSearch() {
		return custProdPriceSearch;
	}

	public void setCustProdPriceSearch(CustProdPriceSearch custProdPriceSearch) {
		this.custProdPriceSearch = custProdPriceSearch;
	}

	public CustProdPrice getCustProdPrice() {
		return custProdPrice;
	}

	public void setCustProdPrice(CustProdPrice custProdPrice) {
		this.custProdPrice = custProdPrice;
	}
}
