package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IProdCatDao;
import com.etaoguan.wea.vo.ProdCat;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ProdCatDao extends SpringBaseDao implements IProdCatDao{

	@Override
	@Resource(name="prodSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addProdCat(ProdCat prodCat) {
		this.getSqlMapClientTemplate().insert("createProdCat", prodCat);
		
	}

	@Override
	public void delProdCat(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteProdCat", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getProdCatIds(DataCriteria dataCriteria) {
		
		return this.getSqlMapClientTemplate().queryForList("getProdCatIdList", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProdCat> getProdCats(DataCriteria dataCriteria) {
		
		return this.getSqlMapClientTemplate().queryForList("getProdCatList", dataCriteria.getParams());
	}

	@Override
	public int getProdCatCount(DataCriteria dataCriteria) {
	
		return (Integer) this.getSqlMapClientTemplate().queryForObject("getProdCatCount", dataCriteria.getParams());
	}

	@Override
	public void updateProdCat(ProdCat prodCat) {
		this.getSqlMapClientTemplate().update("updateProdCat", prodCat);
		
	}

	@Override
	public ProdCat getProdCatById(DataCriteria dataCriteria) {
		return (ProdCat) this.getSqlMapClientTemplate().queryForObject("getProdCatById", dataCriteria.getParams());
	}

}
