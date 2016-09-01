package com.etaoguan.wea.client.mobile.action.cust;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMPaymentInfoService;
import com.etaoguan.wea.client.mobile.service.IMPaymentService;
import com.etaoguan.wea.client.mobile.vo.OrderPay;
import com.etaoguan.wea.client.mobile.vo.PayNav;


@WeaModule(mname="移动端支付")
@Service("custMPaymentAction") @Scope("prototype")
public class MPaymentAction extends MOwnerBaseAction{

	private static final long serialVersionUID = 854960251297615394L;

	private OrderPay orderPay;
	
	@Resource(name="mpaymentService")
	private IMPaymentService imPaymentService;
	
	@Resource(name="mpaymentInfoService")
	private IMPaymentInfoService imPaymentInfoService;

	
	@WeaFunction(fname="客户订单支付(移动端)",oname=WeaFunction.Operation.UPDATE)
	@Action(value="mPayOrder")
	public String payOrder() throws Exception {
		
		orderPay.setOwnerNum(ownerNum);
		orderPay.setCustNum(getCurrentCust().getCustNum());
		PayNav payNav =imPaymentService.processPayOrder(orderPay,getDomainBaseUrl());
		switch(payNav.getNavType()){
		case PayNav.OUTPUT:
			writeResponse(payNav.getNavContent());
			break;
		case PayNav.REDIRECT:
			getResponse().sendRedirect(payNav.getNavContent());
			break;
		default:
			break;
		
		}
		
		
		return null;
		
	}
	
	public OrderPay getOrderPay() {
		return orderPay;
	}

	public void setOrderPay(OrderPay orderPay) {
		this.orderPay = orderPay;
	}

}
