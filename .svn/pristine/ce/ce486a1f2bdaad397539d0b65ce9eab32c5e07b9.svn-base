package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IGodownInvDao;
import com.etaoguan.wea.vo.GodownInvoice;
import com.etaoguan.wea.vo.GodownInvoiceItem;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class GodownInvDao extends SpringBaseDao implements IGodownInvDao{

	@Override
	@Resource(name="prodStockSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	
	@Override
	public void addGodownInv(GodownInvoice goDownInvoice) {
		this.getSqlMapClientTemplate().insert("createGodownInv", goDownInvoice);
		
	}

	@Override
	public void addGodownInvItem(GodownInvoiceItem goDownInvoiceItem) {
		this.getSqlMapClientTemplate().insert("createGodownItem", goDownInvoiceItem);
		
	}

	@Override
	public void delGodownInv(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteGodownInv", dataCriteria.getParams());
		
	}

	@Override
	public GodownInvoice getGodownInv(DataCriteria dataCriteria) {
		return (GodownInvoice)this.getSqlMapClientTemplate().queryForObject("getGodownInv", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<GodownInvoiceItem> getGodownInvItems(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getGodownInvItemList", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getGodownInvs(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getGodownInvCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<GodownInvoice> goDownInvList = this.getSqlMapClientTemplate().queryForList("getGodownInvDatSet", params);
		
		DataSet<GodownInvoice> dataSet = new DataSet<GodownInvoice>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(goDownInvList);
		return dataSet;
	}


	@Override
	public void updateGodownInv(GodownInvoice godownInvoice) {
		this.getSqlMapClientTemplate().update("updateGodownInv", godownInvoice);
		
	}


	@Override
	public void updateGodownInv(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateGodownInvByMap", dataCriteria.getParams());
		
	}


	@Override
	public void delGodownInvItem(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteGodownInvItem", dataCriteria.getParams());
		
	}

}
