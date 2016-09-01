package com.etaoguan.wea.client.mobile.action.cust;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMShortMessageService;


@SuppressWarnings("serial")
@Service("mshortMessageAction") @Scope("prototype")
public class MShortMessageAction extends MOwnerBaseAction{
	
	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(MShortMessageAction.class);

	@Autowired
	private IMShortMessageService imShortMessageService;

	@Action(value="getRegCode")
	public void getRegCode() throws IOException {
		
		String mobileNum = getRequestParamValue("mobileNum");
		String regCode = imShortMessageService.getShortMessageCode();
		
		imShortMessageService.sendRegShortMessageContent(mobileNum, regCode, ownerNum);
		
		getSession().setAttribute("checkCode", regCode);
		
	}

}
