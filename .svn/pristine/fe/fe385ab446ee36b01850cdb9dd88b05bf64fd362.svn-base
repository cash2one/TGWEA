package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IOrderDao;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.OrderItem;
import com.etaoguan.wea.vo.ProdQty;
import com.ibatis.sqlmap.client.SqlMapClient;
@Repository
public class OrderDao extends SpringBaseDao implements IOrderDao {

	@Override
	@Resource(name="orderSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addOrder(Order order) {
		this.getSqlMapClientTemplate().insert("createOrder", order);

	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
		this.getSqlMapClientTemplate().insert("createOrderItem", orderItem);

	}

	@Override
	public void delOrder(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteOrder", dataCriteria.getParams());

	}

	@Override
	public void delOrderItem(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteOrderItem", dataCriteria.getParams());

	}

	@Override
	public int getItemCount(DataCriteria dataCriteria) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("getOrderItemCount", dataCriteria.getParams());
	}

	@Override
	public Order getOrder(DataCriteria dataCriteria) {
		return (Order) this.getSqlMapClientTemplate().queryForObject("getOrder", dataCriteria.getParams());
	}

	@Override
	public int getOrderCount(DataCriteria dataCriteria) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("getOrderCount", dataCriteria.getParams());
	}

	@Override
	public OrderItem getOrderItem(DataCriteria dataCriteria) {
		return (OrderItem) this.getSqlMapClientTemplate().queryForObject("getOrderItem", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> getOrderItems(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getOrderItemList", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet getOrders(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getOrderCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<Order> custList = this.getSqlMapClientTemplate().queryForList("getOrderDatSet", params);
		
		DataSet<Order> dataSet = new DataSet<Order>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(custList);
		return dataSet;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet getOrdersWithItem(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getOrderWithItemCount", params);
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<Order> custList = this.getSqlMapClientTemplate().queryForList("getOrderrWithItemDatSet", params);
		
		DataSet<Order> dataSet = new DataSet<Order>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(custList);
		return dataSet;
	}



	@Override
	@SuppressWarnings("unchecked")
	public List<ProdQty> minusDeliverInvNRetInv(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("minusDeliverInvNRetInv", dataCriteria.getParams());
	}

	@Override
	public void updateOrder(DataCriteria dataCriteria) {

		this.getSqlMapClientTemplate().update("updateOrderByMap", dataCriteria.getParams());
	}

	@Override
	public void updateOrderItem(DataCriteria dataCriteria) {

		this.getSqlMapClientTemplate().update("updateOrderItemByMap", dataCriteria.getParams());
	}

	@Override
	public void updateOrderItemPriceTotal(DataCriteria dataCriteria) {

		this.getSqlMapClientTemplate().update("updateOrderItemPriceTotal", dataCriteria.getParams());
	}

	@Override
	public void sumOrderItemPriceTotal(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("sumOrderPriceTotal", dataCriteria.getParams());

	}

	@Override
	public void reCalcOrderPriceTotal(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("reCalcOrderPriceTotal", dataCriteria.getParams());
		
	}

	@Override
	public void updateOrderItemUnitPrice(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateOrderItemUnitPrice", dataCriteria.getParams());
		
	}

}
