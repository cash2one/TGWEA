package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.GodownInvoice;
import com.etaoguan.wea.vo.GodownInvoiceItem;

public interface IGodownInvService {

	public void addGodownInv(GodownInvoice godownInvoice);
	
	public void saveGodownInvoiceItem(GodownInvoiceItem godownInvoiceItem);
	
	public void delGodownInv(String gdNum);
	
	public List<GodownInvoiceItem> getGodownInvItems(String gdNum);
	
	@SuppressWarnings("rawtypes")
	public DataSet listGodownInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public GodownInvoice getGodownInv(String gdNum);
	
	public void updateGodownInv(GodownInvoice godownInvoice);
	
	public boolean havePutin2WH(String gdNum);
	
	public void updateGodownInv2Putin(String gdNum);
	
	public void saveGodownInvStockChange(String gdNum);
	
	public GodownInvoice getGodownInvHeader(String gdNum);
}
