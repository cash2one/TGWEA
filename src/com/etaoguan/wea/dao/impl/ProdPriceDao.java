package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IProdPriceDao;
import com.etaoguan.wea.vo.CustProdPrice;
import com.etaoguan.wea.vo.ProdPrice;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ProdPriceDao extends SpringBaseDao implements IProdPriceDao{

	@Override
	@Resource(name="prodSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void delCustProdPrice(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delCustProdPrice", dataCriteria.getParams());
		
	}

	@Override
	public void delProdPrice(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delProdPrice", dataCriteria.getParams());
		
	}

	@Override
	public CustProdPrice getCustFinalProdPrice(DataCriteria dataCriteria) {
		return (CustProdPrice)this.getSqlMapClientTemplate().queryForObject("getCustFinalProdPrice", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CustProdPrice> getCustFinalProdPriceList(
			DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getCustFinalProdPriceList", dataCriteria.getParams());
	}

	@Override
	public CustProdPrice getCustProdPrice(DataCriteria dataCriteria) {
		return (CustProdPrice)this.getSqlMapClientTemplate().queryForObject("getCustProdPrice", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet getCustProdPrices(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getCustProdPriceCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<CustProdPrice> custProdPriceList = this.getSqlMapClientTemplate().queryForList("getCustProdPriceDatSet", params);
		
		DataSet<CustProdPrice> dataSet = new DataSet<CustProdPrice>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(custProdPriceList);
		return dataSet;
	}

	@Override
	public ProdPrice getProdPrice(DataCriteria dataCriteria) {
		return (ProdPrice)this.getSqlMapClientTemplate().queryForObject("getProdPrice", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getProdPrices(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getProdPriceCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<ProdPrice> custProdPriceList = this.getSqlMapClientTemplate().queryForList("getProdPriceDatSet", params);
		
		DataSet<ProdPrice> dataSet = new DataSet<ProdPrice>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(custProdPriceList);
		return dataSet;
	}

	@Override
	public void saveCustProdPrice(CustProdPrice custProdPrice) {
		this.getSqlMapClientTemplate().insert("createCustProdPrice", custProdPrice);
		
	}

	@Override
	public void saveProdPrice(ProdPrice prodPrice) {
		this.getSqlMapClientTemplate().insert("createProdPrice", prodPrice);
		
	}

	@Override
	public void updateCustProdPrice(CustProdPrice custProdPrice) {
		this.getSqlMapClientTemplate().update("updateCustProdPrice",custProdPrice);
		
	}

	@Override
	public void updateProdPrice(ProdPrice prodPrice) {
		this.getSqlMapClientTemplate().update("updateProdPrice",prodPrice);
		
	}

	@Override
	public void updateCustProdPrice(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateCustProdPriceByMap",dataCriteria.getParams());
		
	}

	@Override
	public void updateProdPrice(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateProdPriceByMap",dataCriteria.getParams());
		
	}

}
