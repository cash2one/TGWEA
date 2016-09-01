package com.etaoguan.wea.client.mobile.action.cust;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMAppUpgradeService;
import com.etaoguan.wea.client.mobile.vo.MAppUpgradeInfo;
import com.etaoguan.wea.service.IAddAndroidversionService;
import com.etaoguan.wea.service.IAppleVersionService;

@SuppressWarnings("serial")
@Service("ownerMOwnerAppUpgradeAction") @Scope("prototype")
public class MOwnerAppUpgradeAction extends MOwnerBaseAction{

	@Resource(name="mappUpgradeService")
	private IMAppUpgradeService imAppUpgradeService;
	
	@Resource(name="addAndroidversionService")
	private IAddAndroidversionService iAddAndroidversionService;
	
	@Resource(name="appleVersionService")
	private IAppleVersionService iAppleVersionService;
	
	@Action(value="mGetNewAppVersion")
	public String getNewAppVersion() throws IOException {
		
		String appType = getRequestParamValue("appType");
		String versionCode =  getRequestParamValue("versionCode");
		
		MAppUpgradeInfo mAppUpgradeInfo = imAppUpgradeService.getMAppUpgradeInfo(ownerNum,appType,versionCode,getDomainBaseUrl());
		 
		weaResponse.setRespData(mAppUpgradeInfo);
		return JSONRESPONSE;
	}

	
}
