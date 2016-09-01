package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.OrigOrder;
import com.etaoguan.wea.vo.OrigOrderItem;

public interface IOrigOrderService {
	
	public OrigOrder addOrigOrder(OrigOrder origOrder);
	
	public void delOrigOrder(String origOrderNum);
	
	public List<OrigOrderItem> getOrigOrderItems(String origOrderNum);
	
	@SuppressWarnings("rawtypes")
	public DataSet listOrigOrders(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public OrigOrder getOrigOrder(String origOrderNum);
	
	public void saveOrigOrderItem(OrigOrderItem origOrderItem);
	
	public void updateReCalcOrigOrderPriceTotal(String origOrderNum);
	
	/**
	 * @param ownernum
	 * @return 未审核订单列表(移动端)
	 */
	@SuppressWarnings("rawtypes")
	public DataSet GetOrigOrders(DataCriteria dataCriteria,OffsetRequest offsetRequest);
}
