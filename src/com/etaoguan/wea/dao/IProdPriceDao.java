package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.CustProdPrice;
import com.etaoguan.wea.vo.ProdPrice;

public interface IProdPriceDao {
	
	public void saveProdPrice(ProdPrice prodPrice);
	
	public void updateProdPrice(ProdPrice prodPrice);
	
	public void updateProdPrice(DataCriteria dataCriteria);

	public ProdPrice getProdPrice(DataCriteria dataCriteria);
	
	public void delProdPrice(DataCriteria dataCriteria);
	
	public void saveCustProdPrice(CustProdPrice custProdPrice);
	
	public void updateCustProdPrice(CustProdPrice custProdPrice);
	
	public void updateCustProdPrice(DataCriteria dataCriteria);
	
	public CustProdPrice getCustProdPrice(DataCriteria dataCriteria);
	
	public void delCustProdPrice(DataCriteria dataCriteria);
	
	public CustProdPrice getCustFinalProdPrice(DataCriteria dataCriteria);
	
	public List<CustProdPrice> getCustFinalProdPriceList(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getProdPrices(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	@SuppressWarnings("rawtypes")
	public DataSet getCustProdPrices(DataCriteria dataCriteria,OffsetRequest offsetRequest);
}
