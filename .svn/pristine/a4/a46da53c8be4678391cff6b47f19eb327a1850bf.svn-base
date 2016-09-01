package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.ISettleInvDao;
import com.etaoguan.wea.vo.ProdQty;
import com.ibatis.sqlmap.client.SqlMapClient;
@Repository
public class SettleInvDao extends SpringBaseDao implements ISettleInvDao{

	@Override
	@Resource(name="cashInvSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public double getSettleInvPriceDelta(DataCriteria dataCriteria) {
		
		return (Double)this.getSqlMapClientTemplate().queryForObject("getSettleInvPriceDelta", dataCriteria.getParams());

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProdQty> getSettleInvProdDelta(DataCriteria dataCriteria) {

		return this.getSqlMapClientTemplate().queryForList("getSettleInvProdDelta", dataCriteria.getParams());
	}

}
