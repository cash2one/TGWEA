package com.etaoguan.wea.client.mobile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.service.IMDeliverInvService;
import com.etaoguan.wea.client.mobile.service.IMOrderService;
import com.etaoguan.wea.client.mobile.vo.MOrder;
import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.MPagingRequest;
import com.etaoguan.wea.client.mobile.vo.OrderSearch;
import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.OrderService;
import com.etaoguan.wea.vo.DeliverInvoice;
import com.etaoguan.wea.vo.Order;


@Service("morderService")
public class MOrderService extends OrderService implements IMOrderService{

	@Autowired
	private IMDeliverInvService imDeliverInvService;

	
	@Override
	@SuppressWarnings("rawtypes")
	public MPage listOrders(OrderSearch orderSearch, SortParam sortParam,
			MPagingRequest mpagingRequest) {
		OffsetRequest offsetRequest = mpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", orderSearch.getOwnerNum());
		dataCriteria.setParam("custNum", orderSearch.getCustNum());
		dataCriteria.setParam("custCompanyName", orderSearch.getCustCompanyName());
		dataCriteria.setParam("deliverStatus", orderSearch.getDeliverStatus());
		dataCriteria.setParam("settleStatus", orderSearch.getSettleStatus());
		dataCriteria.setParam("cashStatus", orderSearch.getSettleStatus());
		dataCriteria.setParam("phoneNum", orderSearch.getPhoneNum());
		DataSet dataSet = getOrdersWithItem(dataCriteria, offsetRequest);
		
		return new MPage(mpagingRequest,dataSet);
	}

	@Override
	public MOrder getMOrder(String orderNum) {
		DeliverInvoice deliverInvoice = imDeliverInvService.getDeliverInvByOrderNum(orderNum);
		Order order = getOrder(orderNum);
		MOrder morder = new MOrder();
		morder.setDeliverInv(deliverInvoice);
		morder.setOrder(order);
		return morder;
	}

}
