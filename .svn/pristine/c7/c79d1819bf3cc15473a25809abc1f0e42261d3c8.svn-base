package com.etaoguan.wea.interceptor;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.service.ILogService;
import com.etaoguan.wea.util.ExceptionUtil;
import com.etaoguan.wea.vo.Admin;
import com.etaoguan.wea.vo.Customer;
import com.etaoguan.wea.vo.MethodLog;
import com.etaoguan.wea.vo.OperationLogInfo;
import com.etaoguan.wea.vo.OwnerAdmin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LoggerInterceptor extends AbstractInterceptor{
	
	private final static Log logger = LogFactory.getLog(LoggerInterceptor.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		String actionClassName = invocation.getAction().getClass().getName();
		String method = invocation.getProxy().getMethod();

		String key=actionClassName+"."+method;
		MethodLog methodLog = WeaDataCache.getCache().getMethodLogInfoMap().get(key);
		String result = null;
		logger.info("run: start action:"+actionClassName+", method:"+method);
		if(WeaApplication.getInstance().islogMethod()&&methodLog!=null){
			Map<String,Object> session= invocation.getInvocationContext().getSession();
			Exception actException = null;
			OperationLogInfo operationLogInfo = new OperationLogInfo();
			ILogService  logService = WeaApplication.getInstance().getLogService();		
			Date startTime = new Date();	
			try{
				result = invocation.invoke();
				operationLogInfo.setResult("S");
				operationLogInfo.setRemark("");
			}catch(Exception ex){
				actException = ex;
				operationLogInfo.setResult("E");
				operationLogInfo.setRemark(ExceptionUtil.getStackTrace(ex, 255));
			}
			Date endTime = new Date();
			
			switch(methodLog.getOperatorRole()){
				case WeaConstant.SYS_ROLE_ADMIN:
					Admin admin = (Admin)session.get(WeaConstant.CURADMIN);
					if(admin!=null){
						operationLogInfo.setSysRole(WeaConstant.SYS_ROLE_ADMIN);
						operationLogInfo.setOperatorId(String.valueOf(admin.getAdminId()));
						operationLogInfo.setOperatorName(admin.getAdminName());
					};
					break;
				case WeaConstant.SYS_ROLE_CUST:
					Customer cust = (Customer)session.get(WeaConstant.CURCUST);
					if(cust!=null){
						operationLogInfo.setSysRole(WeaConstant.SYS_ROLE_CUST);
						operationLogInfo.setOperatorId(cust.getCustNum());
						operationLogInfo.setOperatorName(cust.getCustNum());
					};
					break;
				case WeaConstant.SYS_ROLE_OWNER:
					OwnerAdmin ownerAdmin = (OwnerAdmin)session.get(WeaConstant.CUROWNERADMIN);
					if(ownerAdmin!=null){
						operationLogInfo.setSysRole(WeaConstant.SYS_ROLE_OWNER);
						operationLogInfo.setOperatorId(String.valueOf(ownerAdmin.getAdminId()));
						operationLogInfo.setOperatorName(ownerAdmin.getAdminName());
					};
					break;
				default:
			}
			
		
			operationLogInfo.setActionName(actionClassName);
			operationLogInfo.setMethod(method);
			String params = "";
			Map map = invocation.getInvocationContext().getParameters();
			Set objects = map.entrySet();
			Iterator<Entry<String, Object>> it = objects.iterator();
			while(it.hasNext()){
				Entry<String, Object> entry = it.next();
				String lowerKey = entry.getKey().toLowerCase();
				if(!lowerKey.contains("password")&&!lowerKey.contains("pwd")){
					if(entry.getValue() instanceof String[]){
						String[] values = (String[])entry.getValue();
						params = params + entry.getKey()+"="+getStrings(values)+";";
					}
				}
				
			}
			operationLogInfo.setParams(params);
			operationLogInfo.setStartDate(startTime);
			operationLogInfo.setEndDate(endTime);
			operationLogInfo.setLogInfo(methodLog.getInfo());
			operationLogInfo.setCostTime(endTime.getTime()-startTime.getTime());
			logService.addOperationLogInfo(operationLogInfo);
			
			
			if(actException!=null){
				throw actException;
			}
			
		}
		else{
			result = invocation.invoke();
			
		}
		logger.info("run: end action:"+actionClassName+", method:"+method);
		return result;
	}
	
	private String getStrings(String[] args){
		String strs = "";
		for(String str:args){
			strs = strs+str+",";
		}
		return strs;
	}

}
