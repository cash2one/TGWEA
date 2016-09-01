package com.etaoguan.wea.client.mobile.action.owner;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMProdPriceService;
import com.etaoguan.wea.client.mobile.service.IMProductService;
import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.ProdSearch;
import com.etaoguan.wea.vo.ProdPrice;
import com.etaoguan.wea.vo.Product;
@SuppressWarnings("serial")
@WeaModule(mname="产品管理")
@Service("ownerMProdAction") @Scope("prototype")
public class MProdAction extends MOwnerBaseAction{
	
	
	@Resource(name="mproductService")
	private IMProductService imProductService;
	
	@Resource(name="mprodPriceService")
	private IMProdPriceService imProdPriceService;
	
	private Product product;
	
	private ProdPrice prodPrice;
	
	private ProdSearch prodSearch = new ProdSearch();
	
	@WeaFunction(fname="更新产品显示库存(移动端)",oname=WeaFunction.Operation.UPDATE)
	@Action(value="mUpdateProdDispStockBalance")
	public String updateProdDispStockBalance() throws IOException {
		
		imProductService.updateDispStockBalance(product.getProdNum(), product.getDispStockBalance());
		return JSONRESPONSE;
	}
	@WeaFunction(fname="更新产品标准价格(移动端)",oname=WeaFunction.Operation.UPDATE)
	@Action(value="mUpdateProdPrice")
	public String updateProdPrice() throws IOException {
		prodPrice.setOwnerNum(ownerNum);
		imProdPriceService.updateProdPrice(prodPrice.getProdNum(),prodPrice.getProdPrice());
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看产品列表(移动端)",oname=WeaFunction.Operation.READ)
	@Action(value="mListProducts")
	public String listProducts() throws IOException {
		prodSearch.setOwnerNum(ownerNum);
		MPage mpage = imProductService.listProducts(prodSearch, sortParam, mpagingRequest);
		weaResponse.setRespData(mpage);
		return JSONRESPONSE;
	}

	public Product getProduct() {
		return product;
	}
	
	@WeaFunction(fname="获取产品详情(移动端)",oname=WeaFunction.Operation.READ)
	@Action(value="mGetProductInfo")
	public String getProductInfo() throws IOException {
		String prodNum = getRequestParamValue("prodNum");
		Product product = imProductService.getProduct(prodNum);
		weaResponse.setRespData(product);
		return JSONRESPONSE;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProdPrice getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(ProdPrice prodPrice) {
		this.prodPrice = prodPrice;
	}

	public ProdSearch getProdSearch() {
		return prodSearch;
	}

	public void setProdSearch(ProdSearch prodSearch) {
		this.prodSearch = prodSearch;
	}


}
