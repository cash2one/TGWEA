package com.etaoguan.wea.util;

import com.etaoguan.wea.wechat.util.WeChatXppDriver;
import com.thoughtworks.xstream.XStream;

public class XStreamTest {

	public static void main(String[] args) {
		XStream xstream = new XStream(new WeChatXppDriver());
		xstream.alias("direct_trade_create_req", AlipayOrder.class);

		AlipayOrder alipayOrder = new AlipayOrder();
		alipayOrder.setOut_trade_no("222");
		alipayOrder.setSubject("111");
		alipayOrder.setTotal_fee("333");
		alipayOrder.setSeller_account_name("444");
		alipayOrder.setCall_back_url("555");
		alipayOrder.setNotify_url("666");
		alipayOrder.setOut_user("777");
		alipayOrder.setMerchant_url("888");
		alipayOrder.setPay_expire("999");
		alipayOrder.setAgent_id("101010");

		String xml = xstream.toXML(alipayOrder).replaceAll("__", "_");

		System.out.println(xml);
		
	}

}
