package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.ReturnedInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IReturnedInvService;
import com.etaoguan.wea.vo.ReturnedInvoice;

public interface IWReturnedInvService extends IReturnedInvService{
	
	@SuppressWarnings("rawtypes")
	public WPage listReturnedInvs(ReturnedInvSearch returnedInvSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getEditReturnedInvInitData(String ownerNum, String orderNum,String retInvNum);
	
	public void saveOrUpdateReturnedInv(ReturnedInvoice returnedInv);
	
	public String getDeliverInvNumByOrderNum(String orderNum);
	
	@SuppressWarnings("rawtypes")
	public Map getListReturnedInvsSearchInitData(String ownerNum);
}
