package com.etaoguan.wea.service;

public interface IShortMessageService {

	public String getShortMessageCode();
	
	public void sendRegShortMessageContent(String mobileNum, String code,String ownerNum);
	public void sendMobileOrderShortMessageContent(String custNum, String orderNum,String ownerNum);
	
	public void sendShortMessage(String mobileNum,String content);
}
