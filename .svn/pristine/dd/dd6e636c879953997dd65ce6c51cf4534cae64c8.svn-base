package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.openapi.client.auth.AuthorizationToken;
import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWE688Service;
import com.etaoguan.wea.client.web.service.IWOwnerAdminService;
import com.etaoguan.wea.client.web.service.IWOwnerService;

@SuppressWarnings("serial")
@WeaModule(mname="1688数据同步管理")
@Service("ownerWE688SyncAction") @Scope("prototype")
public class WE688SyncAction extends WOwnerBaseAction{
	
	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(WE688SyncAction.class);
	
	@Autowired
	IWOwnerAdminService iWOwnerAdminService;

	@Autowired
	IWOwnerService iWOwnerService;
			
	@Resource(name="we688Service")
	private IWE688Service iwE688Service;

	@Action(value="wE688SyncPage",results = { @Result(name = "success", type = "dispatcher",location="/owner/1688_syncpage.jsp")})
	public String e688SyncPage() throws IOException {
		
		return SUCCESS;
		
	}
	
	@WeaFunction(fname="同步更1688企业信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wE688SyncData")
	public String e688SyncData() throws IOException {
		AuthorizationToken authToken = (AuthorizationToken)getSessionAttribute("e688AuthToken");
		if(authToken==null){
			weaResponse.setFailStatus();
			weaResponse.setMessage("未登录授权，同步失败！");
		}else{
			iwE688Service.syncE688Data(authToken);//执行企业信息同步
			
		}
		return JSONRESPONSE;
		
	}


}
