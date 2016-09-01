package com.etaoguan.wea.client.web.service;

import java.util.List;

import com.etaoguan.wea.service.IGroupOfCustService;
import com.etaoguan.wea.vo.GroupOfCust;

public interface IWGroupOfCustService extends IGroupOfCustService{
	/**
	 * @param groupOfCust
	 * @return 获取组名
	 */
	public GroupOfCust nameOfGroup(String custId);
	public GroupOfCust listGroup(String groupNum);
	public void removeGroup(String groupNum);
	public void addGroupOfCust(GroupOfCust groupOfCust);
	public void delGroupOfCust(int id);
	public List<GroupOfCust> listSearchGroupOfCusts(String ownerNum);
	
}
