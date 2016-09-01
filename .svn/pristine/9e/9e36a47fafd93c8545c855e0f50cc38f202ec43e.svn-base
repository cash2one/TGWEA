package com.etaoguan.wea.dao;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.AppAndroidVersion;

/**
 * @author cunli
 * 安卓版本 数据接口
 */
public interface IAndroidVersionDao {
	/**
	 * @return 获得最大的安卓版本号
	 */
	public int getMaxVersionNum(DataCriteria dataCriteria);
	/**添加版本信息
	 * @param appAndroidVersion
	 */
	public void addandroidversion(AppAndroidVersion appAndroidVersion);
	/**删除版本信息
	 * @param dataCriteria
	 */
	public void delandroidversoin(DataCriteria dataCriteria);
	/**更新版本信息
	 * @param appAndroidVersion
	 */
	public void updateandroidversoin(AppAndroidVersion appAndroidVersion);
	/**
	 * @param dataCriteria
	 * @return 更新之前的初始化版本信息
	 */
	public AppAndroidVersion getAndroidvsbyId(DataCriteria dataCriteria);
	/**
	 * @param dataCriteria
	 * @return 版本信息列表
	 */
	@SuppressWarnings("rawtypes")
	public DataSet getAndroidvs(DataCriteria dataCriteria,OffsetRequest offsetRequest);
}
