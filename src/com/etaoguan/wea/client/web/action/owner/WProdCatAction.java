package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWProdCatService;
import com.etaoguan.wea.vo.ProdCat;



@SuppressWarnings("serial")
@WeaModule(mname="产品类别管理")
@Service("ownerWProdCatAction") @Scope("prototype")
public class WProdCatAction extends WOwnerBaseAction{

	private ProdCat prodCat;
	
	private String[] prodCatIds;

	@Resource(name="wprodCatService")
	private IWProdCatService iwProdCatService;

	@WeaFunction(fname="查看产品类别列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListProdCats",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_prodcats.jsp")})
	public String listProdCats() throws IOException {

		return SUCCESS;
	}
	
	@WeaFunction(fname="查看产品类别列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListProdCatsData")
	public String listProdCatsData() throws IOException {
		List<ProdCat> prodCats = iwProdCatService.getProdCatsIncRootByOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(prodCats);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="批量删除产品类别",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelBatchProdCat")
	public String delBatchProdCat() throws IOException {
		iwProdCatService.delBatchProdCat(getCurrentOwnerAdmin().getOwnerNum(), prodCatIds);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="更新产品类别",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveProdCat")
	public String saveProdCat() throws IOException {
		prodCat.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwProdCatService.saveOrUpdateProdCat(prodCat);
		return JSONRESPONSE;
	}

	public ProdCat getProdCat() {
		return prodCat;
	}

	public void setProdCat(ProdCat prodCat) {
		this.prodCat = prodCat;
	}

	public String[] getProdCatIds() {
		return prodCatIds;
	}

	public void setProdCatIds(String[] prodCatIds) {
		this.prodCatIds = prodCatIds;
	}

	


}
