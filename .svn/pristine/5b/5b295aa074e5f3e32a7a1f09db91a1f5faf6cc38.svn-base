package com.etaoguan.wea.client.web.service;

import java.io.IOException;
import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.ImgNode;
import com.etaoguan.wea.client.web.vo.OwnerSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.service.IOwnerService;
import com.etaoguan.wea.vo.Owner;

public interface IWOwnerService extends  IOwnerService{
	
	@SuppressWarnings("rawtypes")
	public Map getEditOwnerInitData(String ownerNum);
	
	public ImgNode genOwnerTmpImgFile(FileGenRequest fileGenRequest, String ownerNum) throws IOException;
	
	public void saveOrUpdateOwner(Owner owner,ImgNode imgNode);
	
	@SuppressWarnings("rawtypes")
	public WPage listSearchOwners(OwnerSearch ownerSearch,SortParam sortParam, WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public WPage listOwners(OwnerSearch ownerSearch,SortParam sortParam, WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getListOwnersSearchInitData();
	
	/**
	 * @param ownerNums 暂停企业服务
	 */
	public void updateBatchSuspendOwner(String[] ownerNums);
	/**
	 * @param ownerNums 恢复企业服务
	 */
	public void updateStartSuspendOwner(String[] ownerNums);
	
	public void delBatchOwner(String[] ownerNums);
}
