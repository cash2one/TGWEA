package com.etaoguan.wea.client.mobile.service;

import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.MPagingRequest;
import com.etaoguan.wea.client.mobile.vo.MOrder;
import com.etaoguan.wea.client.mobile.vo.OrderSearch;
import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.service.IOrderService;

public interface IMOrderService extends IOrderService{

	@SuppressWarnings("rawtypes")
	public MPage listOrders(OrderSearch orderSearch,SortParam sortParam,MPagingRequest mpagingRequest);
	
	public MOrder getMOrder(String orderNum);
	
}
