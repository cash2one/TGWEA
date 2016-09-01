package com.etaoguan.wea.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IProdStockDao;
import com.etaoguan.wea.service.IProdStockService;
import com.etaoguan.wea.vo.ProdQty;
import com.etaoguan.wea.vo.ProdStock;
import com.etaoguan.wea.vo.ProdStockDelta;
import com.etaoguan.wea.vo.StockTrace;

@Service("prodStockService")
public class ProdStockService  extends BaseService implements IProdStockService {

	@Autowired
	private IProdStockDao iProdStockDao;
	
	@Override
	public void addProdStockTrace(StockTrace stockTrace) {
		iProdStockDao.addProdStockTrace(stockTrace);

	}

	@Override
	public void addProdStockTraces(List<StockTrace> stockTraceList) {
		
		for(StockTrace stockTrace:stockTraceList){
			iProdStockDao.addProdStockTrace(stockTrace);
		}

	}

	@Override
	public synchronized void updateAllotProdStock(ProdStockDelta fromProdStockDelta,
			ProdStockDelta toProdStockDelta) {

		updateReduceStock(fromProdStockDelta);
		updateRaiseStock(toProdStockDelta);
		
	}
	
	
	@Override
	public Map<String, ProdStock> getProdStockMap(String whNum,
			String ownerNum) {
		List<ProdStock> prodStockList = getProdStockList(whNum,ownerNum);
		Map<String,ProdStock> prodStockMap = new HashMap<String,ProdStock>();
		for(ProdStock prodStock:prodStockList){
			prodStockMap.put(prodStock.getProdNum(), prodStock);
		}
		return prodStockMap;
	}
	

	@Override
	@SuppressWarnings("rawtypes")
	public Map<String, ProdStock> getProdStockMap(String whNum,
			String ownerNum, List prodNums) {
		List<ProdStock> prodStockList = getProdStockList(whNum,ownerNum,prodNums);
		Map<String,ProdStock> prodStockMap = new HashMap<String,ProdStock>();
		for(ProdStock prodStock:prodStockList){
			prodStockMap.put(prodStock.getProdNum()+prodStock.getDifferName(), prodStock);
		}
		return prodStockMap;
	}
	
	@Override
	public boolean existsProdStock(String whNum, String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("whNum",whNum);
		dataCriteria.setParam("ownerNum",ownerNum);
		if(iProdStockDao.getProdStockCount(dataCriteria)==0){
			return false;
		}
		return true;
	}

	@Override
	public ProdStock getProdStock(String whNum, String ownerNum, String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("whNum",whNum);
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("prodNum",prodNum);
		return iProdStockDao.getProdStock(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List<ProdStock> getProdStockList(String whNum, String ownerNum,
			List prodNums) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("whNum",whNum);
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("prodNums",prodNums);
		return iProdStockDao.getProdStockList(dataCriteria);
	}

	@Override
	public List<ProdStock> getProdStockList(String whNum, String ownerNum) {
		
		return getProdStockList(whNum,ownerNum,null);
	}
	@Override
	public boolean haveEnoughProdStock(String whNum, String ownerNum,
			ProdQty prodQty) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("whNum",whNum);
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("prodNum",prodQty.getProdNum());
		ProdStock prodStock = iProdStockDao.getProdStock(dataCriteria);
		if(prodStock.getCases()>prodQty.getCases()){
			return true;
		}
		return false;
	}

	@Override
	public boolean haveEnoughProdStocks(String whNum, String ownerNum,
			List<ProdQty> prodQtyList) {
		List<String> prodNums = getProdNums(prodQtyList);
		Map<String,ProdStock> prodStockMap = getProdStockMap(whNum,ownerNum,prodNums);
		ProdStock prodStock;
		for(ProdQty prodQty:prodQtyList){
			prodStock = prodStockMap.get(prodQty.getProdNum()+prodQty.getDifferName());
			if(prodStock==null||prodStock.getCases()<prodQty.getCases()){
				return false;
			}
		}
		return true;
	}
	
