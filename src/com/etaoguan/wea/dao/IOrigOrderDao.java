package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.OrigOrder;
import com.etaoguan.wea.vo.OrigOrderItem;

public interface IOrigOrderDao {
	
	public void addOrigOrder(OrigOrder origOrder);
	
	public void addOrigOrderItem(OrigOrderItem origOrderItem);
	
	public void delOrigOrder(DataCriteria dataCriteria);
	
	public List<OrigOrderItem> getOrigOrderItems(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getOrigOrders(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void reCalcOrigOrderPriceTotal(DataCriteria dataCriteria);
	
	public OrigOrder getOrigOrder(DataCriteria dataCriteria);
	
	public void updateOrigOrderItemUnitPrice(DataCriteria dataCriteria);
	/**
	 * @return 未审核订单列表(移动端)
	 */
	@SuppressWarnings("rawtypes")
	public DataSet getUnauditedOrders(DataCriteria dataCriteria,OffsetRequest offsetRequest);
}
