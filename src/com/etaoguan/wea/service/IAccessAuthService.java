package com.etaoguan.wea.service;

import java.util.Collection;
import java.util.List;

import com.etaoguan.wea.vo.AccessOperation;
import com.etaoguan.wea.vo.AccessFuncMethod;
import com.etaoguan.wea.vo.AdminRole;

public interface IAccessAuthService {

	public List<AccessOperation> getAdminAccessOperationsByRole(List<AdminRole> adminRoleList);
	
	public List<AccessOperation> getOwnerAccessOperationsByRole();
	
	public List<AccessOperation> getCustAccessOperationsByRole();

	public void delAllAccessFuncMethods();
	
	public void updateAccessOperations();
	
	public void addAccessFuncMethod(AccessFuncMethod accessFuncMethod);
	
	public void saveInitAccessAuthConfig(Collection<AccessFuncMethod> accessFuncMethods);
	
	public AccessFuncMethod getAccessFuncMethodByMethod(String classMethod);
	
}
