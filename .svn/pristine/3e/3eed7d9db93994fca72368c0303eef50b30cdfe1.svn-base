package com.etaoguan.wea.client.mobile.action.owner;

import java.io.IOException;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.common.WeaDataCache;

@Service("ownerMOwnerSettingAction") @Scope("prototype")
public class MOwnerSettingAction extends MOwnerBaseAction{
	
	private static final long serialVersionUID = -5449327250319364611L;

	@Action(value="mGetOwnerSettingForceToLocal")
	public String getOwnerSettingForceToLocal() throws IOException {
		
	
		boolean forceToLocal = WeaDataCache.getCache().getOwnerSettingForceToLocal(ownerNum);
		weaResponse.setRespData(forceToLocal);
		return JSONRESPONSE;
	}


}
