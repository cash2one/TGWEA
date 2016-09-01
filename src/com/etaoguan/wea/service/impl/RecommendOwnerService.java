package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IRecommendOwnerDao;
import com.etaoguan.wea.service.IRecommendOwnerService;
import com.etaoguan.wea.vo.RecommendOwner;

@Service("recommendOwnerService")
public class RecommendOwnerService  extends BaseService implements IRecommendOwnerService{


	@Autowired
	IRecommendOwnerDao iRecommendOwnerDao;

	@Override
	public void addRecommendOwner(RecommendOwner recommendOwner) {
		iRecommendOwnerDao.addRecommendOwner(recommendOwner);
		
	}

	@Override
	public void delRecommendOwner(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		iRecommendOwnerDao.delRecommendOwner(dataCriteria);
	}

	@Override
	public List<RecommendOwner> getAllRecommendOwners() {
		DataCriteria dataCriteria = new DataCriteria();
		return iRecommendOwnerDao.getRecommendOwners(dataCriteria);
	}

	@Override
	public void updateRecommendOwner(RecommendOwner recommendOwner) {
		iRecommendOwnerDao.updateRecommendOwner(recommendOwner);
		
	}

	@Override
	public void updateRecommendOwnerSequence(String preOwnerNum, String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",preOwnerNum);
		RecommendOwner preRecommendOwner = iRecommendOwnerDao.getRecommendOwner(dataCriteria);
		dataCriteria.setParam("ownerNum",ownerNum);
		RecommendOwner recommendOwner = iRecommendOwnerDao.getRecommendOwner(dataCriteria);
		int preSequence = preRecommendOwner.getSequence();
		preRecommendOwner.setSequence(recommendOwner.getSequence());
		recommendOwner.setSequence(preSequence);
		iRecommendOwnerDao.updateRecommendOwner(preRecommendOwner);
		iRecommendOwnerDao.updateRecommendOwner(recommendOwner);
		
	}

}
