package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWAppSettingService;
import com.etaoguan.wea.client.web.service.IWTableCodeNameService;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.AppSetting;
import com.etaoguan.wea.vo.TableCodeName;

@SuppressWarnings("serial")
@WeaModule(mname="系统配置信息管理")
@Service("adminWAppSettingAction") @Scope("prototype")
public class WAppSettingAction extends WCommonBaseAction{

	@Autowired
	private IWAppSettingService iwAppSettingService;
	
	@Autowired
	private IWTableCodeNameService iWTableCodeNameService;
	
	private AppSetting appSetting;
	
	@WeaFunction(fname="查看系统配置信息",oname=WeaFunction.Operation.READ)
	@Action(value="wListAppSettings",results = { @Result(name = "success", type = "dispatcher",location="/admin/list_appsettings.jsp")})
	public String listAppSettings() throws IOException {
		return SUCCESS;
	}

	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看系统配置信息",oname=WeaFunction.Operation.READ)
	@Action(value="wListAppSettingsData")
	public String listAppSettingsData() throws IOException {
		WPage wpage = iwAppSettingService.listAppSettings(sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="查看可用系统配置信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetAvailableAppSettings")
	public String getAvailableAppSettings() throws IOException {
		List<TableCodeName> availableAppSettings = iWTableCodeNameService.getAppSettingAvailableTableCodeNameList();
		weaResponse.setRespData(availableAppSettings);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除系统配置信息",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelAppSetting")
	public String delAppSetting() throws IOException {
		String settingId = getRequestParamValue("settingId");
		iwAppSettingService.delAppSetting(Long.parseLong(settingId));
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改系统配置信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditAppSetting")
	public String saveEditAppSetting() throws IOException {

		iwAppSettingService.saveOrUpdateAppSetting(appSetting);
		return JSONRESPONSE;
	}
	
	public AppSetting getAppSetting() {
		return appSetting;
	}

	public void setAppSetting(AppSetting appSetting) {
		this.appSetting = appSetting;
	}
}
