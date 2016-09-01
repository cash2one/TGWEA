package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IStkAllocInvDao;
import com.etaoguan.wea.vo.StockAllocateInvoice;
import com.etaoguan.wea.vo.StockAllocateInvoiceItem;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class StkAllocInvDao extends SpringBaseDao implements IStkAllocInvDao{

	@Override
	@Resource(name="prodStockSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	
	@Override
	public void addStkAllocInv(StockAllocateInvoice stkAllocInv) {
		this.getSqlMapClientTemplate().insert("createStkAllocInv", stkAllocInv);
		
	}

	@Override
	public void addStkAllocInvItem(StockAllocateInvoiceItem stkAllocInvItem) {
		this.getSqlMapClientTemplate().insert("createStkAllocItem", stkAllocInvItem);
		
	}

	@Override
	public void delStkAllocInv(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteStkAllocInv", dataCriteria.getParams());
		
	}

	@Override
	public StockAllocateInvoice getStkAllocInv(DataCriteria dataCriteria) {
		return (StockAllocateInvoice)this.getSqlMapClientTemplate().queryForObject("getStkAllocInv", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StockAllocateInvoiceItem> getStkAllocInvItems(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getStkAllocInvItemList", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getStkAllocInvs(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getStkAllocInvCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<StockAllocateInvoice> stkAllocInvList = this.getSqlMapClientTemplate().queryForList("getStkAllocInvDatSet", params);
		
		DataSet<StockAllocateInvoice> dataSet = new DataSet<StockAllocateInvoice>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(stkAllocInvList);
		return dataSet;
	}


	@Override
	public void updateStkAllocInv(StockAllocateInvoice stkAllocInv) {
		this.getSqlMapClientTemplate().update("updateStkAllocInv", stkAllocInv);
		
	}


	@Override
	public void updateStkAllocInv(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateStkAllocInvByMap", dataCriteria.getParams());
		
	}


	@Override
	public void delStkAllocInvItem(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteStkAllocInvItem", dataCriteria.getParams());
		
	}

}
