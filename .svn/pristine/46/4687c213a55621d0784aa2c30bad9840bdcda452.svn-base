package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.OrderItem;
import com.etaoguan.wea.vo.ProdQty;

public interface IOrderService {
	
	@SuppressWarnings("rawtypes")
	public DataSet listOrders(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	@SuppressWarnings("rawtypes")
	public DataSet getOrdersWithItem(DataCriteria dataCriteria,
			OffsetRequest offsetRequest);
	
	public void updateReCalcOrderPriceTotal(String orderNum);
	
	public void updateOrderRealPrice(String orderNum,double realPrice,String deliverAddr);
	
	public void updateSumOrderItemPriceTotal(String orderNum);
	
	public void updateOrder2DeliverUnPuton(String orderNum);
	
	public void updateOrder2DeliverPuton(String orderNum,String whNum);
	
	public void updateOrder2Undelivered(String orderNum);
	
	public void updateOrder2Cashed(String orderNum,int cashType);
	
	public void updateOrder2Uncashed(String orderNum);
	
	public void updateOrder2Settled(String orderNum);
	
	public void addOrderItem(OrderItem orderItem);
	
	public void updateOrderItemProdQty(String orderNum,ProdQty prodQty);
	
	public void updateAllOrderItems(String orderNum,List<OrderItem> orderItemList);
	
	public boolean chkLegalRetInv(String orderNum,List<ProdQty> unsavedRetInvoiceProdQty);
	
	public void saveOrderItems4ReturnedInv(String orderNum);
	
	public void updateOrderItemPriceTotal(String orderNum);
	
	public boolean haveDelivered(String orderNum);
	
	public boolean haveCashed(String orderNum);
	
	public boolean haveSettled(String orderNum);
	
	public double getOrderRealPrice(String orderNum);
	
	public double getOrderStdPrice(String orderNum);
	
	public int getOrderCountByCustNum(String custNum);
	
	public int getDeliverOrderCountByCustNum(String custNum,int deliverStatus);
	
	public int getCashOrderCountByCustNum(String custNum,int cashStatus);
	
	public int getSettleOrderCountByCustNum(String custNum,int settleStatus);
	
	public int getOrderCountByWHNum(String whNum,String ownerNum);
	
	public boolean existsProduct(String prodNum);
	
	public List<OrderItem> getOrderItems(String orderNum);
	
	public OrderItem getOrderItem(String orderNum, String prodNum);
	
	public Order getOrder(String orderNum);
	
	public Order addOrder(Order order);
	
	public void delOrder(String orderNum);
	
	public void delOrderItems(String orderNum);
	
	public void delInvalidOrderItems(String orderNum);
	
	public void delOrderItem(String orderNum,String prodNum);
	
	public boolean existsOrder(String orderNum);
	
	public boolean existsCust(String custNum);
	
	public boolean existsReferOrder(String origOrderNum);
	
	public Order saveGenOrderFromOrigOrder(String origOrderNum);

}
