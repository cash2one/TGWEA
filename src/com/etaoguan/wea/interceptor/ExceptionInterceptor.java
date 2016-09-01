package com.etaoguan.wea.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.etaoguan.wea.client.vo.WeaResponse;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.util.ExceptionUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ResultConfig;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExceptionInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = -5271295702033965535L;
	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(ExceptionInterceptor.class);
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		try{
			result = invocation.invoke();
		}
		catch(Throwable ex){
			ex.printStackTrace();
			WeaResponse weaResponse = new WeaResponse();
			weaResponse.setFailStatus();
			weaResponse.setMessage(ExceptionUtil.getExMessage(ex));
			ActionContext.getContext().getValueStack().set(WeaConstant.RESPONSEROOT, weaResponse);
			if(isAjaxResponse(invocation)){
				result = WeaConstant.JSONRESPONSE;
			}else{
				result = WeaConstant.HTMLEXCEPTIONRESPONSE;
			}
		}
		return result;
	}

	private boolean isAjaxResponse(ActionInvocation invocation){
		ResultConfig resultConfig = invocation.getProxy().getConfig().getResults().get("success");

		if(resultConfig==null||"org.apache.struts2.json.JSONResult".equalsIgnoreCase(resultConfig.getClassName()))
		{
			return true;
		}else{
			return false;
		}

	}
	
}
