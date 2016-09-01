package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IAuthorityDao;
import com.etaoguan.wea.vo.Authority;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class AuthorityDao extends SpringBaseDao implements IAuthorityDao{

	@Override
	@Resource(name="authoritySqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	@Override
	public void insertAuthority(Authority authority) {
		this.getSqlMapClientTemplate().insert("insertAuthority", authority);
		
	}

	@Override
	public void deleteAuthority(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteAuthority",dataCriteria.getParams());
		
	}

	@Override
	public Authority selectAuthority(DataCriteria dataCriteria) {
		return (Authority) this.getSqlMapClientTemplate().queryForObject("selectAuthority",dataCriteria.getParams());
	}
	



}
