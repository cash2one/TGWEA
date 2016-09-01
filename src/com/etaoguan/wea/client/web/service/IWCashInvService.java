package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.CashInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.ICashInvService;
import com.etaoguan.wea.vo.CashInvoice;

public interface IWCashInvService extends  ICashInvService{

	@SuppressWarnings("rawtypes")
	public WPage listCashInvs(CashInvSearch cashInvSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getEditCashInvInitData(String ownerNum,String orderNum, String cashNum);
	
	@SuppressWarnings("rawtypes")
	public Map getListCashInvsSearchInitData(String ownerNum);
	
	public void saveOrUpdateCashInv(CashInvoice cashInv);
}
