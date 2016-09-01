package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWSpecialProdCustRefService;
import com.etaoguan.wea.client.web.vo.SpecialProdCustRefSearch;
import com.etaoguan.wea.client.web.vo.WPage;

@WeaModule(mname="特供产品")
@Service("wspecialProdCustRefAction") @Scope("prototype")
public class WSpecialProdCustRefAction extends WOwnerBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	
	@Resource(name="wspecialProdCustRefService")
	private IWSpecialProdCustRefService iwSpecialProdCustRefService;
	
	
	private SpecialProdCustRefSearch specialProdCustRefSearch = new SpecialProdCustRefSearch();

	public SpecialProdCustRefSearch getSpecialProdCustRefSearch() {
		return specialProdCustRefSearch;
	}

	public void setSpecialProdCustRefSearch(
			SpecialProdCustRefSearch specialProdCustRefSearch) {
		this.specialProdCustRefSearch = specialProdCustRefSearch;
	}

	@SuppressWarnings("rawtypes")
	@WeaFunction(fname = "查看产品定位列表", oname = WeaFunction.Operation.READ)
	@Action(value = "wListProdGpsData")
	public String listProdGpsData() throws IOException {
		
		specialProdCustRefSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		
		WPage wpage = iwSpecialProdCustRefService.specialprods(specialProdCustRefSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		
		return JSONRESPONSE;
	}

	

}
