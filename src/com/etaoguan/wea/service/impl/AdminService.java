package com.etaoguan.wea.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IAdminDao;
import com.etaoguan.wea.service.IAccessAuthService;
import com.etaoguan.wea.service.IAdminService;
import com.etaoguan.wea.vo.AccessOperation;
import com.etaoguan.wea.vo.Admin;
import com.etaoguan.wea.vo.AdminGroup;
import com.etaoguan.wea.vo.AdminGroupRef;
import com.etaoguan.wea.vo.AdminGroupRoleRef;
import com.etaoguan.wea.vo.AdminRole;
import com.etaoguan.wea.vo.AdminRoleOperationRef;

@Service("adminService")
public class AdminService extends BaseService implements IAdminService{

	@Autowired
	private IAdminDao iAdminDao;
	
	@Resource(name="accessAuthService") 
	private IAccessAuthService iAccessAuthService;
	
	@Override
	public int addAdmin(Admin admin) {
		admin.setCreateBy(getCurrentOperator());
		admin.setUpdateBy(getCurrentOperator());
		return iAdminDao.addAdmin(admin);
		
	}

	@Override
	public int addGroup(AdminGroup group) {
		group.setCreateBy(getCurrentOperator());
		group.setUpdateBy(getCurrentOperator());
		return iAdminDao.addGroup(group);
		
	}

	@Override
	public int addRole(AdminRole role) {
		role.setCreateBy(getCurrentOperator());
		role.setUpdateBy(getCurrentOperator());
		return iAdminDao.addRole(role);
		
	}

	@Override
	public void delAdmin(int adminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId",adminId);
		iAdminDao.delAdmin(dataCriteria);
	}

	@Override
	public void delGroup(int groupId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupId",groupId);
		iAdminDao.delGroup(dataCriteria);
		
	}

	@Override
	public void delRole(int roleId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("roleId",roleId);
		iAdminDao.delRole(dataCriteria);
		
	}

	@Override
	public List<Admin> getAllAdmins() {
		DataCriteria dataCriteria = new DataCriteria();

		return iAdminDao.getAdmins(dataCriteria);
	}

	@Override
	public List<AdminGroup> getAllGroups() {
		DataCriteria dataCriteria = new DataCriteria();
		return iAdminDao.getGroups(dataCriteria);
	}

	@Override
	public List<AdminRole> getAllRoles() {
		DataCriteria dataCriteria = new DataCriteria();
		return iAdminDao.getRoles(dataCriteria);
	}
	
	public List<AdminRole> getRolesByAdminId(int adminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId", adminId);
		return iAdminDao.getRoles(dataCriteria);
	}

	@Override
	public void updateAdmin(Admin admin) {
		admin.setUpdateBy(getCurrentOperator());
		iAdminDao.updateAdmin(admin);
		
	}

	@Override
	public void updateAdminLoginDate(int adminId, Date loginDate) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId",adminId);
		dataCriteria.setParam("loginDate",loginDate);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iAdminDao.updateAdmin(dataCriteria);
		
	}

	@Override
	public void updateAdminPwd(int adminId, String adminPwd) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId",adminId);
		dataCriteria.setParam("adminPwd",adminPwd);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iAdminDao.updateAdmin(dataCriteria);
		
	}

	@Override
	public void updateGroup(AdminGroup group) {
		group.setUpdateBy(getCurrentOperator());
		iAdminDao.updateGroup(group);
		
	}

	@Override
	public void updateRole(AdminRole role) {
		role.setUpdateBy(getCurrentOperator());
		iAdminDao.updateRole(role);
		
	}

	@Override
	public void updateGroupRoleRelations(int groupId,int[] roleIds) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupId",groupId);
		iAdminDao.delAdminGroupRoleRef(dataCriteria);
		for(int roleId:roleIds){
			AdminGroupRoleRef adminGroupRoleRef = new AdminGroupRoleRef();
			adminGroupRoleRef.setGroupId(groupId);
			adminGroupRoleRef.setRoleId(roleId);
			adminGroupRoleRef.setCreateBy(getCurrentOperator());
			adminGroupRoleRef.setUpdateBy(getCurrentOperator());
			iAdminDao.addAdminGroupRoleRef(adminGroupRoleRef);
		}
		
	}

	@Override
	public void updateRoleOperationRelations(int roleId,
			List<AccessOperation> adminRoleOperationRelationList) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("roleId",roleId);
		iAdminDao.delAdminRoleOperationRef(dataCriteria);
		for(AccessOperation accessFunc:adminRoleOperationRelationList){
			AdminRoleOperationRef adminRoleOperationRef = new AdminRoleOperationRef();
			adminRoleOperationRef.setRoleId(roleId);
			adminRoleOperationRef.setOperationName(accessFunc.getOperationName());
			adminRoleOperationRef.setModuleName(accessFunc.getModuleName());
			adminRoleOperationRef.setCreateBy(getCurrentOperator());
			adminRoleOperationRef.setUpdateBy(getCurrentOperator());
			iAdminDao.addAdminRoleOperationRef(adminRoleOperationRef);
		}
		
	}

	@Override
	public Admin getLoginAdmin(String adminName, String adminPwd) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminName",adminName);
		dataCriteria.setParam("adminPwd",adminPwd);
		Admin admin = iAdminDao.getLoginAdmin(dataCriteria);
		if(admin!=null){
			admin.setAccessOperationList(iAccessAuthService.getAdminAccessOperationsByRole(getFinalAdminRoles(admin.getAdminId())));
		}
		return admin;
	}

	@Override
	public List<AdminRole> getFinalAdminRoles(int adminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId",adminId);
		return iAdminDao.getFinalAdminRoles(dataCriteria);
	}

	@Override
	public Admin getAdmin(int adminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId",adminId);
		return iAdminDao.getAdmin(dataCriteria);
	}

	@Override
	public List<AdminGroup> getAdminGroups(int adminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId",adminId);
		return iAdminDao.getAdminGroups(dataCriteria);
	}

	@Override
	public void delAdminGroupRelations(int adminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId",adminId);
		iAdminDao.delAdminGroupRef(dataCriteria);
		
	}

	@Override
	public void updateAdminGroupRelations(int adminId, int[] groupIds) {
		delAdminGroupRelations(adminId);
		for(int groupId:groupIds){
			AdminGroupRef adminGroupRef = new AdminGroupRef();
			adminGroupRef.setGroupId(groupId);
			adminGroupRef.setAdminId(adminId);
			adminGroupRef.setCreateBy(getCurrentOperator());
			adminGroupRef.setUpdateBy(getCurrentOperator());
			iAdminDao.addAdminGroupRef(adminGroupRef);
		}
		
	}

	@Override
	public AdminGroup getGroup(int groupId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupId",groupId);
		return iAdminDao.getGroup(dataCriteria);
	}

	@Override
	public AdminRole getRole(int roleId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("roleId",roleId);
		return iAdminDao.getRole(dataCriteria);
	}

	@Override
	public List<AdminRole> getGroupRoles(int groupId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupId",groupId);
		return iAdminDao.getGroupRoles(dataCriteria);
	}

	@Override
	public List<AccessOperation> getAllAccessOperations() {
		DataCriteria dataCriteria = new DataCriteria();
		return iAdminDao.getAccessOperations(dataCriteria);
	}

	@Override
	public List<AccessOperation> getRoleAccessOperations(int roleId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("roleId",roleId);
		return iAdminDao.getAdminRoleAccessOperations(dataCriteria);
	}


}
