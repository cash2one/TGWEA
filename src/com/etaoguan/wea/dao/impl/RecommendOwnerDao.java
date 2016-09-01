package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IRecommendOwnerDao;
import com.etaoguan.wea.vo.RecommendOwner;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class RecommendOwnerDao extends SpringBaseDao implements IRecommendOwnerDao{

	@Override
	@Resource(name="ownerSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addRecommendOwner(RecommendOwner recommendOwner) {
		this.getSqlMapClientTemplate().insert("createRecommendOwner", recommendOwner);
		
	}

	@Override
	public void delRecommendOwner(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteRecommendOwner", dataCriteria);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RecommendOwner> getRecommendOwners(DataCriteria dataCriteria) {

		return this.getSqlMapClientTemplate().queryForList("getRecommendOwnerList", dataCriteria.getParams());
	}

	@Override
	public void updateRecommendOwner(RecommendOwner recommendOwner) {
		this.getSqlMapClientTemplate().update("updateRecommendOwner", recommendOwner);
		
	}

	@Override
	public RecommendOwner getRecommendOwner(DataCriteria dataCriteria) {
		
		return (RecommendOwner)this.getSqlMapClientTemplate().queryForObject("getRecommendOwner", dataCriteria.getParams());
	}

	@Override
	public void updateRecommendOwner(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateRecommendOwner", dataCriteria.getParams());
		
	}

}
