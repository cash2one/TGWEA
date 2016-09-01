package com.etaoguan.wea.client.web.action.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.vo.OwnerAdmin;

@Service("testAction") @Scope("prototype")
public class WTestAction extends WCommonBaseAction{
	private OwnerAdmin defaultOwnerAdmin;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3499122456500874384L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Action(value="test")
	public String logout() throws IOException, ServletException{
		List testList = new ArrayList();
		testList.add("111");
		testList.add("222");
		testList.add("333");
		weaResponse.setRespData(testList);
		return JSONRESPONSE;
	}

	@Action(value="test1",results = { @Result(name = "success", type = "redirectAction",params={"actionName","owner/wLogin.action", "adminName","${defaultOwnerAdmin.adminName}","adminPwd","${defaultOwnerAdmin.adminPwd}"})})
	public String logout1() throws IOException, ServletException{
		defaultOwnerAdmin = new OwnerAdmin();
		defaultOwnerAdmin.setAdminName("1688gdluocs2");
		defaultOwnerAdmin.setAdminPwd("999999");
		return SUCCESS;
	}

	public OwnerAdmin getDefaultOwnerAdmin() {
		return defaultOwnerAdmin;
	}

	public void setDefaultOwnerAdmin(OwnerAdmin defaultOwnerAdmin) {
		this.defaultOwnerAdmin = defaultOwnerAdmin;
	}	
	

}
