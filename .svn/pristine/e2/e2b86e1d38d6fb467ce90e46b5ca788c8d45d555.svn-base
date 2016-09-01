package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IGroupOfCustDao;
import com.etaoguan.wea.service.IGroupOfCustService;
import com.etaoguan.wea.vo.GroupOfCust;

@Service("groupOfCustService")
public class GroupOfCustService extends BaseService implements IGroupOfCustService {

	@Autowired
	private IGroupOfCustDao iGroupOfCustDao;
	

	@Override
	public List<GroupOfCust> listGroupOfCust(DataCriteria dataCriteria) {
		return iGroupOfCustDao.getGroupOfCust(dataCriteria);
	}


	@Override
	public void delGroupOfCust(DataCriteria dataCriteria) {
		iGroupOfCustDao.delGroupOfCust(dataCriteria);
	}


	@Override
	public void insertGroupOfCust(GroupOfCust groupOfCust) {
		iGroupOfCustDao.addGroupOfCust(groupOfCust);
	}


	@Override
	public void delGroup(DataCriteria dataCriteria) {
		iGroupOfCustDao.delGroup(dataCriteria);
	}


	@Override
	public List<GroupOfCust> listGroupInfo(DataCriteria dataCriteria) {
		return iGroupOfCustDao.getGroupInfo(dataCriteria);
	}


	/* (non-Javadoc)获取组名
	 * @see com.etaoguan.wea.service.IGroupOfCustService#nameOfGroup(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public GroupOfCust nameOfGroup(DataCriteria dataCriteria) {
		return iGroupOfCustDao.nameOfGroup(dataCriteria);
	}



}
