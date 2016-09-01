package com.etaoguan.wea.service;

public interface IAppUpgradeService {

	public boolean haveNewIosAppVersion(String  versionNo,String ownerNum);
	
	public boolean getNewIosAppPath(String  ownerNum);
	
	public boolean haveNewAndriodAppVersion(String  versionNo,String ownerNum);
	
	public boolean getNewAndroidAppPath(String  versionNo,String ownerNum);
}
