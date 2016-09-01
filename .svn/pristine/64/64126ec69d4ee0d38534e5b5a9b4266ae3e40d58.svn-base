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
import com.etaoguan.wea.client.web.service.IWFileCacheService;


@SuppressWarnings("serial")
@WeaModule(mname="静态数据缓存管理")
@Service("adminWFileCacheAction") @Scope("prototype")
public class WFileCacheAction extends WCommonBaseAction{

	@Resource(name="wfileCacheService")
	private IWFileCacheService iWFileCacheService;
			
	@WeaFunction(fname="查看系统静态数据缓存项目列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListFileCacheItems",results = { @Result(name = "success", type = "dispatcher",location="/admin/filecache.jsp")})
	public String listSysCfgLoadItems() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="查看系统静态数据缓存项目列表",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wGenFileCache")
	public String genFileCache() throws IOException, ServletException {
		String targetFileCache = getRequestParamValue("targetfilecache");
		iWFileCacheService.saveTargetFileCache(targetFileCache);
		return JSONRESPONSE;
	}


}
