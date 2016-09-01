package com.etaoguan.wea.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.dao.IOwnerDao;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IOwnerService;
import com.etaoguan.wea.vo.Owner;

@Service("ownerService")
public class OwnerService  extends BaseService implements IOwnerService {

	@Autowired
	private IOwnerDao iOwnerDao;
	
	@Resource(name="ownerKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	@Override
	public String addOwner(Owner owner) {
		owner.setCreateBy(getCurrentOperator());
		owner.setUpdateBy(getCurrentOperator());
		String ownerNum = iKeyGenService.saveNGetKey();
		owner.setOwnerNum(ownerNum);
		iOwnerDao.addOwner(owner);
		return ownerNum;

	}
	
	@Override
	public String addExtSysOwner(Owner owner){
		
		owner.setCreateBy(getCurrentOperator());
		owner.setUpdateBy(getCurrentOperator());
		iOwnerDao.addOwner(owner);
		return owner.getOwnerNum();
	}

	@Override
	public Owner getOwner(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iOwnerDao.getOwner(dataCriteria);
	}

	@Override
	public boolean isActiveOwner(String ownerNum) {
		Owner owner = getOwner(ownerNum);
		if(owner!=null&&owner.getActiveFlag()==1){
			return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listOwners(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {

		return iOwnerDao.getOwnerDataSet(dataCriteria, offsetRequest);
	}

	@Override
	public void updateOwner(Owner owner) {
		iOwnerDao.updateOwner(owner);

	}

	@Override
	public void updateOwner2ActiveStatus(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("activeFlag",1);
		iOwnerDao.updateOwner(dataCriteria);
	}

	/* (non-Javadoc) 暂停企业服务
	 * @see com.etaoguan.wea.service.IOwnerService#updateOwner2InactiveStatus(java.lang.String)
	 */
	@Override
	public void updateOwner2InactiveStatus(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("activeFlag",0);
		iOwnerDao.updateOwner(dataCriteria);

	}
	
	/* (non-Javadoc) 恢复企业服务
	 * @see com.etaoguan.wea.service.IOwnerService#stratOwner2InactiveStatus(java.lang.String)
	 */
	@Override
	public void stratOwner2InactiveStatus(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("activeFlag",1);
		iOwnerDao.updateOwner(dataCriteria);
		
	}

	@Override
	public void updateOwner2delStatus(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("delFlag",1);
		iOwnerDao.updateOwner(dataCriteria);
		
	}

	@Override
	public List<Owner> getAllOwner() {
		DataCriteria dataCriteria = new DataCriteria();
		return iOwnerDao.getAllOwner(dataCriteria);
	}

	@Override
	public void updateOwnerShopNum(String ownerNum, String shopNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("shopNum",shopNum);
		if(iOwnerDao.getExistShopCount(dataCriteria)==0){
			iOwnerDao.updateOwnerShopNum(dataCriteria);
			WeaDataCache.getCache().getOwnerShopNumMap().put(shopNum, ownerNum);
		}else{
			
			throw new WeaException("店铺编号已存在");
		}
		
	}

	@Override
	public String getRandomOwnerShopNum() {
		DataCriteria dataCriteria = new DataCriteria();
		return iOwnerDao.getRandomOwnerShopNum(dataCriteria);
	}

	

}
