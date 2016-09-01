package com.etaoguan.wea.service;

import java.util.Date;
import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.Customer;

public interface ICustService {
	
	@SuppressWarnings("rawtypes")
	public DataSet listCusts(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addCust(Customer cust);
	
	public Customer getCust(String custNum);
	
	public List<Customer> getCusts(String[] custNums);
	
	public Customer getCustByCustName(String ownerNum,String custName);
	
	public void updateCustPwd(String custNum,String custNewPwd);
	
	public void updateCust(Customer cust);
	
	public void updateCustKeyLevel(String custNum,int keyLevel);
	
	public void updateCust2delStatus(String custNum);
	
	public void updateCustLoginDate(String custNum,Date loginDate);
	
	public boolean isActiveCust(String custNum);
	
	public Customer getLoginCust(String ownerNum,String custName, String password);

}
