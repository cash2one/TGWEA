package com.etaoguan.wea.client.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWCashInvService;
import com.etaoguan.wea.client.web.service.IWCustService;
import com.etaoguan.wea.client.web.service.IWDeliverInvService;
import com.etaoguan.wea.client.web.service.IWOrderService;
import com.etaoguan.wea.client.web.service.IWReturnedInvService;
import com.etaoguan.wea.client.web.service.IWSettleInvService;
import com.etaoguan.wea.client.web.vo.SettleInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WSettleInvoice;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.service.impl.SettleInvService;
import com.etaoguan.wea.vo.CashInvoice;
import com.etaoguan.wea.vo.Customer;
import com.etaoguan.wea.vo.DeliverInvoice;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.ReturnedInvoice;

@Service("wsettleInvService")
public class WSettleInvService extends SettleInvService implements  IWSettleInvService{

	@Autowired
	IWCustService iWCustService;
	
	@Autowired
	IWOrderService iWOrderService;
	
	@Autowired
	IWDeliverInvService iWDeliverInvService;
	
	@Autowired
	IWCashInvService iWCashInvService;
	
	@Autowired
	IWReturnedInvService iWReturnedInvService;
	
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listSettleInvs(SettleInvSearch settleInvSearch, SortParam sortParam,
			WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", settleInvSearch.getOwnerNum());
		dataCriteria.setParam("custNum", settleInvSearch.getCustNum());
		dataCriteria.setParam("orderNum", settleInvSearch.getReferOrderNum());
		dataCriteria.setParam("settleStatus", 1);
		
		DataSet dataSet = iWOrderService.listOrders(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}

	@Override
	public WSettleInvoice getSettleInv(String orderNum) {
		
		WSettleInvoice wsettleInvoice = new WSettleInvoice();
		
		Order order = iWOrderService.getOrder(orderNum);
		Customer customer = iWCustService.getCust(order.getCustNum());
		DeliverInvoice deliverInv =  iWDeliverInvService.getDeliverInvByOrderNum(orderNum);
		ReturnedInvoice returnedInv = iWReturnedInvService.getReturnedInvByOrderNum(orderNum);
		CashInvoice cashInv = iWCashInvService.getCashInvByOrderNum(orderNum);
		wsettleInvoice.setCashInv(cashInv);
		wsettleInvoice.setCustomer(customer);
		wsettleInvoice.setDeliverInv(deliverInv);
		wsettleInvoice.setOrder(order);
		wsettleInvoice.setReturnedInv(returnedInv);
		return wsettleInvoice;
	}

	@Override
	public void updateConfirmOrderSettlement(String orderNum) {
		
		if(getSettleInvPriceDelta(orderNum)!=0D){
			throw new WeaException("订单金额与付款金额不一致");
		}
		
		if(getSettleInvProdDelta(orderNum).size()>0){
			throw new WeaException("库存盘点失败,请检查货单产品数量");
		}
		iWOrderService.updateOrder2Settled(orderNum);
	}

	
}
