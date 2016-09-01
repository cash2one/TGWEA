package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWOrderService;
import com.etaoguan.wea.client.web.vo.OrderSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.OrderItem;

@SuppressWarnings("serial")
@WeaModule(mname="订单管理")
@Service("ownerWOrderAction") @Scope("prototype")
public class WOrderAction extends WOwnerBaseAction{

	private OrderSearch orderSearch = new OrderSearch();
	
	private OrderItem orderItem;
	
	private Order order;

	@Resource(name="worderService")
	private IWOrderService iwOrderService;
	
	@WeaFunction(fname="查看订单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListOrders",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_orders.jsp")})
	public String listOrders() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看订单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListOrdersData")
	public String listOrdersData() throws IOException {
		orderSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwOrderService.listOrders(orderSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取订单列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListOrdersSearchInitData")
	public String getListOrdersSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listOrdersData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iwOrderService.getListOrdersSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="查看订单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wListOrderItemsData")
	public String listOrderItemsData() throws IOException {
		
		String orderNum = getRequestParamValue("orderNum");
		List<OrderItem> orderItemList = iwOrderService.getOrderItems(orderNum);
		weaResponse.setRespData(orderItemList);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="删除订单",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelOrder")
	public String delOrder() throws IOException {
		String orderNum = getRequestParamValue("orderNum");
		iwOrderService.delOrder(orderNum);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="删除订单明细",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelOrderItem")
	public String delOrderItem() throws IOException {
		iwOrderService.delOrderItem(orderItem);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="更新订单明细",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUpdateOrderItem")
	public String updateOrderItem() throws IOException {
		iwOrderService.updateOrderItem(orderItem);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="更新订单真实价格",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUpdateOrderRealPriceTotal")
	public String updateOrderRealPriceTotal() throws IOException {
		iwOrderService.updateOrderRealPrice(order.getOrderNum(), order.getRealPriceTotal(), order.getDeliverAddr());
		return JSONRESPONSE;
	}

	@WeaFunction(fname="添加订单",oname=WeaFunction.Operation.CREATE)
	@Action(value="wAddOrder",results = { @Result(name = "success", type = "dispatcher",location="/owner/add_order.jsp")})
	public String addOrder() throws IOException {

		return SUCCESS;
	}
	
	@WeaFunction(fname="添加订单",oname=WeaFunction.Operation.CREATE)
	@Action(value="wSaveAddOrder")
	public String saveAddOrder() throws IOException {
		order.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwOrderService.addWebOrder(order);
		return JSONRESPONSE;
	}
	public OrderSearch getOrderSearch() {
		return orderSearch;
	}

	public void setOrderSearch(OrderSearch orderSearch) {
		this.orderSearch = orderSearch;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	



}
