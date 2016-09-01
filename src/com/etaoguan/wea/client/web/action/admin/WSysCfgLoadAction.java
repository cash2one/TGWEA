package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWSysCfgLoadService;

@SuppressWarnings("serial")
@WeaModule(mname="系统配置信息管理")
@Service("adminWSysCfgLoadAction") @Scope("prototype")
public class WSysCfgLoadAction extends WCommonBaseAction{

	@Resource(name="wsysCfgLoadService")
	private IWSysCfgLoadService iWSysCfgLoadService;
			
	@WeaFunction(fname="查看系统配置信息项目列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListSysCfgLoadItems",results = { @Result(name = "success", type = "dispatcher",location="/admin/syscfgload.jsp")})
	public String listSysCfgLoadItems() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="查看系统配置信息项目列表",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wReloadSysCfg")
	public String reloadSysCfg() throws IOException, ServletException {
		String targetCfg = getRequestParamValue("targetcfg");
		iWSysCfgLoadService.reLoadTargetSysCfg(targetCfg);
		return JSONRESPONSE;
	}


}
