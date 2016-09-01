package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.ReturnedInvoice;
import com.etaoguan.wea.vo.ReturnedInvoiceItem;

public interface IReturnedInvService {
	
	@SuppressWarnings("rawtypes")
	public DataSet listReturnedInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addReturnedInv(ReturnedInvoice returnedInv);
	
	public void updateReturnedInv(ReturnedInvoice returnedInv);
	
	public void delReturnedInv(String retInvNum);
	
	public void saveReturnedInvStockChange(String retInvNum,String whNum);
	
	public boolean havePutin2WH(String retInvNum);
	
	public void updateReturnedInv2Putin(String retInvNum);
	
	public void updateReturnedInvRetType(String retInvNum,int retType);
	
	public void updateReturnedInvRetReason(String retInvNum,String retReason);
	
	public void updateReturnedInvItem(ReturnedInvoiceItem retInvItem);
	
	public List<ReturnedInvoiceItem> getReturnedInvItems(String retInvNum);
	
	public ReturnedInvoice getReturnedInv(String retInvNum);
	
	public ReturnedInvoice getReturnedInvByOrderNum(String referOrderNum);
	
	public ReturnedInvoice getReturnedInvHeader(String retInvNum);

}
