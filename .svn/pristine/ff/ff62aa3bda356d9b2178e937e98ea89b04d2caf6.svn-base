package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IAdminDao;
import com.etaoguan.wea.vo.AccessOperation;
import com.etaoguan.wea.vo.Admin;
import com.etaoguan.wea.vo.AdminGroup;
import com.etaoguan.wea.vo.AdminGroupRef;
import com.etaoguan.wea.vo.AdminGroupRoleRef;
import com.etaoguan.wea.vo.AdminRole;
import com.etaoguan.wea.vo.AdminRoleOperationRef;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class AdminDao extends SpringBaseDao implements IAdminDao{

	@Override
	@Resource(name="adminSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public int addAdmin(Admin admin) {
		return (Integer)this.getSqlMapClientTemplate().insert("createAdmin", admin);
		
	}

	@Override
	public int addGroup(AdminGroup group) {
		return (Integer)this.getSqlMapClientTemplate().insert("createGroup", group);
		
	}

	@Override
	public int addRole(AdminRole role) {
		return (Integer)this.getSqlMapClientTemplate().insert("createRole", role);
	}

	@Override
	public void delAdmin(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteAdmin", dataCriteria.getParams());
		
	}

	@Override
	public void delGroup(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteGroup", dataCriteria.getParams());
		
	}

	@Override
	public void delRole(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteRole", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdminGroup> getAdminGroups(DataCriteria dataCriteria) {

		return this.getSqlMapClientTemplate().queryForList("getAdminGroups", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Admin> getGroupAdmins(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getGroupAdmins", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdminRole> getGroupRoles(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getGroupRoles", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdminGroup> getNoAdminGroups(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getNoAdminGroups", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Admin> getNoGroupAdmins(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getNoGroupAdmins", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdminRole> getNoGroupRoles(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getNoGroupRoles", dataCriteria.getParams());
	}

	@Override
	public void updateAdmin(Admin admin) {
		this.getSqlMapClientTemplate().update("updateAdmin", admin);
		
	}

	@Override
	public void updateGroup(AdminGroup group) {
		this.getSqlMapClientTemplate().update("updateGroup", group);
		
	}

	@Override
	public void updateRole(AdminRole role) {
		this.getSqlMapClientTemplate().update("updateRole", role);
		
	}

	@Override
	public void updateAdmin(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateAdminByMap", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Admin> getAdmins(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getAdmins", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdminGroup> getGroups(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getGroups", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdminRole> getRoles(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getRoles", dataCriteria.getParams());
	}

	@Override
	public void addAdminGroupRef(AdminGroupRef adminGroupRef) {
		this.getSqlMapClientTemplate().insert("createAdminGroupRef", adminGroupRef);
		
	}

	@Override
	public void addAdminGroupRoleRef(AdminGroupRoleRef adminGroupRoleRef) {
		this.getSqlMapClientTemplate().insert("createAdminGroupRoleRef", adminGroupRoleRef);
	}

	@Override
	public void addAdminRoleOperationRef(AdminRoleOperationRef adminRoleOperationRef) {
		this.getSqlMapClientTemplate().insert("createAdminRoleOperationRef", adminRoleOperationRef);
	}

	@Override
	public void delAdminGroupRef(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delAdminGroupRef", dataCriteria.getParams());
		
	}

	@Override
	public void delAdminGroupRoleRef(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delAdminGroupRoleRef", dataCriteria.getParams());
		
	}

	@Override
	public void delAdminRoleOperationRef(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delAdminRoleOperationRef", dataCriteria.getParams());
		
	}

	@Override
	public Admin getLoginAdmin(DataCriteria dataCriteria) {
		return (Admin)this.getSqlMapClientTemplate().queryForObject("getLoginAdmin", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdminRole> getFinalAdminRoles(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getFinalAdminRoles", dataCriteria.getParams());
	}

	@Override
	public Admin getAdmin(DataCriteria dataCriteria) {
		return (Admin)this.getSqlMapClientTemplate().queryForObject("getAdmin", dataCriteria.getParams());
	}

	@Override
	public AdminGroup getGroup(DataCriteria dataCriteria) {
		return (AdminGroup)this.getSqlMapClientTemplate().queryForObject("getGroup", dataCriteria.getParams());
	}

	@Override
	public AdminRole getRole(DataCriteria dataCriteria) {
		return (AdminRole)this.getSqlMapClientTemplate().queryForObject("getRole", dataCriteria.getParams());
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<AccessOperation> getAccessOperations(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getAccessOperations", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AccessOperation> getAdminRoleAccessOperations(
			DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getRoleAccessOperations", dataCriteria.getParams());
	}

}
