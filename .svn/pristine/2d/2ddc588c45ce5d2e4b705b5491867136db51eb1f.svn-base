package com.etaoguan.wea.service;

import java.util.Date;
import java.util.List;

import com.etaoguan.wea.vo.AccessOperation;
import com.etaoguan.wea.vo.Admin;
import com.etaoguan.wea.vo.AdminGroup;
import com.etaoguan.wea.vo.AdminRole;

public interface IAdminService {
	
	public List<Admin> getAllAdmins();
	
	public int addAdmin(Admin admin);
	
	public void delAdminGroupRelations(int adminId);
	
	public void updateAdmin(Admin admin);
	
	public void delAdmin(int adminId);
	
	public void updateAdminPwd(int adminId,String adminPwd);
	
	public List<AdminGroup> getAllGroups();
	
	public List<AdminGroup> getAdminGroups(int adminId);
	
	public int addGroup(AdminGroup group);
	
	public void updateGroup(AdminGroup group);
	
	public void delGroup(int groupId);
	
	public List<AdminRole> getAllRoles();
	
	public List<AdminRole> getGroupRoles(int groupId);
	
	public List<AccessOperation> getAllAccessOperations();
	
	public List<AccessOperation> getRoleAccessOperations(int roleId);
	
	public List<AdminRole> getFinalAdminRoles(int adminId);
	
	public int addRole(AdminRole role);
	
	public void updateRole(AdminRole role);
	
	public void delRole(int roleId);
	
	public void updateRoleOperationRelations(int roleId,List<AccessOperation> adminRoleOperationRelationList);
	
	public void updateGroupRoleRelations(int groupId,int[] roleIds);
	
	public void updateAdminGroupRelations(int adminId,int[] groupIds);
	
	public void updateAdminLoginDate(int adminId,Date loginDate);
	
	public Admin getLoginAdmin(String adminName, String adminPwd);
	
	public Admin getAdmin(int adminId);
	
	public AdminGroup getGroup(int groupId);
	
	public AdminRole getRole(int roleId);
	
}
