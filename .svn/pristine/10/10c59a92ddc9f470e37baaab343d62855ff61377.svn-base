package com.etaoguan.wea.client.mobile.action.cust;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMOrderService;
import com.etaoguan.wea.client.mobile.service.IMOrigOrderService;
import com.etaoguan.wea.client.mobile.vo.MOrder;
import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.OrderSearch;
import com.etaoguan.wea.client.mobile.vo.OrigOrderSearch;

@WeaModule(mname="订单管理")
@Service("custMOrderAction") @Scope("prototype")
public class MOrderAction extends MOwnerBaseAction{

	private static final long serialVersionUID = 854960251297615394L;
	
	private OrderSearch orderSearch = new OrderSearch();
	private OrigOrderSearch origOrderSearch = new OrigOrderSearch();
	
	@Resource(name="morigOrderService")
	private IMOrigOrderService imOrigOrderService;
	
	@Resource(name="morderService")
	private IMOrderService imOrderService;
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="未审核订单列表(移动端)",oname=WeaFunction.Operation.READ)
	@Action(value="mUnauditedOrders")
	public String getUnauditedOrders() throws Exception {

		origOrderSearch.setOwnerNum(ownerNum);
		origOrderSearch.setCustNum(getCurrentCust().getCustNum());
		MPage mOrigpage = imOrigOrderService.getMOrigOrderList(origOrderSearch, sortParam, mpagingRequest);
		weaResponse.setRespData(mOrigpage);

		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="添加原始订单(移动端)",oname=WeaFunction.Operation.CREATE)
	@Action(value="mAddOrigOrder")
	public String addOrigOrder() throws Exception {
			String jsonOrigOrderItems = getRequestParamValue("prodQtys");
			String deliverAddr = getRequestParamValue("deliverAddr");
			imOrigOrderService.addOrigOrder(jsonOrigOrderItems, getCurrentCust(), ownerNum,deliverAddr);
		
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看订单列表(移动端)",oname=WeaFunction.Operation.READ)
	@Action(value="mListOrders")
	public String listOrders() throws Exception {
			orderSearch.setOwnerNum(ownerNum);
			orderSearch.setCustNum(getCurrentCust().getCustNum());
			MPage mpage = imOrderService.listOrders(orderSearch, sortParam, mpagingRequest);
			weaResponse.setRespData(mpage);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="获取订单详情(移动端)",oname=WeaFunction.Operation.READ)
	@Action(value="mGetOrderInfo")
	public String getOrderInfo() throws Exception {
			String orderNum = getRequestParamValue("orderNum");
			MOrder morder = imOrderService.getMOrder(orderNum);
			weaResponse.setRespData(morder);
		
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="生成订单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="mGenOrder")
	public String genOrder() throws IOException {
		String origOrderNum = getRequestParamValue("origOrderNum");
		imOrderService.saveGenOrderFromOrigOrder(origOrderNum);
		return JSONRESPONSE;
	}
	
	public OrderSearch getOrderSearch() {
		return orderSearch;
	}

	public void setOrderSearch(OrderSearch orderSearch) {
		this.orderSearch = orderSearch;
	}

	public OrigOrderSearch getOrigOrderSearch() {
		return origOrderSearch;
	}

	public void setOrigOrderSearch(OrigOrderSearch origOrderSearch) {
		this.origOrderSearch = origOrderSearch;
	}

}
