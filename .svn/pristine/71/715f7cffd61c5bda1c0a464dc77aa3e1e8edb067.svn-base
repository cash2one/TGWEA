package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.ReturnedInvoice;
import com.etaoguan.wea.vo.ReturnedInvoiceItem;

public interface IReturnedInvDao {
	
	@SuppressWarnings("rawtypes")
	public DataSet getReturnedInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public List<ReturnedInvoiceItem> getReturnedInvItems(DataCriteria dataCriteria);
	
	public void updateReturnedInv(ReturnedInvoice returnedInv);
	
	public void addReturnedInv(ReturnedInvoice retInv);
	
	public void addReturnedInvItem(ReturnedInvoiceItem retInvItem);
	
	public void updateReturnedInvItem(DataCriteria dataCriteria);
	
	public void updateReturnedInvItem(ReturnedInvoiceItem retInvItem);
	
	public void delReturnedInv(DataCriteria dataCriteria);
	
	public void delReturnedInvItem(DataCriteria dataCriteria);
	
	public ReturnedInvoice getReturnedInv(DataCriteria dataCriteria);
	
	public void updateReturnedInv(DataCriteria dataCriteria);

}
