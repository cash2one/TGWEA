package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.OrderItem;
import com.etaoguan.wea.vo.ProdQty;

public interface IOrderDao {
	
	@SuppressWarnings("rawtypes")
	public DataSet getOrders(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	@SuppressWarnings("rawtypes")
	public DataSet getOrdersWithItem(DataCriteria dataCriteria,
			OffsetRequest offsetRequest);

	public void updateOrder(DataCriteria dataCriteria);
	
	public void sumOrderItemPriceTotal(DataCriteria dataCriteria);
	
	public void addOrderItem(OrderItem orderItem);
	
	public void updateOrderItem(DataCriteria dataCriteria);	
	
	public List<ProdQty> minusDeliverInvNRetInv(DataCriteria dataCriteria);
	
	public void updateOrderItemPriceTotal(DataCriteria dataCriteria);
	
	public Order getOrder(DataCriteria dataCriteria);
	
	public int getOrderCount(DataCriteria dataCriteria);
	
	public int getItemCount(DataCriteria dataCriteria);
	
	public OrderItem getOrderItem(DataCriteria dataCriteria);
	
	public List<OrderItem> getOrderItems(DataCriteria dataCriteria);
	
	public void addOrder(Order order);
	
	public void delOrder(DataCriteria dataCriteria);
	
	public void delOrderItem(DataCriteria dataCriteria);
	
	public void reCalcOrderPriceTotal(DataCriteria dataCriteria);
	
	public void updateOrderItemUnitPrice(DataCriteria dataCriteria);

}
