package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.CustProdPrice;
import com.etaoguan.wea.vo.ProdPrice;

public interface IProdPriceService {
	
	public void saveProdPrice(ProdPrice prodPrice);
	
	public void updateProdPrice(String prodNum,double prodPrice);
	
	public void updateCustProdPrice(String prodNum,String custNum,double prodPrice);

	public boolean existsProdPrice(String prodNum);
	
	public void delProdPrice(String prodNum);
	
	public void saveCustProdPrice(CustProdPrice custProdPrice);
	
	public void updateCustProdPrice(CustProdPrice custProdPrice);
	
	public boolean existsCustProdPrice(String custNum,String prodNum);
	
	public void delCustProdPrice(String custNum,String prodNum);
	
	public void delCustProdPrice(String prodNum);
	
	public CustProdPrice getCustFinalProdPrice(String custNum,String prodNum);
	
	public List<CustProdPrice> getCustFinalProdPriceList(String custNum);
	
	@SuppressWarnings("rawtypes")
	public DataSet listProdPrices(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	@SuppressWarnings("rawtypes")
	public DataSet listCustProdPrices(DataCriteria dataCriteria,OffsetRequest offsetRequest);
}
