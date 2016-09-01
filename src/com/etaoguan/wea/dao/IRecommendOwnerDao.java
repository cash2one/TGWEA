package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.vo.RecommendOwner;

public interface IRecommendOwnerDao {

	public void addRecommendOwner(RecommendOwner recommendOwner);
	
	public void updateRecommendOwner(DataCriteria dataCriteria);
	
	public void updateRecommendOwner(RecommendOwner recommendOwner);
	
	public void delRecommendOwner(DataCriteria dataCriteria);
	
	public List<RecommendOwner> getRecommendOwners(DataCriteria dataCriteria);
	
	public RecommendOwner getRecommendOwner(DataCriteria dataCriteria);
	
}
