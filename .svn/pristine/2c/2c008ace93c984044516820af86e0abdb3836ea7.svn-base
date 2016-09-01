package com.etaoguan.wea.client.mobile.action.owner;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMCustService;
import com.etaoguan.wea.client.mobile.vo.CustSearch;
import com.etaoguan.wea.client.mobile.vo.MPage;

@WeaModule(mname="客户管理")
@Service("ownerMCustAction") @Scope("prototype")
public class MCustAction extends MOwnerBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	@Resource(name="mcustService")
	private IMCustService imCustService;
	

	private CustSearch custSearch = new CustSearch();
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看客户列表(移动端)",oname=WeaFunction.Operation.READ)
	@Action(value="mListCusts")
	public String listCusts() throws IOException {
		custSearch.setOwnerNum(ownerNum);
		MPage mpage = imCustService.listCusts(custSearch, sortParam, mpagingRequest);
		weaResponse.setRespData(mpage);
		return JSONRESPONSE;
	}
	
	public CustSearch getCustSearch() {
		return custSearch;
	}

	public void setCustSearch(CustSearch custSearch) {
		this.custSearch = custSearch;
	}
	

}
