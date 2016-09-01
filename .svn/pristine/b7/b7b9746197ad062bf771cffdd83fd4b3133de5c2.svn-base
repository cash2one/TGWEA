package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.GodownInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.IGodownInvService;
import com.etaoguan.wea.vo.GodownInvoice;

public interface IWGodownInvService extends IGodownInvService{

	@SuppressWarnings("rawtypes")
	public Map getListGodownInvsSearchInitData(String ownerNum);

	@SuppressWarnings("rawtypes")
	public WPage listGodownInvs(GodownInvSearch godownInvSearch,SortParam sortParam,WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getEditGodownInvInitData(String ownerNum,String gdNum);
	
	public void saveOrUpdateGodownInv(GodownInvoice godownInvoice);
}
