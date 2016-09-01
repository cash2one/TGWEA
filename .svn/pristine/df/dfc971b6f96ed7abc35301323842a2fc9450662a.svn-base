package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.GodownInvoice;
import com.etaoguan.wea.vo.GodownInvoiceItem;
public interface IGodownInvDao {
	
	public void addGodownInv(GodownInvoice godownInvoice);
	
	public void addGodownInvItem(GodownInvoiceItem godownInvoiceItem);
	
	public void delGodownInv(DataCriteria dataCriteria);
	
	public void delGodownInvItem(DataCriteria dataCriteria);
	
	public List<GodownInvoiceItem> getGodownInvItems(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getGodownInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public GodownInvoice getGodownInv(DataCriteria dataCriteria);
	
	public void updateGodownInv(GodownInvoice godownInvoice);
	
	public void updateGodownInv(DataCriteria dataCriteria);


}
