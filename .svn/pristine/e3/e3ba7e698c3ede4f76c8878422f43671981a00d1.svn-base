package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWOwnerAdminService;

@SuppressWarnings("serial")
@WeaModule(mname="企业管理员管理")
@Service("adminWOwnerAdminAction") @Scope("prototype")
public class WOwnerAdminAction extends WCommonBaseAction{
	
	@Resource(name="wownerAdminService")
	private IWOwnerAdminService iwOwnerAdminService;

	@WeaFunction(fname="重置企业管理员密码",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wResetOwnerAdminPwd")
	public String resetOwnerAdminPwd() throws IOException {
		
		String ownerNum = getRequestParamValue("ownerNum");
		iwOwnerAdminService.saveInitOwnerAdmin(ownerNum);
		return JSONRESPONSE;
	}

}
