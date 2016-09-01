package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.Owner;

public interface IOwnerService {
	
	@SuppressWarnings("rawtypes")
	public DataSet listOwners(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public String addOwner(Owner owner);
	
	public String addExtSysOwner(Owner owner);
	
	public void updateOwner(Owner owner);
	
	public void updateOwner2ActiveStatus(String ownerNum);
	
	/**
	 * @param ownerNum 暂停企业服务
	 */
	public void updateOwner2InactiveStatus(String ownerNum);
	
	/**
	 * @param ownerNum 恢复企业服务
	 */
	public void stratOwner2InactiveStatus(String ownerNum);
	
	public void updateOwner2delStatus(String ownerNum);
	
	public boolean isActiveOwner(String ownerNum);
	
	public Owner getOwner(String ownerNum);
	
	public List<Owner> getAllOwner();
	
	public void updateOwnerShopNum(String ownerNum,String shopNum);
	
	public String getRandomOwnerShopNum();

}
