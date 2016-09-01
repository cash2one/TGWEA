package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IAppleVersionDao;
import com.etaoguan.wea.vo.AppleVersion;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli
 * 苹果版本 数据接口实现类 
 */
@Repository
public class AppleVersionDao extends SpringBaseDao implements IAppleVersionDao{

	@Override
	@Resource(name="appleversionSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	/* (non-Javadoc)添加版本
	 * @see com.etaoguan.wea.dao.IAppleVersionDao#addappleversion(com.etaoguan.wea.vo.AppleVersion)
	 */
	@Override
	public void addappleversion(AppleVersion appleVersion) {
		this.getSqlMapClientTemplate().insert("createAppleVs", appleVersion);
		
	}

	/* (non-Javadoc) 删除版本
	 * @see com.etaoguan.wea.dao.IAppleVersionDao#delappleversoin(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public void delappleversoin(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delAppleVs", dataCriteria.getParams());
		
	}

	/* (non-Javadoc)修改版本
	 * @see com.etaoguan.wea.dao.IAppleVersionDao#updateappleversoin(com.etaoguan.wea.vo.AppleVersion)
	 */
	@Override
	public void updateappleversoin(AppleVersion appleVersion) {
		this.getSqlMapClientTemplate().update("changeAppleVs", appleVersion);
	}

	/* (non-Javadoc)更新版本信息之前的初始化信息
	 * @see com.etaoguan.wea.dao.IAppleVersionDao#getAppleVersionById(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public AppleVersion getAppleVersionById(DataCriteria dataCriteria) {
		return (AppleVersion)this.getSqlMapClientTemplate().queryForObject("getApplevsbyid", dataCriteria.getParams());
	}

	/* (non-Javadoc)查看所有版本
	 * @see com.etaoguan.wea.dao.IAppleVersionDao#getAppleVersions(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getAppleVersions(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();

		Integer count = (Integer) this.getSqlMapClientTemplate()
				.queryForObject("getApplePageCount", params);

		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<AppleVersion> androidList = this.getSqlMapClientTemplate()
				.queryForList("getApplevs", params);

		DataSet<AppleVersion> dataSet = new DataSet<AppleVersion>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(androidList);
		return dataSet;
	}

	/* (non-Javadoc)APP发布管理 列表
	 * @see com.etaoguan.wea.dao.IAppleVersionDao#getVersions()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<AppleVersion> getVersions() {
		return this.getSqlMapClientTemplate().queryForList("appversions");
	}

	/* (non-Javadoc)获取某个用户最大的版本（最后一次添加的）
	 * @see com.etaoguan.wea.dao.IAppleVersionDao#getAppleMaxCsbyon(com.etaoguan.wea.vo.AppleVersion)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public String getAppleMaxVersionDao(DataCriteria dataCriteria) {
		Map params = dataCriteria.getParams();
		return (String) this.getSqlMapClientTemplate().queryForObject("getAppleMaxVersion",params);
	}

}
