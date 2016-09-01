package com.etaoguan.wea.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IProdPriceDao;
import com.etaoguan.wea.service.IProdPriceService;
import com.etaoguan.wea.service.IProductService;
import com.etaoguan.wea.vo.CustProdPrice;
import com.etaoguan.wea.vo.ProdPrice;

@Service("prodPriceService")
public class ProdPriceService  extends BaseService implements IProdPriceService {

	@Autowired
	private IProdPriceDao iProdPriceDao;
	
	@Resource(name="productService")
	private IProductService iProductService;
	
	@Override
	public void delCustProdPrice(String custNum, String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum",custNum);
		dataCriteria.setParam("prodNum",prodNum);
		iProdPriceDao.delCustProdPrice(dataCriteria);

	}

	@Override
	public void delProdPrice(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		iProdPriceDao.delProdPrice(dataCriteria);
		iProductService.updateProdStdPrice(prodNum, 0);

	}

	@Override
	public boolean existsCustProdPrice(String custNum, String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum",custNum);
		dataCriteria.setParam("prodNum",prodNum);
		if(iProdPriceDao.getCustProdPrice(dataCriteria)==null){
			return false;
		}
		return true;
	}

	@Override
	public boolean existsProdPrice(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		if(iProdPriceDao.getProdPrice(dataCriteria)==null){
			return false;
		}
		return true;
	}

	@Override
	public CustProdPrice getCustFinalProdPrice(String custNum, String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("custNum",custNum);
		return iProdPriceDao.getCustFinalProdPrice(dataCriteria);
	}

	@Override
	public List<CustProdPrice> getCustFinalProdPriceList(String custNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum",custNum);
		return iProdPriceDao.getCustFinalProdPriceList(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listCustProdPrices(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iProdPriceDao.getCustProdPrices(dataCriteria, offsetRequest);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listProdPrices(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iProdPriceDao.getProdPrices(dataCriteria, offsetRequest);
	}
	
	@Override
	public void saveCustProdPrice(CustProdPrice custProdPrice) {
		custProdPrice.setCreateBy(getCurrentOperator());
		custProdPrice.setUpdateBy(getCurrentOperator());
		iProdPriceDao.saveCustProdPrice(custProdPrice);
		
	}

	@Override
	public void saveProdPrice(ProdPrice prodPrice) {
		prodPrice.setCreateBy(getCurrentOperator());
		prodPrice.setUpdateBy(getCurrentOperator());
		iProdPriceDao.saveProdPrice(prodPrice);	
		iProductService.updateProdStdPrice(prodPrice.getProdNum(),prodPrice.getProdPrice());
	}

	@Override
	public void updateCustProdPrice(CustProdPrice custProdPrice) {
		custProdPrice.setUpdateBy(getCurrentOperator());
		iProdPriceDao.updateCustProdPrice(custProdPrice);
		
	}

	@Override
	public void updateProdPrice(String prodNum,double prodPrice) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("prodPrice",prodPrice);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProdPriceDao.updateProdPrice(dataCriteria);
		iProductService.updateProdStdPrice(prodNum,prodPrice);
	}

	@Override
	public void delCustProdPrice(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		iProdPriceDao.delCustProdPrice(dataCriteria);

	}

	@Override
	public void updateCustProdPrice(String prodNum, String custNum,
			double prodPrice) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("custNum",custNum);
		dataCriteria.setParam("prodPrice",prodPrice);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProdPriceDao.updateCustProdPrice(dataCriteria);
		
	}

}
