package com.etaoguan.wea.client.mobile.service;

import com.etaoguan.wea.client.mobile.vo.MAppUpgradeInfo;

public interface IMAppUpgradeService {

	public MAppUpgradeInfo getMAppUpgradeInfo(String ownerNum,String appType,String versionCode,String baseUrl);
}
