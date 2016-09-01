package com.etaoguan.wea.client.web.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWSysCfgLoadService;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.service.IAccessAuthService;
import com.etaoguan.wea.vo.AccessFuncMethod;

@Service("wsysCfgLoadService")
public class WSysCfgLoadService implements IWSysCfgLoadService{

	private final static Log logger = LogFactory.getLog(WSysCfgLoadService.class);
	
	@Resource(name="accessAuthService") 
	IAccessAuthService iAccessAuthService;
			
	@Override
	public void reLoadTargetSysCfg(String targetCfg) {
		logger.info("execute reload : "+targetCfg);
		if(StringUtils.isNotEmpty(targetCfg)){
			if("refreshdatacache".equalsIgnoreCase(targetCfg)){
				WeaDataCache.getCache().initTableColumnDataCache();
				WeaDataCache.getCache().initTableCodeNameDataCache();
				WeaDataCache.getCache().initTradeDataCache();
			}
			if("refreshaccessauth".equalsIgnoreCase(targetCfg)){
				WeaDataCache.getCache().initAccessAuthDataCache();
				Map<String, AccessFuncMethod> accessAuthMap = WeaDataCache.getCache().getAccessAuthMap();
				iAccessAuthService.saveInitAccessAuthConfig(accessAuthMap.values());
			}
			if("refreshappsetting".equalsIgnoreCase(targetCfg)){
				WeaDataCache.getCache().initAppSettingDataCache();
			}
			if("refreshownersetting".equalsIgnoreCase(targetCfg)){
				WeaDataCache.getCache().initOwnerSettingDataCache();
			}
			
		}
		
	}

}
