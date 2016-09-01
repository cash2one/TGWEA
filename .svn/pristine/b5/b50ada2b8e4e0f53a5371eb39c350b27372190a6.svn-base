package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.DeliverInvoice;
import com.etaoguan.wea.vo.DeliverInvoiceItem;
public interface IDeliverInvDao {
	
	@SuppressWarnings("rawtypes")
	public DataSet getDeliverInvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void updateDeliverInv(DataCriteria dataCriteria);
	
	public void addDeliverInv(DeliverInvoice deliverInv);
	
	public void addDeliverInvItem(DeliverInvoiceItem deliverInvItem);
	
	public List<DeliverInvoiceItem> getDeliverInvItems(DataCriteria dataCriteria);
	
	public void delDeliverInv(DataCriteria dataCriteria);
	
	public DeliverInvoice getDeliverInv(DataCriteria dataCriteria);
	
	public int getDeliverInvCount(DataCriteria dataCriteria);

}
