package com.etaoguan.wea.listener;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.service.IAccessAuthService;
import com.etaoguan.wea.util.ConfigLoad;
import com.etaoguan.wea.vo.AccessFuncMethod;

public class DefaultApplicationSetupListener implements ServletContextListener {
	
	private ServletContext servletConetxt;

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory
			.getLog(DefaultApplicationSetupListener.class);

	public ServletContext getServletConetxt() {
		return servletConetxt;
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		servletConetxt = servletContextEvent.getServletContext();
		String realPath = servletConetxt.getRealPath("") + File.separatorChar;
		WeaApplication.getInstance().setAppRealPath(realPath);
		WeaApplication.getInstance().setAppContextName(servletConetxt.getServletContextName());
		WeaApplication.getInstance().setAppContext(WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()));
		initCacheData();
		loadProperty();
		initAccessAuthData();
		startJobs();
	}
	
	private void startJobs(){

//		PushMessageQuartzJob.startScheduler();
		// FileCacheQuartzJob.startScheduler();

	}
	private void initCacheData() {
		WeaDataCache.getCache().initDataCache();
	}
	private void initAccessAuthData() {
		
		Map<String, AccessFuncMethod> accessAuthMap = WeaDataCache.getCache().getAccessAuthMap();
		IAccessAuthService iAccessAuthService = WeaApplication.getInstance().getAccessAuthService();
		iAccessAuthService.saveInitAccessAuthConfig(accessAuthMap.values());
		
	}
	private void loadProperty() {
		WeaApplication.getInstance().setServerProperties(new ConfigLoad().getProp());
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}

}
