package com.etaoguan.wea.interceptor;


import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.etaoguan.wea.client.vo.PageTrack;
import com.etaoguan.wea.constant.WeaConstant;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class VisitTrackInterceptor extends AbstractInterceptor{
	private final static Log logger = LogFactory.getLog(VisitTrackInterceptor.class);
	
	private static final long serialVersionUID = 1L;

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		trackPageNum(invocation);
		
		
		return invocation.invoke();
	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private void trackPageNum(ActionInvocation invocation){
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		Object object=invocation.getProxy().getAction();
		String actionClassName="";
		if (Enhancer.isEnhanced(object.getClass())) {
			actionClassName=object.getClass().getSuperclass().getName();
		}else {
			actionClassName =object.getClass().getName();
		}
		
		String method = invocation.getProxy().getMethod();
		String key=actionClassName+"."+method;
		Map sessionMap = invocation.getInvocationContext().getSession();
		Map sessionTrack = (Map)sessionMap.get(WeaConstant.SESSIONPAGETRACK);
		if(sessionTrack==null){
			logger.info("create session track");
			sessionTrack = new HashMap();
			sessionMap.put(WeaConstant.SESSIONPAGETRACK, sessionTrack);
		}
		
		HashMap paramMap = (HashMap)invocation.getInvocationContext().getParameters();
		
		Object redTFW = paramMap.get(WeaConstant.REDTFW);

		if(redTFW!=null&&"Y".equalsIgnoreCase(((String[])redTFW)[0])){
			PageTrack pageTrack = (PageTrack)sessionTrack.get(key);
			if(pageTrack == null){
				logger.info("create session track");
				pageTrack = new PageTrack();
				sessionTrack.put(key,pageTrack);
			}		
			logger.info("save current request page");
			pageTrack.setLastParamMap((HashMap)paramMap.clone());
		}
		
		
	}
	
	
}
