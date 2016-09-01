package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.vo.CashInvoice;
import com.etaoguan.wea.vo.Customer;
import com.etaoguan.wea.vo.DeliverInvoice;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.ReturnedInvoice;

public class WSettleInvoice {
	
	private Customer customer;
	
	private Order order;
	
	private DeliverInvoice deliverInv; 
	
	private ReturnedInvoice returnedInv;
	
	private CashInvoice cashInv;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public DeliverInvoice getDeliverInv() {
		return deliverInv;
	}

	public void setDeliverInv(DeliverInvoice deliverInv) {
		this.deliverInv = deliverInv;
	}

	public ReturnedInvoice getReturnedInv() {
		return returnedInv;
	}

	public void setReturnedInv(ReturnedInvoice returnedInv) {
		this.returnedInv = returnedInv;
	}

	public CashInvoice getCashInv() {
		return cashInv;
	}

	public void setCashInv(CashInvoice cashInv) {
		this.cashInv = cashInv;
	}
	
	

}
