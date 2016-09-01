package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IOwnerBannerDao;
import com.etaoguan.wea.service.IOwnerBannerService;
import com.etaoguan.wea.vo.OwnerBanner;

@Service("ownerBannerService")
public class OwnerBannerService extends BaseService implements IOwnerBannerService{

	@Autowired
	private IOwnerBannerDao iOwnerBannerDao;
	
	@Override
	public void addOwnerBanner(OwnerBanner ownerBanner) {
		int sequence = getOwnerBannerMaxSeqence(ownerBanner.getOwnerNum());
		ownerBanner.setSequence(sequence+1);
		ownerBanner.setUpdateBy(getCurrentOperator());
		ownerBanner.setCreateBy(getCurrentOperator());
		iOwnerBannerDao.addOwnerBanner(ownerBanner);
		
	}
	@Override
	public synchronized int getOwnerBannerMaxSeqence(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iOwnerBannerDao.getOwnerBannerMaxSequence(dataCriteria);
	}
	@Override
	public void delOwnerBanner(long bannerId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("bannerId", bannerId);
		iOwnerBannerDao.delOwnerBanner(dataCriteria);
		
	}

	@Override
	public List<OwnerBanner> getAllOwnerBanners(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		return iOwnerBannerDao.getOwnerBanners(dataCriteria);
	}

	@Override
	public OwnerBanner getOwnerBanner(long bannerId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("bannerId", bannerId);
		return iOwnerBannerDao.getOwnerBanner(dataCriteria);
	}

	@Override
	public void updateOwnerBannerSeqence(long preBannerId,long bannerId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("bannerId",preBannerId);
		OwnerBanner preOwnerBanner = iOwnerBannerDao.getOwnerBanner(dataCriteria);
		dataCriteria.setParam("bannerId",bannerId);
		OwnerBanner ownerBanner = iOwnerBannerDao.getOwnerBanner(dataCriteria);
		int preSequence = preOwnerBanner.getSequence();
		int sequence = ownerBanner.getSequence();
		dataCriteria.setParam("bannerId",preBannerId);
		dataCriteria.setParam("sequence",sequence);
		iOwnerBannerDao.updateOwnerBanner(dataCriteria);
		dataCriteria.setParam("bannerId",bannerId);
		dataCriteria.setParam("sequence",preSequence);
		iOwnerBannerDao.updateOwnerBanner(dataCriteria);
		
	}
	@Override
	public void updateOwnerBanner(OwnerBanner ownerBanner) {
		ownerBanner.setUpdateBy(getCurrentOperator());
		iOwnerBannerDao.updateOwnerBanner(ownerBanner);
	}

}
