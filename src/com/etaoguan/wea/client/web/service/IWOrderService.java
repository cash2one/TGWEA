package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.OrderSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IOrderService;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.OrderItem;

public interface IWOrderService extends IOrderService{
	
	@SuppressWarnings("rawtypes")
	public WPage listOrders(OrderSearch orderSearch, SortParam sortParam,
			WPagingRequest wpagingRequest);
	
	public void delOrderItem(OrderItem orderItem);
	
	public void updateOrderItem(OrderItem orderItem);
	
	@SuppressWarnings("rawtypes")
	public Map getListOrdersSearchInitData(String ownerNum);
	
	public void addWebOrder(Order order);
}
