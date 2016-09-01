package com.etaoguan.wea.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.dao.IDeliverInvDao;
import com.etaoguan.wea.service.IDeliverInvService;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IOrderService;
import com.etaoguan.wea.service.IProdStockService;
import com.etaoguan.wea.service.IWareHouseService;
import com.etaoguan.wea.vo.DeliverInvlogistics;
import com.etaoguan.wea.vo.DeliverInvoice;
import com.etaoguan.wea.vo.DeliverInvoiceItem;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.OrderItem;
import com.etaoguan.wea.vo.ProdQty;
import com.etaoguan.wea.vo.ProdStockDelta;
import com.etaoguan.wea.vo.WareHouse;

@Service("deliverInvService")
public class DeliverInvService  extends BaseService implements IDeliverInvService {

	@Autowired
	private IDeliverInvDao iDeliverInvDao;
	
	@Resource(name="orderService")
	private IOrderService iOrderService;
	
	@Resource(name="prodStockService")
	private IProdStockService iProdStockService;
	
	@Resource(name="wareHouseService")
	private IWareHouseService iWareHouseService;
	
	@Resource(name="deliverKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	@Override
	public void addGenDeliverInvByOrderNum(String orderNum) {
		if(existsDeliverInv(orderNum)){
			
			throw new WeaException("出库单已存在");
		}
		String deliverNum = iKeyGenService.saveNGetKey();
		DeliverInvoice deliverInv = new DeliverInvoice();
		deliverInv.setDeliverNum(deliverNum);
		Order order = iOrderService.getOrder(orderNum);
		deliverInv.setCustNum(order.getCustNum());
		deliverInv.setOwnerNum(order.getOwnerNum());
		deliverInv.setReferOrderNum(order.getOrderNum());
		deliverInv.setCreateBy(getCurrentOperator());
		deliverInv.setUpdateBy(getCurrentOperator());
		iDeliverInvDao.addDeliverInv(deliverInv);
		for(OrderItem orderItem:order.getOrderItemList()){
			DeliverInvoiceItem deliverInvItem = new DeliverInvoiceItem();
			deliverInvItem.setDeliverNum(deliverNum);
			deliverInvItem.setProdNum(orderItem.getProdNum());
			deliverInvItem.setProdName(orderItem.getProdName());
			deliverInvItem.setDifferName(orderItem.getDifferName());
			deliverInvItem.setUnit(orderItem.getUnit());
			deliverInvItem.setCases(orderItem.getCases());
			iDeliverInvDao.addDeliverInvItem(deliverInvItem);
		}
		iOrderService.updateOrder2DeliverUnPuton(orderNum);
	}

	@Override
	public void delDeliverInv(String deliverNum) {
		DeliverInvoice deliverInv = getDeliverInvHeader(deliverNum);
		if(deliverInv.getDeliverWhStatus()==WeaConstant.DELIVERINV_PUTONSTATUS_PUTON){
			throw new WeaException("送货单已出库");
		}
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("deliverNum",deliverNum);
		iDeliverInvDao.delDeliverInv(dataCriteria);
		iOrderService.updateOrder2Undelivered(deliverInv.getReferOrderNum());
	}

	@Override
	public boolean existsDeliverInv(String orderNum) {
		if(getDeliverInvHeaderByOrderNum(orderNum)==null){
			return false;
		}
		return true;
	}



	@Override
	public boolean havePutOn4WH(String deliverNum) {

		if(getDeliverInvHeader(deliverNum).getDeliverWhStatus()==WeaConstant.DELIVERINV_PUTONSTATUS_PUTON){
			return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listDeliverInvs(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		
		return iDeliverInvDao.getDeliverInvs(dataCriteria, offsetRequest);
	}

	@Override
	public void saveDeliverInvStockChange(String deliverNum,
			String whNum) {
		WareHouse wareHouse = iWareHouseService.getWarehouse(whNum);
		DeliverInvoice deliverInv = getDeliverInv(deliverNum);
		List<ProdQty> prodQtyList =  new ArrayList<ProdQty>();
		for(DeliverInvoiceItem deliverInvItem:deliverInv.getDeliverInvItemList()){
			ProdQty prodQty = new ProdQty();
			prodQty.setProdNum(deliverInvItem.getProdNum());
			prodQty.setProdName(deliverInvItem.getProdName());
			prodQty.setDifferName(deliverInvItem.getDifferName());
			prodQty.setCases(deliverInvItem.getCases());
			prodQty.setPieces(deliverInvItem.getPieces());
			prodQtyList.add(prodQty);
		}
		if(!iProdStockService.haveEnoughProdStocks(whNum, deliverInv.getOwnerNum(), prodQtyList)){
			throw new WeaException("仓库"+wareHouse.getWhName()+"库存不足");
		}
		ProdStockDelta prodStockDelta = new ProdStockDelta();
		prodStockDelta.setProdQtyList(prodQtyList);
		prodStockDelta.setOwnerNum(deliverInv.getOwnerNum());
		prodStockDelta.setWhNum(whNum);
		prodStockDelta.setWhName(wareHouse.getWhName());
		prodStockDelta.setReferNum(deliverInv.getDeliverNum());
		prodStockDelta.setReferModule(WeaConstant.MODULE_DELIVER);
		iProdStockService.updateReduceStock(prodStockDelta);
		
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("deliverNum", deliverNum);
		dataCriteria.setParam("whNum", whNum);
		dataCriteria.setParam("whName", wareHouse.getWhName());
		dataCriteria.setParam("deliverWhStatus", WeaConstant.DELIVERINV_PUTONSTATUS_PUTON);
		iDeliverInvDao.updateDeliverInv(dataCriteria);
		iOrderService.updateOrder2DeliverPuton(deliverInv.getReferOrderNum(),whNum);
	}

	@Override
	public void updateDeliverInv2PutOn(String deliverNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("deliverNum", deliverNum);
		dataCriteria.setParam("deliverWhStatus", WeaConstant.DELIVERINV_PUTONSTATUS_PUTON);
		iDeliverInvDao.updateDeliverInv(dataCriteria);

	}

	@Override
	public void updateDeliverInvlogistics(String deliverNum,DeliverInvlogistics deliverInvlogistics) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("deliverNum", deliverNum);
		dataCriteria.setParam("logisticsCompany", deliverInvlogistics.getLogisticsCompany());
		dataCriteria.setParam("logisticsNum", deliverInvlogistics.getLogisticsNum());
		dataCriteria.setParam("deliverAddress", deliverInvlogistics.getDeliverAddress());
		iDeliverInvDao.updateDeliverInv(dataCriteria);
	}

	@Override
	public DeliverInvoice getDeliverInvByOrderNum(String referOrderNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("referOrderNum", referOrderNum);
		DeliverInvoice deliverInv = iDeliverInvDao.getDeliverInv(dataCriteria);
		if(deliverInv!=null){
			List<DeliverInvoiceItem>  deliverInvItemList = getDeliverInvItems(deliverInv.getDeliverNum());
			deliverInv.setDeliverInvItemList(deliverInvItemList);
		}
		return deliverInv;
	}
	
	@Override
	public DeliverInvoice getDeliverInvHeaderByOrderNum(String referOrderNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("referOrderNum", referOrderNum);
		return iDeliverInvDao.getDeliverInv(dataCriteria);
	}

	@Override
	public List<DeliverInvoiceItem> getDeliverInvItems(String deliverNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("deliverNum", deliverNum);
		return iDeliverInvDao.getDeliverInvItems(dataCriteria);
	}

	@Override
	public DeliverInvoice getDeliverInv(String deliverNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("deliverNum", deliverNum);
		DeliverInvoice deliverInv =  iDeliverInvDao.getDeliverInv(dataCriteria);
		if(deliverInv!=null){
			List<DeliverInvoiceItem>  deliverInvItemList = iDeliverInvDao.getDeliverInvItems(dataCriteria);
			deliverInv.setDeliverInvItemList(deliverInvItemList);
		}
		return deliverInv;
	}
	@Override
	public DeliverInvoice getDeliverInvHeader(String deliverNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("deliverNum", deliverNum);
		return iDeliverInvDao.getDeliverInv(dataCriteria);
	}

	@Override
	public boolean chkLegalRetInv(String deliverNum,
			List<ProdQty> unsavedRetInvoiceProdQty) {
		if(StringUtils.isEmpty(deliverNum)){
			throw new WeaException("无效的出库单号");
		}
		List<DeliverInvoiceItem> deliverInvoiceItemList= getDeliverInvItems(deliverNum);
		for(DeliverInvoiceItem deliverInvItem:deliverInvoiceItemList){
			for(ProdQty retInvoiceprodQty:unsavedRetInvoiceProdQty){
				if(deliverInvItem.getProdNum().equalsIgnoreCase(retInvoiceprodQty.getProdNum())&&
				deliverInvItem.getDifferName().equalsIgnoreCase(retInvoiceprodQty.getDifferName())&&		
				(deliverInvItem.getCases()<0||(deliverInvItem.getCases()-retInvoiceprodQty.getCases())<0)){
					return false;
				}
			}
		}
		return true;
	}

}
