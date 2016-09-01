package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.vo.AccessOperation;
import com.etaoguan.wea.vo.Admin;
import com.etaoguan.wea.vo.AdminGroup;
import com.etaoguan.wea.vo.AdminGroupRef;
import com.etaoguan.wea.vo.AdminGroupRoleRef;
import com.etaoguan.wea.vo.AdminRole;
import com.etaoguan.wea.vo.AdminRoleOperationRef;

public interface IAdminDao {
	
	public List<Admin> getAdmins(DataCriteria dataCriteria);
	
	public int addAdmin(Admin admin);
	
	public void addAdminGroupRef(AdminGroupRef adminGroupRef);
	
	public void delAdminGroupRef(DataCriteria dataCriteria);
	
	public void updateAdmin(Admin admin);
	
	public void updateAdmin(DataCriteria dataCriteria);
	
	public void delAdmin(DataCriteria dataCriteria);
	
	public List<Admin> getGroupAdmins(DataCriteria dataCriteria);
	
	public List<Admin> getNoGroupAdmins(DataCriteria dataCriteria);
	
	public int addRole(AdminRole role);
	
	public void addAdminRoleOperationRef(AdminRoleOperationRef adminRoleOperationRef);
	
	public void delAdminRoleOperationRef(DataCriteria dataCriteria);
	
	public void updateRole(AdminRole role);
	
	public void delRole(DataCriteria dataCriteria);
	
	public List<AdminRole> getGroupRoles(DataCriteria dataCriteria);
	
	public List<AdminRole> getNoGroupRoles(DataCriteria dataCriteria);
	
	public int addGroup(AdminGroup group);
	
	public void addAdminGroupRoleRef(AdminGroupRoleRef adminGroupRoleRef);
	
	public void delAdminGroupRoleRef(DataCriteria dataCriteria);
	
	public void updateGroup(AdminGroup group);
	
	public void delGroup(DataCriteria dataCriteria);
	
	public List<AdminGroup> getGroups(DataCriteria dataCriteria);
	
	public List<AdminGroup> getAdminGroups(DataCriteria dataCriteria);
	
	public List<AdminRole> getRoles(DataCriteria dataCriteria);
	
	public List<AdminRole> getFinalAdminRoles(DataCriteria dataCriteria);
	
	public List<AdminGroup> getNoAdminGroups(DataCriteria dataCriteria);
	
	public Admin getLoginAdmin(DataCriteria dataCriteria);
	
	public Admin getAdmin(DataCriteria dataCriteria);
	
	public AdminGroup getGroup(DataCriteria dataCriteria);
	
	public AdminRole getRole(DataCriteria dataCriteria);
	
	public List<AccessOperation> getAdminRoleAccessOperations(DataCriteria dataCriteria);

	public List<AccessOperation> getAccessOperations(DataCriteria dataCriteria);
}
