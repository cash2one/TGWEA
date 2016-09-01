package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.DeliverInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IDeliverInvService;

public interface IWDeliverInvService extends IDeliverInvService{
	@SuppressWarnings("rawtypes")
	public WPage listDeliverInvs(DeliverInvSearch deliverInvSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getListDeliverInvsSearchInitData(String ownerNum);
}
