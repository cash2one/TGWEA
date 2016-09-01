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
import com.etaoguan.wea.client.web.service.IWOrderService;
import com.etaoguan.wea.client.web.service.IWOrigOrderService;
import com.etaoguan.wea.client.web.vo.OrigOrderSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.OrigOrderItem;

@SuppressWarnings("serial")
@WeaModule(mname="原始订单管理")
@Service("ownerWOrigOrderAction") @Scope("prototype")
public class WOrigOrderAction extends WOwnerBaseAction{

	private OrigOrderSearch origOrderSearch = new OrigOrderSearch();
	
	@Resource(name="worigOrderService")
	private IWOrigOrderService iwOrigOrderService;
	
	@Resource(name="worderService")
	private IWOrderService iwOrderService;
	
	@WeaFunction(fname="查看原始订单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListOrigOrders",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_orig_orders.jsp")})
	public String listOrigOrders() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看原始订单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListOrigOrdersData")
	public String listOrigOrdersData() throws IOException {
		origOrderSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwOrigOrderService.listOrigOrders(origOrderSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="查看原始订单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wListOrigOrderItemsData")
	public String listOrigOrderItemsData() throws IOException {
		
		String origOrderNum = getRequestParamValue("origOrderNum");
		List<OrigOrderItem> origOrderItemList = iwOrigOrderService.getOrigOrderItems(origOrderNum);
		weaResponse.setRespData(origOrderItemList);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="删除原始订单",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelOrigOrder")
	public String delOrigOrder() throws IOException {
		String origOrderNum = getRequestParamValue("origOrderNum");
		iwOrigOrderService.delOrigOrder(origOrderNum);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="生成订单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wGenOrder")
	public String genOrder() throws IOException {
		String origOrderNum = getRequestParamValue("origOrderNum");
		iwOrderService.saveGenOrderFromOrigOrder(origOrderNum);
		return JSONRESPONSE;
	}

	public OrigOrderSearch getOrigOrderSearch() {
		return origOrderSearch;
	}


	public void setOrigOrderSearch(OrigOrderSearch origOrderSearch) {
		this.origOrderSearch = origOrderSearch;
	}



}
