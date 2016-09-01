package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IDeliverInvDao;
import com.etaoguan.wea.vo.DeliverInvoice;
import com.etaoguan.wea.vo.DeliverInvoiceItem;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class DeliverInvDao extends SpringBaseDao implements IDeliverInvDao {

	@Override
	@Resource(name="deliverInvSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	@Override
	public void addDeliverInv(DeliverInvoice deliverInv) {
		this.getSqlMapClientTemplate().insert("createDeliverInv", deliverInv);
		
	}

	@Override
	public void delDeliverInv(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteDeliverInv", dataCriteria.getParams());
		
	}

	@Override
	public DeliverInvoice getDeliverInv(DataCriteria dataCriteria) {

		return (DeliverInvoice)this.getSqlMapClientTemplate().queryForObject("getDeliverInv", dataCriteria.getParams());
	}

	@Override
	public int getDeliverInvCount(DataCriteria dataCriteria) {

		return (Integer)this.getSqlMapClientTemplate().queryForObject("getDeliverInvCount", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getDeliverInvs(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getDeliverInvCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<DeliverInvoice> deliverInvList = this.getSqlMapClientTemplate().queryForList("getDeliverInvDatSet", params);
		
		DataSet<DeliverInvoice> dataSet = new DataSet<DeliverInvoice>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(deliverInvList);
		return dataSet;
	}


	@Override
	public void updateDeliverInv(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateDeliverInvByMap", dataCriteria.getParams());
		
	}

	@Override
	public void addDeliverInvItem(DeliverInvoiceItem deliverInvItem) {
		this.getSqlMapClientTemplate().insert("createDeliverInvItem", deliverInvItem);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DeliverInvoiceItem> getDeliverInvItems(DataCriteria dataCriteria) {
		
		return this.getSqlMapClientTemplate().queryForList("getDeliverInvItems", dataCriteria.getParams());
		
	}
	
	

}
