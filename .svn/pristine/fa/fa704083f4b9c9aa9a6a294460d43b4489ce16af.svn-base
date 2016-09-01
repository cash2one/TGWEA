package com.etaoguan.wea.client.web.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWFileCacheService;
import com.etaoguan.wea.service.impl.FileCacheService;


@Service("wfileCacheService")
public class WFileCacheService extends FileCacheService implements IWFileCacheService{

	private final static Log logger = LogFactory.getLog(WFileCacheService.class);
			
	@Override
	public void saveTargetFileCache(String targetFileCache) {
		logger.info("gen filecache : "+targetFileCache);
		if(StringUtils.isNotEmpty(targetFileCache)){
			if("genproddetailfilecache".equalsIgnoreCase(targetFileCache)){
				saveProdDetailJSONFileCache();
			}
			
		}
		
	}
	
}
