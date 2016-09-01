package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.StkAllocInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IStkAllocInvService;
import com.etaoguan.wea.vo.StockAllocateInvoice;

public interface IWStkAllocInvService extends IStkAllocInvService{

	@SuppressWarnings("rawtypes")
	public Map getListStkAllocInvsSearchInitData(String ownerNum);

	@SuppressWarnings("rawtypes")
	public WPage listStkAllocInvs(StkAllocInvSearch stkAllocInvSearch,SortParam sortParam,WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getEditStkAllocInvInitData(String ownerNum,String stkAllocNum);
	
	public void saveOrUpdateStkAllocInv(StockAllocateInvoice StkAllocInv);
}
