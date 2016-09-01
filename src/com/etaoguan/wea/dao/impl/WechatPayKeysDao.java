package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IWechatPayKeysDao;
import com.etaoguan.wea.vo.WechatPayKeys;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli 微信付款的key
 *
 */
@Repository
public class WechatPayKeysDao extends SpringBaseDao implements IWechatPayKeysDao{
	@Override
	@Resource(name="wechatpaySqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	/* (non-Javadoc)获取客户微信付款的key
	 * @see com.etaoguan.wea.dao.IWechatPayKeysDao#wechatPayKeysInformation(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public WechatPayKeys wechatPayKeysInformation(DataCriteria dataCriteria) {
		return (WechatPayKeys) this.getSqlMapClientTemplate().queryForObject("wechatPayKeysInformation", dataCriteria.getParams());
	}

	/* (non-Javadoc)添加微信key
	 * @see com.etaoguan.wea.dao.IWechatPayKeysDao#addWechatPayKeys(com.etaoguan.wea.vo.WechatPayKeys)
	 */
	@Override
	public void addWechatPayKeys(WechatPayKeys wechatPayKeys) {
		this.getSqlMapClientTemplate().insert("addWechatPayKeys", wechatPayKeys);
	}

	/* (non-Javadoc) 删除微信key
	 * @see com.etaoguan.wea.dao.IWechatPayKeysDao#deleteWechatPayKeys(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public void deleteWechatPayKeys(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteWechatPayKeys", dataCriteria.getParams());
	}

	/* (non-Javadoc) 更新微信key
	 * @see com.etaoguan.wea.dao.IWechatPayKeysDao#updateWechatPayKeys(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public void updateWechatPayKeys(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateWechatPayKeys", dataCriteria.getParams());
	}

	/* (non-Javadoc)微信key列表显示
	 * @see com.etaoguan.wea.dao.IWechatPayKeysDao#wechatPayKeysDataSet(com.etaoguan.wea.common.DataCriteria, com.etaoguan.wea.common.OffsetRequest)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public DataSet wechatPayKeysDataSet(DataCriteria dataCriteria, OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();

		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("wechatPayKeysCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<WechatPayKeys> aKeys = this.getSqlMapClientTemplate().queryForList("wechatPayKeysDatSet", params);
		
		DataSet<WechatPayKeys> dataSet = new DataSet<WechatPayKeys>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(aKeys);
		return dataSet;
	}
	

}