	private List<String> getProdNums(List<ProdQty> prodQtyList){
		List<String> prodNums = new ArrayList<String>();
		for(ProdQty prodQty:prodQtyList){
			prodNums.add(prodQty.getProdNum());
		}
		return prodNums;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listProdStock(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {

		return iProdStockDao.getProdStocks(dataCriteria, offsetRequest);
	}

	@Override
	public void updateBatchRaiseStock(List<ProdStockDelta> prodStockDeltaList) {
		
		for(ProdStockDelta prodStockDelta:prodStockDeltaList){
			updateRaiseStock(prodStockDelta);
		}

	}

	@Override
	public void updateBatchReduceStock(List<ProdStockDelta> prodStockDeltaList) {
		for(ProdStockDelta prodStockDelta:prodStockDeltaList){
			updateReduceStock(prodStockDelta);
		}

	}

	@Override
	public void updateRaiseStock(ProdStockDelta prodStockDelta) {
		List<String> prodNums = getProdNums(prodStockDelta.getProdQtyList());
		Map<String,ProdStock> prodStockMap = getProdStockMap(prodStockDelta.getWhNum(),prodStockDelta.getOwnerNum(),prodNums);
		ProdStock prodStock;
		StockTrace stockTrace = new StockTrace();
		stockTrace.setWhNum(prodStockDelta.getWhNum());
		stockTrace.setWhName(prodStockDelta.getWhName());
		stockTrace.setOwnerNum(prodStockDelta.getOwnerNum());
		stockTrace.setReferModule(prodStockDelta.getReferModule());
		stockTrace.setReferNum(prodStockDelta.getReferNum());
		stockTrace.setCreateBy(getCurrentOperator());
		stockTrace.setUpdateBy(getCurrentOperator());
		for(ProdQty prodQty:prodStockDelta.getProdQtyList()){
			prodStock = prodStockMap.get(prodQty.getProdNum()+prodQty.getDifferName());
			if(prodStock==null){
				prodStock = new ProdStock();
				prodStock.setOwnerNum(prodStockDelta.getOwnerNum());
				prodStock.setWhNum(prodStockDelta.getWhNum());
				prodStock.setProdNum(prodQty.getProdNum());
				prodStock.setDifferName(prodQty.getDifferName());
				prodStock.setSku(0);
				prodStock.setCases(prodQty.getCases());
				prodStock.setPieces(prodQty.getPieces());
				iProdStockDao.addProdStock(prodStock);
				
			}else{
				prodStock.setCases(prodStock.getCases()+prodQty.getCases());
				prodStock.setPieces(prodStock.getPieces()+prodQty.getPieces());
				iProdStockDao.updateProdStock(prodStock);
			}

			stockTrace.setProdNum(prodQty.getProdNum());
			stockTrace.setProdName(prodQty.getProdName());
			stockTrace.setDifferName(prodQty.getDifferName());
			stockTrace.setDeltaCases(prodQty.getCases());
			stockTrace.setDeltaPieces(prodQty.getPieces());
			addProdStockTrace(stockTrace);
		}

	}

	@Override
	public void updateReduceStock(ProdStockDelta prodStockDelta) {
		List<String> prodNums = getProdNums(prodStockDelta.getProdQtyList());
		Map<String,ProdStock> prodStockMap = getProdStockMap(prodStockDelta.getWhNum(),prodStockDelta.getOwnerNum(),prodNums);
		ProdStock prodStock;
		StockTrace stockTrace = new StockTrace();
		stockTrace.setWhNum(prodStockDelta.getWhNum());
		stockTrace.setWhName(prodStockDelta.getWhName());
		stockTrace.setOwnerNum(prodStockDelta.getOwnerNum());
		stockTrace.setReferModule(prodStockDelta.getReferModule());
		stockTrace.setReferNum(prodStockDelta.getReferNum());
		stockTrace.setCreateBy(getCurrentOperator());
		stockTrace.setUpdateBy(getCurrentOperator());
		for(ProdQty prodQty:prodStockDelta.getProdQtyList()){
			prodStock = prodStockMap.get(prodQty.getProdNum()+prodQty.getDifferName());
			if(prodStock!=null){
				prodStock.setCases(prodStock.getCases()-prodQty.getCases());
				prodStock.setPieces(prodStock.getPieces()-prodQty.getPieces());
				iProdStockDao.updateProdStock(prodStock);
				
				stockTrace.setProdNum(prodQty.getProdNum());
				stockTrace.setProdName(prodQty.getProdName());
				stockTrace.setDifferName(prodQty.getDifferName());
				stockTrace.setDeltaCases(0-prodQty.getCases());
				stockTrace.setDeltaPieces(0-prodQty.getPieces());
				addProdStockTrace(stockTrace);
			}

		}

	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listStockTrace(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iProdStockDao.getStockTraces(dataCriteria, offsetRequest);
	}


}
