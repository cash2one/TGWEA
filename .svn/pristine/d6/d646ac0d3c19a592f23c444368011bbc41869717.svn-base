package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.CustSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.ICustService;
import com.etaoguan.wea.vo.Customer;

public interface IWCustService extends ICustService{
	
	@SuppressWarnings("rawtypes")
	public WPage listSearchCusts(CustSearch custSearch, SortParam sortParam,
			WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public WPage listCusts(CustSearch custSearch, SortParam sortParam,
			WPagingRequest wpagingRequest);

	@SuppressWarnings("rawtypes")
	public Map getListCustsSearchInitData(String ownerNum);
	
	public void updateResetCustPwd(String custNum);
	
	public void delBatchCust(String[] custNums);
	
	@SuppressWarnings("rawtypes")
	public Map getEditCustInitData(String ownerNum,String custNum);
	
	public void saveOrUpdateCust(Customer cust);

}
