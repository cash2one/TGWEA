package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.CashInvoice;
import com.etaoguan.wea.vo.CashInvoiceItem;

public interface ICashInvDao {
	
	public void addCashInv(CashInvoice cashInv);
	
	public void addCashInvItem(CashInvoiceItem cashInvItem);
	
	public void updateCashInv(CashInvoice cashInv);
	
	public void updateCashInv(DataCriteria dataCriteria);
	
	public void delCashInv(DataCriteria dataCriteria);
	
	public void delCashInvItem(DataCriteria dataCriteria);
	
	public int getCashInvCount(DataCriteria dataCriteria);
	
	public CashInvoice getCashInv(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getCashInvDataSet(DataCriteria dataCriteria,OffsetRequest offsetRequest);

	public List<CashInvoiceItem> getCashInvItems(DataCriteria dataCriteria);
	
	public void reCalcCashPriceTotal(DataCriteria dataCriteria);
}
