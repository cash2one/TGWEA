package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IOwnerBannerDao;
import com.etaoguan.wea.vo.OwnerBanner;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class OwnerBannerDao extends SpringBaseDao implements IOwnerBannerDao{

	@Override
	@Resource(name="ownerSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addOwnerBanner(OwnerBanner ownerBanner) {
		this.getSqlMapClientTemplate().insert("createOwnerBanner", ownerBanner);
		
	}

	@Override
	public void delOwnerBanner(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delOwnerBanner", dataCriteria.getParams());
		
	}

	@Override
	public OwnerBanner getOwnerBanner(DataCriteria dataCriteria) {
		return (OwnerBanner)this.getSqlMapClientTemplate().queryForObject("getOwnerBanner", dataCriteria.getParams());
	}

	@Override
	public int getOwnerBannerMaxSequence(DataCriteria dataCriteria) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("getOwnerBannerMaxSequence", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OwnerBanner> getOwnerBanners(DataCriteria dataCriteria) {
		 return this.getSqlMapClientTemplate().queryForList("getOwnerBannerList", dataCriteria.getParams());
	}

	@Override
	public void updateOwnerBanner(OwnerBanner ownerBanner) {
		this.getSqlMapClientTemplate().update("updateOwnerBanner", ownerBanner);
		
	}

	@Override
	public void updateOwnerBanner(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateOwnerBannerByMap", dataCriteria.getParams());
		
	}

}
