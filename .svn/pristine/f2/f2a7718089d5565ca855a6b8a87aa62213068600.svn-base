package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IAccessAuthDao;
import com.etaoguan.wea.vo.AccessOperation;
import com.etaoguan.wea.vo.AccessFuncMethod;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class AccessAuthDao extends SpringBaseDao implements IAccessAuthDao{

	@Override
	@Resource(name="accessAuthSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	
	@Override
	public void addAccessFuncMethod(AccessFuncMethod accessFuncMethod) {
		this.getSqlMapClientTemplate().insert("createAccessFuncMethod", accessFuncMethod);
	}

	@Override
	public void updateAccessOperations() {
		this.getSqlMapClientTemplate().update("syncAccessOperations", null);
	}

	@Override
	public void delAccessFuncMethod(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteAccessFuncMethod", dataCriteria.getParams());
		
	}
	
	@Override
	public AccessFuncMethod getAccessFuncMethod(DataCriteria dataCriteria) {

		return (AccessFuncMethod)this.getSqlMapClientTemplate().queryForObject("getAccessFuncMethod", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AccessFuncMethod> getAccessFuncMethods(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getAccessFuncMethods", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AccessOperation> getAccessOperations(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getAccessOperations", dataCriteria.getParams());
	}



}
