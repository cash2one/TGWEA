package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IReturnedInvDao;
import com.etaoguan.wea.vo.ReturnedInvoice;
import com.etaoguan.wea.vo.ReturnedInvoiceItem;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ReturnedInvDao extends SpringBaseDao implements IReturnedInvDao{

	@Override
	@Resource(name="returnedInvSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addReturnedInv(ReturnedInvoice retInv) {
		this.getSqlMapClientTemplate().insert("createReturnedInv", retInv);
		
	}

	@Override
	public void delReturnedInv(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteReturnedInv", dataCriteria.getParams());
		
	}

	@Override
	public ReturnedInvoice getReturnedInv(DataCriteria dataCriteria) {

		return (ReturnedInvoice)this.getSqlMapClientTemplate().queryForObject("getReturnedInv", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet getReturnedInvs(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getReturnedInvCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<ReturnedInvoice> retInvList = this.getSqlMapClientTemplate().queryForList("getReturnedInvDataSet", params);
		
		DataSet<ReturnedInvoice> dataSet = new DataSet<ReturnedInvoice>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(retInvList);
		return dataSet;
	}

	@Override
	public void updateReturnedInv(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateReturnedInvByMap", dataCriteria.getParams());
		
	}
	@Override
	public void updateReturnedInv(ReturnedInvoice returnedInv) {
		this.getSqlMapClientTemplate().update("updateReturnedInv", returnedInv);
		
	}
	@Override
	public void addReturnedInvItem(ReturnedInvoiceItem retInvItem) {
		this.getSqlMapClientTemplate().insert("createReturnedInvItem", retInvItem);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ReturnedInvoiceItem> getReturnedInvItems(
			DataCriteria dataCriteria) {

		return this.getSqlMapClientTemplate().queryForList("getRetItems", dataCriteria.getParams());
	}

	@Override
	public void updateReturnedInvItem(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateReturnedInvItemByMap", dataCriteria.getParams());
		
	}

	@Override
	public void updateReturnedInvItem(ReturnedInvoiceItem retInvItem) {
		this.getSqlMapClientTemplate().update("updateReturnedInvItem",retInvItem);
		
	}

	@Override
	public void delReturnedInvItem(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteReturnedInvItem", dataCriteria.getParams());
		
	}

}
