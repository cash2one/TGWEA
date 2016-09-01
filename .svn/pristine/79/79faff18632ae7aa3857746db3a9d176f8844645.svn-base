package com.etaoguan.wea.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.dao.IStkAllocInvDao;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IProdStockService;
import com.etaoguan.wea.service.IStkAllocInvService;
import com.etaoguan.wea.vo.ProdQty;
import com.etaoguan.wea.vo.ProdStockDelta;
import com.etaoguan.wea.vo.StockAllocateInvoice;
import com.etaoguan.wea.vo.StockAllocateInvoiceItem;

@Service("stkAllocInvService")
public class StkAllocInvService extends BaseService implements IStkAllocInvService{

	@Autowired
	IStkAllocInvDao iStkAllocInvDao;
	
	@Resource(name="stkAllocKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	@Resource(name="prodStockService")
	private IProdStockService iProdStockService;
	
	@Override
	public void addStkAllocInv(StockAllocateInvoice stkAllocInv) {
		if(stkAllocInv.getStkAllocInvItemList()==null||stkAllocInv.getStkAllocInvItemList().size()==0){
			throw new WeaException("无效的产品信息");
		}
		List<ProdQty> prodQtyList =  new ArrayList<ProdQty>();
		for(StockAllocateInvoiceItem stkAllocInvItem:stkAllocInv.getStkAllocInvItemList()){
			ProdQty prodQty = new ProdQty();
			prodQty.setProdNum(stkAllocInvItem.getProdNum());
			prodQty.setProdName(stkAllocInvItem.getProdName());
			prodQty.setDifferName(stkAllocInvItem.getDifferName());
			prodQty.setCases(stkAllocInvItem.getCases());
			prodQty.setPieces(stkAllocInvItem.getPieces());
			prodQtyList.add(prodQty);
		}
		if(!iProdStockService.haveEnoughProdStocks(stkAllocInv.getFromWhNum(),stkAllocInv.getOwnerNum(),prodQtyList)){
			
			throw new WeaException("指定仓库库存不足");
		}
		String stkAllocNum = iKeyGenService.saveNGetKey();
		stkAllocInv.setStkAllocNum(stkAllocNum);
		stkAllocInv.setCreateBy(getCurrentOperator());
		stkAllocInv.setUpdateBy(getCurrentOperator());
		iStkAllocInvDao.addStkAllocInv(stkAllocInv);

		for(StockAllocateInvoiceItem stkAllocInvItem:stkAllocInv.getStkAllocInvItemList()){
			stkAllocInvItem.setStkAllocNum(stkAllocNum);
			iStkAllocInvDao.addStkAllocInvItem(stkAllocInvItem);
		}

		
	}

	@Override
	public void saveStkAllocInvoiceItem(StockAllocateInvoiceItem stkAllocInvItem) {
		iStkAllocInvDao.addStkAllocInvItem(stkAllocInvItem);
		
	}

	@Override
	public void delStkAllocInv(String stkAllocNum) {
		if(havePutin2WH(stkAllocNum)){
			throw new WeaException("产品已入库");
		}
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("stkAllocNum",stkAllocNum);
		iStkAllocInvDao.delStkAllocInv(dataCriteria);
	}

	@Override
	public StockAllocateInvoice getStkAllocInv(String stkAllocNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("stkAllocNum",stkAllocNum);
		StockAllocateInvoice stkAllocInv = iStkAllocInvDao.getStkAllocInv(dataCriteria);
		List<StockAllocateInvoiceItem> stkAllocInvItems = iStkAllocInvDao.getStkAllocInvItems(dataCriteria);
		stkAllocInv.setStkAllocInvItemList(stkAllocInvItems);
		return stkAllocInv;
	}

	@Override
	public List<StockAllocateInvoiceItem> getStkAllocInvItems(String stkAllocNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("stkAllocNum",stkAllocNum);
		return iStkAllocInvDao.getStkAllocInvItems(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listStkAllocInvs(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		
		return iStkAllocInvDao.getStkAllocInvs(dataCriteria, offsetRequest);
	}

	@Override
	public void updateStkAllocInv(StockAllocateInvoice stkAllocInv) {
		if(stkAllocInv.getStkAllocInvItemList()==null||stkAllocInv.getStkAllocInvItemList().size()==0){
			throw new WeaException("无效的产品信息");
		}
		if(havePutin2WH(stkAllocInv.getStkAllocNum())){
			throw new WeaException("产品已入库");
		}
		stkAllocInv.setUpdateBy(getCurrentOperator());
		iStkAllocInvDao.updateStkAllocInv(stkAllocInv);
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("stkAllocNum",stkAllocInv.getStkAllocNum());
		iStkAllocInvDao.delStkAllocInvItem(dataCriteria);

		for(StockAllocateInvoiceItem stkAllocInvItem:stkAllocInv.getStkAllocInvItemList()){
			stkAllocInvItem.setStkAllocNum(stkAllocInv.getStkAllocNum());
			iStkAllocInvDao.addStkAllocInvItem(stkAllocInvItem);
		}
	
	}

	@Override
	public boolean havePutin2WH(String stkAllocNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("stkAllocNum",stkAllocNum);
		if(iStkAllocInvDao.getStkAllocInv(dataCriteria).getStkAllocStatus()==1){
			return true;
		}
		return false;
	}

	@Override
	public void saveStkAllocInvStockChange(String stkAllocNum) {
		StockAllocateInvoice stkAllocInv = getStkAllocInv(stkAllocNum);
		List<ProdQty> prodQtyList =  new ArrayList<ProdQty>();
		for(StockAllocateInvoiceItem stkAllocInvItem:stkAllocInv.getStkAllocInvItemList()){
			ProdQty prodQty = new ProdQty();
			prodQty.setProdNum(stkAllocInvItem.getProdNum());
			prodQty.setProdName(stkAllocInvItem.getProdName());
			prodQty.setDifferName(stkAllocInvItem.getDifferName());
			prodQty.setCases(stkAllocInvItem.getCases());
			prodQty.setPieces(stkAllocInvItem.getPieces());
			prodQtyList.add(prodQty);
		}
		ProdStockDelta prodStockDelta = new ProdStockDelta();
		prodStockDelta.setProdQtyList(prodQtyList);
		prodStockDelta.setOwnerNum(stkAllocInv.getOwnerNum());
		prodStockDelta.setWhNum(stkAllocInv.getToWhNum());
		prodStockDelta.setWhName(stkAllocInv.getToWhName());
		prodStockDelta.setReferNum(stkAllocInv.getStkAllocNum());
		prodStockDelta.setReferModule(WeaConstant.MODULE_STKALLOC);
		iProdStockService.updateRaiseStock(prodStockDelta);
		prodStockDelta.setWhNum(stkAllocInv.getFromWhNum());
		prodStockDelta.setWhName(stkAllocInv.getFromWhName());
		iProdStockService.updateReduceStock(prodStockDelta);
		
		updateStkAllocInv2Putin(stkAllocInv.getStkAllocNum());
		
	}

	@Override
	public void updateStkAllocInv2Putin(String stkAllocNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("stkAllocNum",stkAllocNum);
		dataCriteria.setParam("stkAllocStatus",1);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iStkAllocInvDao.updateStkAllocInv(dataCriteria);
	}


}
