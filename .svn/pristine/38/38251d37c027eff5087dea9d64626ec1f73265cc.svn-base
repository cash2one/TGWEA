package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.AppleVersion;

/**
 * @author cunli
 * 苹果版本 数据接口
 */
public interface IAppleVersionDao {
	/**
	 * @param appleVersion
	 * @return 获取某个用户最大的版本（最后一次添加的）
	 */
	public String getAppleMaxVersionDao(DataCriteria dataCriteria);
	/**添加版本信息
	 * @param appAndroidVersion
	 */
	public void addappleversion(AppleVersion appleVersion);
	/**删除版本信息
	 * @param dataCriteria
	 */
	public void delappleversoin(DataCriteria dataCriteria);
	/**更新版本信息
	 * @param appAndroidVersion
	 */
	public void updateappleversoin(AppleVersion appleVersion);
	/**
	 * @param dataCriteria
	 * @return 更新之前的初始化版本信息
	 */
	public AppleVersion getAppleVersionById(DataCriteria dataCriteria);
	/**
	 * @param dataCriteria
	 * @return 版本信息列表
	 */
	@SuppressWarnings("rawtypes")
	public DataSet getAppleVersions(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	/**
	 * @return APP发布管理 列表
	 */
	public List<AppleVersion> getVersions();
	
}
