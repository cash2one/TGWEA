package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;

@SuppressWarnings("serial")
@WeaModule(mname="功能选择")
@Service("otherAction") @Scope("prototype")
public class WOtherAction extends WOwnerBaseAction{

	 
	@WeaFunction(fname="去下载APP页面",oname=WeaFunction.Operation.READ)
	@Action(value="wGoDownloadApp",results = { @Result(name = "success", type = "dispatcher",location="/owner/other/download_app.jsp")})
	public String goDownloadApp() throws IOException {
		  setSessionAttribute("ownerNum",getCurrentOwnerAdmin().getOwnerNum());
		return SUCCESS;
	}
	




}
