package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IOrigOrderDao;
import com.etaoguan.wea.vo.OrigOrder;
import com.etaoguan.wea.vo.OrigOrderItem;
import com.ibatis.sqlmap.client.SqlMapClient;
@Repository
public class OrigOrderDao extends SpringBaseDao implements IOrigOrderDao {

	@Override
	@Resource(name="orderSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addOrigOrder(OrigOrder origOrder) {
		this.getSqlMapClientTemplate().insert("createOrigOrder", origOrder);

	}

	@Override
	public void addOrigOrderItem(OrigOrderItem origOrderItem) {
		this.getSqlMapClientTemplate().insert("createOrigOrderItem", origOrderItem);

	}

	@Override
	public void delOrigOrder(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteOrigOrder", dataCriteria.getParams());

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrigOrderItem> getOrigOrderItems(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getOrigOrderItemList", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet getOrigOrders(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getOrigOrderCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<OrigOrder> custList = this.getSqlMapClientTemplate().queryForList("getOrigOrderDatSet", params);
		
		DataSet<OrigOrder> dataSet = new DataSet<OrigOrder>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(custList);
		return dataSet;
	}

	@Override
	public void reCalcOrigOrderPriceTotal(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("reCalcOrigOrderPriceTotal", dataCriteria.getParams());
		
	}

	@Override
	public OrigOrder getOrigOrder(DataCriteria dataCriteria) {
		return (OrigOrder)this.getSqlMapClientTemplate().queryForObject("getOrigOrder", dataCriteria.getParams());
		
	}

	@Override
	public void updateOrigOrderItemUnitPrice(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateOrigOrderItemUnitPrice", dataCriteria.getParams());
		
	}
	/* (non-Javadoc)未审核订单列表(移动端)
	 * @see com.etaoguan.wea.dao.IOrigOrderDao#getUnauditedOrders()
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getUnauditedOrders(DataCriteria dataCriteria,OffsetRequest offsetRequest) {     
		Map params = dataCriteria.getParams();
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getUnauditedOrderCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<OrigOrder> origList = this.getSqlMapClientTemplate().queryForList("getUnauditedOrders", params);
		
		DataSet<OrigOrder> dataSet = new DataSet<OrigOrder>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(origList);
		return dataSet;
	}

}
