package com.etaoguan.wea.client.mobile.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.service.IMAppUpgradeService;
import com.etaoguan.wea.client.mobile.vo.MAppUpgradeInfo;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.service.IAddAndroidversionService;
import com.etaoguan.wea.service.IAppleVersionService;
import com.etaoguan.wea.service.impl.AddAndroidversionService;
import com.etaoguan.wea.vo.AppAndroidVersion;
import com.etaoguan.wea.vo.AppleVersion;

@Service("mappUpgradeService")
public class MAppUpgradeService extends AddAndroidversionService implements IMAppUpgradeService{

	@Resource(name="addAndroidversionService")
	private IAddAndroidversionService iAddAndroidversionService;
	
	@Resource(name="appleVersionService")
	private IAppleVersionService iAppleVersionService;
	
	
	@Override
	public MAppUpgradeInfo getMAppUpgradeInfo(String ownerNum,String appType,String versionCode,String baseUrl){
		if("crackios".equalsIgnoreCase(appType)){
			MAppUpgradeInfo mAppUpgradeInfo = new MAppUpgradeInfo();
			mAppUpgradeInfo.setHaveNewVersion(iAppleVersionService.getAppleMaxVersionService(ownerNum, versionCode));
			mAppUpgradeInfo.setForceUpdate(false);
			
			AppleVersion appleVersion=new AppleVersion();
			appleVersion.setVersionId(Long.valueOf("-1"));
			appleVersion.setOwnerNum(ownerNum);
			appleVersion=iAppleVersionService.getAppleVersionById(appleVersion);
			String appName=appleVersion.getFileName()+".ipa";
			mAppUpgradeInfo.setFileName(appName);

			 String savepath=baseUrl+"download/"+ownerNum+"/"+ownerNum+".html";
			
			mAppUpgradeInfo.setPackageUrl(savepath);
			return mAppUpgradeInfo;
		}else if("ios".equalsIgnoreCase(appType)){
			MAppUpgradeInfo mAppUpgradeInfo = new MAppUpgradeInfo();
			mAppUpgradeInfo.setHaveNewVersion(iAppleVersionService.getAppleMaxVersionService(ownerNum, versionCode));
			mAppUpgradeInfo.setForceUpdate(false);
			
			AppleVersion appleVersion=new AppleVersion();
			appleVersion.setVersionId(Long.valueOf("-1"));
			appleVersion.setOwnerNum(ownerNum);
			appleVersion=iAppleVersionService.getAppleVersionById(appleVersion);
			String appName=appleVersion.getFileName()+".ipa";
			mAppUpgradeInfo.setFileName(appName);
			mAppUpgradeInfo.setPackageUrl("https://itunes.apple.com/app/id"+appleVersion.getBundleId());
			return mAppUpgradeInfo;
		}else if("android".equalsIgnoreCase(appType)){
			MAppUpgradeInfo mAppUpgradeInfo = new MAppUpgradeInfo();
			mAppUpgradeInfo.setHaveNewVersion(getMaxvstoUpdate(ownerNum, Integer.parseInt(versionCode)));
			mAppUpgradeInfo.setForceUpdate(false);
			
			AppAndroidVersion androidVersion=new AppAndroidVersion();
			androidVersion.setVersionId(Long.valueOf("-1"));
			androidVersion.setOwnerNum(ownerNum);
			androidVersion=iAddAndroidversionService.getAndrodivsbyId(androidVersion);
			String appName=androidVersion.getFileName()+".apk";
			mAppUpgradeInfo.setFileName(appName);
			mAppUpgradeInfo.setPackageUrl(baseUrl+"download/"+ownerNum+"/apk/"+appName);
			
			return mAppUpgradeInfo;
		}else{
			
			throw new WeaException("无效的应用类型");
		}
	}
}
