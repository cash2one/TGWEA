package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.Owner;

public interface IOwnerDao {

	@SuppressWarnings("rawtypes")
	public DataSet getOwnerDataSet(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addOwner(Owner owner);
	
	public void updateOwner(Owner owner);
	
	public void updateOwner(DataCriteria dataCriteria);
	
	public Owner getOwner(DataCriteria dataCriteria);
	
	public List<Owner> getAllOwner(DataCriteria dataCriteria);
	
	public int getExistShopCount(DataCriteria dataCriteria);
	
	public void updateOwnerShopNum(DataCriteria dataCriteria);
	
	public String getRandomOwnerShopNum(DataCriteria dataCriteria);
}
