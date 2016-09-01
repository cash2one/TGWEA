package com.etaoguan.wea.service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.AndroidSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.vo.AppAndroidVersion;

/**
 * @author cunli
 * 安卓版本 业务接口
 */
public interface IAddAndroidversionService {
	
	/**
	 * @param ownerNum
	 * @param versionNum
	 * @return 获取同一个公司的最大版本号，确定是否更新
	 */
	public boolean getMaxvstoUpdate(String ownerNum,int versionNum);
	/**
	 * @return 获得最大的安卓版本号
	 */
	public int getMaxVersionNumService(AppAndroidVersion androidVersion);

	/**添加版本信息
	 * @param appAndroidVersion
	 */
	public void addandroidversion(AppAndroidVersion appAndroidVersion);
	/**删除版本信息
	 * @param versionId
	 */
	public void delandroidversoin(int versionId);
	/**更新版本信息
	 * @param appAndroidVersion
	 */
	public void updateandroidversoin(AppAndroidVersion appAndroidVersion);
	/**
	 * @return 版本信息列表
	 */
	@SuppressWarnings("rawtypes")
	public WPage getAndroidvs(AndroidSearch androidSearch,SortParam sortParam, WPagingRequest wpagingRequest);
	/**
	 * @param versionId
	 * @return 更新版本信息之前的初始化信息
	 */
	public AppAndroidVersion getAndrodivsbyId(AppAndroidVersion androidVersion);
}
