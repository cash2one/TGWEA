package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.AppleSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.vo.AppleVersion;

/**
 * @author cunli
 * 苹果版本 业务接口
 */
public interface IAppleVersionService {
	/**
	 * @param ownerNum
	 * @param versionNum
	 * @return 确定是否更新
	 */
	public boolean getAppleMaxVersionService(String ownerNum,String versionNum);

	/**添加版本信息
	 * @param appAndroidVersion
	 */
	public void addAppleVs(AppleVersion appleVersion);
	/**删除版本信息
	 * @param versionId
	 */
	public void delAppleVs(int versionId);
	/**更新版本信息
	 * @param appAndroidVersion
	 */
	public void updateAppleVs(AppleVersion appleVersion);
	/**
	 * @return 版本信息列表
	 */
	@SuppressWarnings("rawtypes")
	public WPage getAppleVersions(AppleSearch appleSearch,SortParam sortParam, WPagingRequest wpagingRequest);
	/**
	 * @param versionId
	 * @return 更新版本信息之前的初始化信息
	 */
	public AppleVersion getAppleVersionById(AppleVersion appleVersion);
	/**
	 * @return APP发布管理 列表
	 */
	public List<AppleVersion> getVersionsService();
}
