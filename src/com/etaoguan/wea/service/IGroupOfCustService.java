package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.vo.GroupOfCust;

public interface IGroupOfCustService {
	/**
	 * @param dataCriteria
	 * @return 获取组名
	 */
	public GroupOfCust nameOfGroup(DataCriteria dataCriteria);
	public List<GroupOfCust> listGroupInfo(DataCriteria dataCriteria);
	public void delGroup(DataCriteria dataCriteria);
	public void insertGroupOfCust(GroupOfCust groupOfCust);
	public void delGroupOfCust(DataCriteria dataCriteria);
	public List<GroupOfCust> listGroupOfCust(DataCriteria dataCriteria);
	
}
