package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWSettleInvService;
import com.etaoguan.wea.client.web.vo.SettleInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;

@SuppressWarnings("serial")
@WeaModule(mname="结算单管理")
@Service("ownerWSettleInvAction") @Scope("prototype")
public class WSettleInvAction extends WOwnerBaseAction{

	@Resource(name="wsettleInvService")
	private IWSettleInvService iWSettleInvService;
	
	private SettleInvSearch settleInvSearch = new SettleInvSearch();
	
	@WeaFunction(fname="查看结算单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListSettleInvs",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_settleinvs.jsp")})
	public String listSettleInvs() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看结算单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListSettleInvsData")
	public String listSettleInvsData() throws IOException {
		settleInvSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWSettleInvService.listSettleInvs(settleInvSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="查看结算单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wviewSettleInv",results = { @Result(name = "success", type = "dispatcher",location="/owner/view_settleinv.jsp")})
	public String viewSettleInv() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="查看结算单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wgetSettleInvData")
	public String getSettleInvData() throws IOException {
		String orderNum = getRequestParamValue("orderNum");
		weaResponse.setRespData(iWSettleInvService.getSettleInv(orderNum));
		return JSONRESPONSE;
	}

	@WeaFunction(fname="确认结算订单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wconfirmOrderSettlement")
	public String confirmOrderSettlement() throws IOException {
		String orderNum = getRequestParamValue("orderNum");
		iWSettleInvService.updateConfirmOrderSettlement(orderNum);
		return JSONRESPONSE;
	}

	public SettleInvSearch getSettleInvSearch() {
		return settleInvSearch;
	}

	public void setSettleInvSearch(SettleInvSearch settleInvSearch) {
		this.settleInvSearch = settleInvSearch;
	}


}
