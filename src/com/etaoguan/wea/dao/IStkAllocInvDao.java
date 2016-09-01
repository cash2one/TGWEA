package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.StockAllocateInvoice;
import com.etaoguan.wea.vo.StockAllocateInvoiceItem;
public interface IStkAllocInvDao {
	
	public void addStkAllocInv(StockAllocateInvoice stkAllocInv);
	
	public void addStkAllocInvItem(StockAllocateInvoiceItem stkAllocInvItem);
	
	public void delStkAllocInv(DataCriteria dataCriteria);
	
	public void delStkAllocInvItem(DataCriteria dataCriteria);
	
	public List<StockAllocateInvoiceItem> getStkAllocInvItems(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getStkAllocInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public StockAllocateInvoice getStkAllocInv(DataCriteria dataCriteria);
	
	public void updateStkAllocInv(StockAllocateInvoice stkAllocInv);
	
	public void updateStkAllocInv(DataCriteria dataCriteria);


}
