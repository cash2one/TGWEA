package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.StockAllocateInvoice;
import com.etaoguan.wea.vo.StockAllocateInvoiceItem;

public interface IStkAllocInvService {

	public void addStkAllocInv(StockAllocateInvoice stkAllocInv);
	
	public void saveStkAllocInvoiceItem(StockAllocateInvoiceItem stkAllocInvItem);
	
	public void delStkAllocInv(String stkAllocNum);
	
	public List<StockAllocateInvoiceItem> getStkAllocInvItems(String stkAllocNum);
	
	@SuppressWarnings("rawtypes")
	public DataSet listStkAllocInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public StockAllocateInvoice getStkAllocInv(String stkAllocNum);
	
	public void updateStkAllocInv(StockAllocateInvoice stkAllocInv);
	
	public boolean havePutin2WH(String stkAllocNum);
	
	public void updateStkAllocInv2Putin(String stkAllocNum);
	
	public void saveStkAllocInvStockChange(String stkAllocNum);
}
