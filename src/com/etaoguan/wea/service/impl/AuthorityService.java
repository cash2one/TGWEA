package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IAuthorityDao;
import com.etaoguan.wea.service.IAuthorityService;
import com.etaoguan.wea.vo.Authority;

@Service("authorityService")
public class AuthorityService extends BaseService implements IAuthorityService{

	@Autowired
	private IAuthorityDao iAuthorityDao;

	@Override
	public void saveAuthority(Authority authority) {
		iAuthorityDao.insertAuthority(authority);
		
	}

	@Override
	public void removeAuthority(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		iAuthorityDao.deleteAuthority(dataCriteria);
	}

	@Override
	public Authority lookAuthority(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		return iAuthorityDao.selectAuthority(dataCriteria);
	}

}
