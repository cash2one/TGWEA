package com.etaoguan.wea.client.web.service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.SettleInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WSettleInvoice;
import com.etaoguan.wea.service.ISettleInvService;

public interface IWSettleInvService extends ISettleInvService{

	@SuppressWarnings("rawtypes")
	public WPage listSettleInvs(SettleInvSearch settleInvSearch, SortParam sortParam,
			WPagingRequest wpagingRequest);
	
	public WSettleInvoice getSettleInv(String orderNum);
	
	public void updateConfirmOrderSettlement(String orderNum);
}
