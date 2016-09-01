package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IFileCacheDeltaDao;
import com.etaoguan.wea.vo.FileCacheDelta;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class FileCacheDeltaDao extends SpringBaseDao implements IFileCacheDeltaDao{

	@Override
	@Resource(name="fileCacheSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addFileCacheDelta(FileCacheDelta fileCacheDelta) {
		this.getSqlMapClientTemplate().insert("createFileCacheDelta",fileCacheDelta);
		
	}

	@Override
	public void updateFileCacheDeltaDate(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateFileCacheDelta",dataCriteria.getParams());
		
	}

	@Override
	public FileCacheDelta getFileCacheDelta(DataCriteria dataCriteria) {

		return (FileCacheDelta)this.getSqlMapClientTemplate().queryForObject("getFileCacheDelta",dataCriteria.getParams());
	}

}
