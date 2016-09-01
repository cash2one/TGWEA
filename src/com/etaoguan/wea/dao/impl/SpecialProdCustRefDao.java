package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.ISpecialProdCustRefDao;
import com.etaoguan.wea.vo.SpecialProdCustRef;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli
 * 特供产品表
 */
@Repository
public class SpecialProdCustRefDao extends SpringBaseDao implements ISpecialProdCustRefDao{

	@Override
	@Resource(name="specialProdSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	/* (non-Javadoc)根据组名查询特供产品，获得属于某个人的特供产品列表
	 * @see com.etaoguan.wea.dao.ISpecialProdCustRefDao#specialprods(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet specialprods(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("specialprodsCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<SpecialProdCustRef> sProdCustRefs = this.getSqlMapClientTemplate().queryForList("specialprods", params);
		
		DataSet<SpecialProdCustRef> dataSet = new DataSet<SpecialProdCustRef>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(sProdCustRefs);
		return dataSet;
	}



}
