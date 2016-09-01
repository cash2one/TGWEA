package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IAlipayKeysDao;
import com.etaoguan.wea.vo.AlipayKeys;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli
 * 客户支付宝的key
 */
@Repository
public class AlipayKeysDao extends SpringBaseDao implements IAlipayKeysDao{

	@Override
	@Resource(name="paymentSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	/* (non-Javadoc)添加客户支付宝的key
	 * @see com.etaoguan.wea.dao.IAlipayKeysDao#addAlipayKeys(com.etaoguan.wea.vo.AlipayKeys)
	 */
	@Override
	public void addAlipayKeys(AlipayKeys alipayKeys) {
		this.getSqlMapClientTemplate().insert("addAlipayKeys", alipayKeys);
	}

	/* (non-Javadoc)删除客户支付宝的key
	 * @see com.etaoguan.wea.dao.IAlipayKeysDao#deleteAlipayKeys(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public void deleteAlipayKeys(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteAlipayKeys", dataCriteria.getParams());
	}

	/* (non-Javadoc)修改客户支付宝的key
	 * @see com.etaoguan.wea.dao.IAlipayKeysDao#updateAlipaykeys(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public void updateAlipaykeys(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateAlipaykeys", dataCriteria.getParams());
	}

	/* (non-Javadoc)客户支付宝的key的列表
	 * @see com.etaoguan.wea.dao.IAlipayKeysDao#alipayKeysDataSet(com.etaoguan.wea.common.DataCriteria, com.etaoguan.wea.common.OffsetRequest)
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet alipayKeysDataSet(DataCriteria dataCriteria, OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();

		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("alipayKeysCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<AlipayKeys> aKeys = this.getSqlMapClientTemplate().queryForList("alipayKeysDatSet", params);
		
		DataSet<AlipayKeys> dataSet = new DataSet<AlipayKeys>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(aKeys);
		return dataSet;
	}

	/* (non-Javadoc) 根据owenrNum 获取用户的partner
	 * @see com.etaoguan.wea.dao.IAlipayKeysDao#alipayKeysInformation(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public AlipayKeys alipayKeysInformation(DataCriteria dataCriteria) {
		return (AlipayKeys) this.getSqlMapClientTemplate().queryForObject("alipayKeysInformation", dataCriteria.getParams());
	}
	
	
}
