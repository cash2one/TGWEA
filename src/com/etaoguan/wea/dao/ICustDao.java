package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.Customer;

public interface ICustDao {
	
	@SuppressWarnings("rawtypes")
	public DataSet getCustDataSet(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addCust(Customer cust);

	public void updateCust(Customer cust);
	
	public void updateCust(DataCriteria dataCriteria);
	
	public Customer geCust(DataCriteria dataCriteria);
	
	public Customer geLoginCust(DataCriteria dataCriteria);

	public List<Customer> getCusts(DataCriteria dataCriteria);
	
}
