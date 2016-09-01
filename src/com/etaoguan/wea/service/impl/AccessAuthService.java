package com.etaoguan.wea.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IAccessAuthDao;
import com.etaoguan.wea.service.IAccessAuthService;
import com.etaoguan.wea.vo.AccessFuncMethod;
import com.etaoguan.wea.vo.AccessOperation;
import com.etaoguan.wea.vo.AdminRole;

@Service("accessAuthService")
public class AccessAuthService extends BaseService implements IAccessAuthService{

	@Autowired
	private IAccessAuthDao iAccessAuthDao;

	@Override
	public void addAccessFuncMethod(AccessFuncMethod accessFuncMethod) {
		iAccessAuthDao.addAccessFuncMethod(accessFuncMethod);
		
	}

	@Override
	public AccessFuncMethod getAccessFuncMethodByMethod(String classMethod) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("classMethod", classMethod);
		return iAccessAuthDao.getAccessFuncMethod(dataCriteria);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccessOperation> getAdminAccessOperationsByRole(List<AdminRole> adminRoleList) {
		List roleIds = new ArrayList<Integer>();
		for(AdminRole adminRole:adminRoleList){
			roleIds.add(adminRole.getRoleId());
		}
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("roleIds", roleIds);
		dataCriteria.setParam("affectRole", 1);
		return iAccessAuthDao.getAccessOperations(dataCriteria);
	}
	
	@Override
	public List<AccessOperation> getOwnerAccessOperationsByRole() {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("affectRole", 2);
		return iAccessAuthDao.getAccessOperations(dataCriteria);
	}
	
	@Override
	public List<AccessOperation> getCustAccessOperationsByRole() {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("affectRole", 3);
		return iAccessAuthDao.getAccessOperations(dataCriteria);
	}	

	@Override
	public void delAllAccessFuncMethods() {
		DataCriteria dataCriteria = new DataCriteria();
		iAccessAuthDao.delAccessFuncMethod(dataCriteria);
		
	}

	@Override
	public void updateAccessOperations() {
		iAccessAuthDao.updateAccessOperations();
		
	}

	@Override
	public void saveInitAccessAuthConfig(
			Collection<AccessFuncMethod> accessFuncMethods) {
		if(accessFuncMethods==null||accessFuncMethods.size()==0){
			return;
		}
		delAllAccessFuncMethods();
		for(AccessFuncMethod accessFuncMethod:accessFuncMethods){
			addAccessFuncMethod(accessFuncMethod);
		}
		updateAccessOperations();
		
	}

}
