package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.CashInvoice;
import com.etaoguan.wea.vo.CashInvoiceItem;

public interface ICashInvService {
	
	public void addCashInv(CashInvoice cashInv);
	
	public void updateCashInv(CashInvoice cashInv);
	
	public void updateCashInvCashType(String cashNum,int cashType);
	
	public void delCashInv(String cashNum);
	
	public CashInvoice getCashInv(String cashNum);
	
	public CashInvoice getCashInvByOrderNum(String referOrderNum);
	
	public CashInvoice getCashInvHeader(String cashNum);
	
	public List<CashInvoiceItem> getCashInvItems(String cashNum);
	
	public boolean existsCashInv(String orderNum);
	
	@SuppressWarnings("rawtypes")
	public DataSet listCashInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);

}
