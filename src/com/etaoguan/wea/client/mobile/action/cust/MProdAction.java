package com.etaoguan.wea.client.mobile.action.cust;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMProdCatService;
import com.etaoguan.wea.client.mobile.service.IMProductService;
import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.ProdSearch;
import com.etaoguan.wea.client.web.service.IWProductGpsService;
import com.etaoguan.wea.client.web.service.IWProductService;
import com.etaoguan.wea.vo.Product;

@SuppressWarnings("serial")
@WeaModule(mname="产品管理")
@Service("custMProdAction") @Scope("prototype")
public class MProdAction extends MOwnerBaseAction {
	
	
	@Resource(name="mproductService")
	private IMProductService imProductService;
	
	@Resource(name="wproductService")
	private IWProductService iwProductService;
	
	@Resource(name="mprodCatService")
	private IMProdCatService imProdCatService;
	
	private Product product;
	
	private ProdSearch prodSearch = new ProdSearch();
	@Resource(name = "wproductGpsService")
	private IWProductGpsService iwProductGpsService;
	

	/** 特供产品 信息列表
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="特供产品 信息列表",oname=WeaFunction.Operation.READ)
	@Action(value="mGetProductsList")
	public String productsList(){
		String custNum = getCurrentCust().getCustNum();  
		prodSearch.setCustNum(custNum);
		MPage mpage = imProductService.listProductsbyid(prodSearch, sortParam, mpagingRequest);
		weaResponse.setRespData(mpage);
		
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@Action(value="mListProducts")
	public String listProducts() throws IOException {
		prodSearch.setOwnerNum(ownerNum);
		prodSearch.setIsPublic(0);
		MPage mpage = imProductService.listProducts(prodSearch, sortParam, mpagingRequest);
		weaResponse.setRespData(mpage);
		return JSONRESPONSE;
	}
	
	/*特供*/
	@Action(value="mListProdCats")
	public String listProdCats() throws IOException {
		weaResponse.setRespData(imProdCatService.getProdCatHier(ownerNum));
		return JSONRESPONSE;
	}
	
	@Action(value="mGetProductInfo")
	public String getProductInfo() throws IOException {
		
		System.out.println();
		String prodNum = getRequestParamValue("prodNum");
		System.out.println();
		String[] pn=prodNum.split(",");
		
		List<Product> products = new ArrayList<Product>();
		for (int i = pn.length-1; i >= 0; i--) {
			products.add(imProductService.getProduct(pn[i].trim()));
		}
		weaResponse.setRespData(products);
		return JSONRESPONSE;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProdSearch getProdSearch() {
		return prodSearch;
	}

	public void setProdSearch(ProdSearch prodSearch) {
		this.prodSearch = prodSearch;
	}


}
