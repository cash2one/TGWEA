package com.etaoguan.wea.client.mobile.service;

import com.etaoguan.wea.client.mobile.vo.CustSearch;
import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.MPagingRequest;
import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.service.ICustService;
import com.etaoguan.wea.vo.Customer;

public interface IMCustService extends ICustService{

	@SuppressWarnings("rawtypes")
	public MPage listCusts(CustSearch custSearch,SortParam sortParam,MPagingRequest mpagingRequest);
	
	public boolean existCustName(String ownerNum,String custName);
	
	public Customer getLoginCust(String custNum);
}
