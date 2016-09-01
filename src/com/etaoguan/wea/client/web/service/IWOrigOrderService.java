package com.etaoguan.wea.client.web.service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.OrigOrderSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IOrigOrderService;

public interface IWOrigOrderService extends IOrigOrderService{

	@SuppressWarnings("rawtypes")
	public WPage listOrigOrders(OrigOrderSearch origOrderSearch, SortParam sortParam,
			WPagingRequest wpagingRequest) ;
}
