package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWOwnerSettingService;
import com.etaoguan.wea.client.web.service.IWTableCodeNameService;
import com.etaoguan.wea.client.web.vo.OwnerSettingSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.OwnerSetting;
import com.etaoguan.wea.vo.TableCodeName;

@SuppressWarnings("serial")
@WeaModule(mname="企业配置信息管理")
@Service("adminWOwnerSettingAction") @Scope("prototype")
public class WOwnerSettingAction extends WCommonBaseAction{

	@Autowired
	private IWOwnerSettingService iwOwnerSettingService;
	
	@Autowired
	private IWTableCodeNameService iWTableCodeNameService;
	
	private OwnerSetting ownerSetting;
	
	private OwnerSettingSearch ownerSettingSearch;
	
	@WeaFunction(fname="查看企业配置信息",oname=WeaFunction.Operation.READ)
	@Action(value="wListOwnerSettings",results = { @Result(name = "success", type = "dispatcher",location="/admin/list_ownersettings.jsp")})
	public String listOwnerSettings() throws IOException {
		return SUCCESS;
	}

	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看企业配置信息",oname=WeaFunction.Operation.READ)
	@Action(value="wListOwnerSettingsData")
	public String listOwnerSettingsData() throws IOException {
		WPage wpage = iwOwnerSettingService.listOwnerSettings(ownerSettingSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="查看可用企业配置信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetAvailableOwnerSettings")
	public String getAvailableOwnerSettings() throws IOException {
		String ownerNum = getRequestParamValue("ownerNum");
		List<TableCodeName> availableOwnerSettings = iWTableCodeNameService.getOwnerSettingAvailableTableCodeNameList(ownerNum);
		weaResponse.setRespData(availableOwnerSettings);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除企业配置信息",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelOwnerSetting")
	public String delOwnerSetting() throws IOException {
		String settingId = getRequestParamValue("settingId");
		iwOwnerSettingService.delOwnerSetting(Long.parseLong(settingId));
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改企业配置信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditOwnerSetting")
	public String saveEditOwnerSetting() throws IOException {
		iwOwnerSettingService.saveOrUpdateOwnerSetting(ownerSetting);
		return JSONRESPONSE;
	}
	
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取企业配置信息查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListOwnerSettingSearchInitData")
	public String getListOwnerSettingSearchInitData() throws IOException {
		Map initSearchDataMap = iwOwnerSettingService.getListOwnerSettingSearchInitData();
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}

	public OwnerSetting getOwnerSetting() {
		return ownerSetting;
	}

	public void setOwnerSetting(OwnerSetting ownerSetting) {
		this.ownerSetting = ownerSetting;
	}

	public OwnerSettingSearch getOwnerSettingSearch() {
		return ownerSettingSearch;
	}

	public void setOwnerSettingSearch(OwnerSettingSearch ownerSettingSearch) {
		this.ownerSettingSearch = ownerSettingSearch;
	}
}
