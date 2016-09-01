package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.DeliverInvlogistics;
import com.etaoguan.wea.vo.DeliverInvoice;
import com.etaoguan.wea.vo.DeliverInvoiceItem;
import com.etaoguan.wea.vo.ProdQty;

public interface IDeliverInvService {
	
	@SuppressWarnings("rawtypes")
	public DataSet listDeliverInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void updateDeliverInvlogistics(String deliverNum,DeliverInvlogistics deliverInvlogistics);
	
	public void saveDeliverInvStockChange(String deliverNum,String whNum);
	
	public void addGenDeliverInvByOrderNum(String orderNum);
	
	public void delDeliverInv(String deliverNum);
	
	public boolean havePutOn4WH(String deliverNum);
	
	public void updateDeliverInv2PutOn(String deliverNum);
	
	public boolean existsDeliverInv(String orderNum);
	
	public DeliverInvoice getDeliverInvByOrderNum(String referOrderNum);
	
	public DeliverInvoice getDeliverInvHeaderByOrderNum(String referOrderNum);
	
	public DeliverInvoice getDeliverInv(String deliverNum);
	
	public List<DeliverInvoiceItem> getDeliverInvItems(String deliverNum);
	
	public DeliverInvoice getDeliverInvHeader(String deliverNum);
	
	public boolean chkLegalRetInv(String deliverNum,List<ProdQty> unsavedRetInvoiceProdQty);

}
