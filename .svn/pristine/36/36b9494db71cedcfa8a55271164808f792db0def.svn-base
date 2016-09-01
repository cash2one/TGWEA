package com.etaoguan.wea.client.mobile.service;

import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.MPagingRequest;
import com.etaoguan.wea.client.mobile.vo.OrigOrderSearch;
import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.service.IOrigOrderService;
import com.etaoguan.wea.vo.Customer;

public interface IMOrigOrderService extends IOrigOrderService{
	
	public void addOrigOrder(String jsonOrigOrderItems,Customer cust,String ownerNum,String deliverAddr);
	/**
	 * @return 未审核订单列表(移动端)
	 */
	@SuppressWarnings("rawtypes")
	public MPage getMOrigOrderList(OrigOrderSearch origOrderSearch,SortParam sortParam,MPagingRequest mpagingRequest);
}
