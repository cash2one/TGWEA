package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IAndroidVersionDao;
import com.etaoguan.wea.vo.AppAndroidVersion;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli 安卓版本 数据接口实现类
 */
@Repository
public class AndroidVersionDao extends SpringBaseDao implements
		IAndroidVersionDao {

	@Override
	@Resource(name = "androidversionSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient) {

		super.setSqlMapClient(sqlMapClient);
	}

	/*
	 * (non-Javadoc) 添加版本
	 * 
	 * @see
	 * com.etaoguan.wea.dao.IAndroidVersionDao#addandroidversion(com.etaoguan
	 * .wea.vo.AppAndriodVersion)
	 */
	@Override
	public void addandroidversion(AppAndroidVersion appAndroidVersion) {
		this.getSqlMapClientTemplate().insert("createAndroidversionmethod",
				appAndroidVersion);
	}

	/*
	 * (non-Javadoc) 删除版本
	 * 
	 * @see
	 * com.etaoguan.wea.dao.IAndroidVersionDao#delandroidversoin(com.etaoguan
	 * .wea.vo.AppAndriodVersion)
	 */
	@Override
	public void delandroidversoin(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delAndroidvs",
				dataCriteria.getParams());

	}

	/*
	 * (non-Javadoc)修改版本
	 * 
	 * @see
	 * com.etaoguan.wea.dao.IAndroidVersionDao#updateandroidversoin(com.etaoguan
	 * .wea.vo.AppAndriodVersion)
	 */
	@Override
	public void updateandroidversoin(AppAndroidVersion appAndroidVersion) {
		this.getSqlMapClientTemplate().update("syncAndroidversoin",
				appAndroidVersion);

	}

	/*
	 * (non-Javadoc)查看所有版本
	 * 
	 * @see
	 * com.etaoguan.wea.dao.IAndroidVersionDao#getAndroidvs(com.etaoguan.wea
	 * .common.DataCriteria)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getAndroidvs(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();

		Integer count = (Integer) this.getSqlMapClientTemplate()
				.queryForObject("getAndroidPageCount", params);

		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<AppAndroidVersion> androidList = this.getSqlMapClientTemplate()
				.queryForList("getAndroidvs", params);

		DataSet<AppAndroidVersion> dataSet = new DataSet<AppAndroidVersion>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(androidList);
		return dataSet;
	}

	/*
	 * (non-Javadoc) 更新版本信息之前的初始化信息
	 * 
	 * @see
	 * com.etaoguan.wea.dao.IAndroidVersionDao#getAndroidvsbyId(com.etaoguan
	 * .wea.common.DataCriteria)
	 */
	@Override
	public AppAndroidVersion getAndroidvsbyId(DataCriteria dataCriteria) {
		return (AppAndroidVersion) this.getSqlMapClientTemplate()
				.queryForObject("getAndroidvsbyid", dataCriteria.getParams());
	}

	/*
	 * (non-Javadoc)查询最大的版本号
	 * 
	 * @see com.etaoguan.wea.dao.IAndroidVersionDao#getMaxVersionNum()
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public int getMaxVersionNum(DataCriteria dataCriteria) {
		Map params = dataCriteria.getParams();
		return (Integer) this.getSqlMapClientTemplate().queryForObject(
				"maxVersionNum", params);
	}

}
