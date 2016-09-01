package com.etaoguan.wea.interceptor;

import java.util.List;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.etaoguan.wea.client.vo.WeaResponse;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.vo.AccessOperation;
import com.etaoguan.wea.vo.AccessFuncMethod;
import com.etaoguan.wea.vo.Admin;
import com.etaoguan.wea.vo.Customer;
import com.etaoguan.wea.vo.OwnerAdmin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ResultConfig;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AccessAuthInterceptor extends MethodFilterInterceptor {
	private final static Log logger = LogFactory.getLog(AccessAuthInterceptor.class);
	
	private static final long serialVersionUID = 1L;


	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {

		Object object=invocation.getProxy().getAction();
		
		String actionClassName="";
		if (Enhancer.isEnhanced(object.getClass())) {
			actionClassName=object.getClass().getSuperclass().getName();
		}else {
			actionClassName =object.getClass().getName();
		}
		Map<String,Object> session= invocation.getInvocationContext().getSession();
		
		String shopNum = ServletActionContext.getRequest().getParameter(WeaConstant.CLIENTSHOPNUM);
		String ownerNum =  WeaDataCache.getCache().getOwnerShopNumMap().get(shopNum);
		if(ownerNum!=null){
			boolean activeOwner = WeaApplication.getInstance().getOwnerService().isActiveOwner(ownerNum);
			if(!activeOwner){
				WeaResponse weaResponse = new WeaResponse();
				weaResponse.setFailStatus();
				weaResponse.setMessage("未授权企业");
				ActionContext.getContext().getValueStack().set(WeaConstant.RESPONSEROOT, weaResponse);
				if(isAjaxResponse(invocation)){
					return WeaConstant.JSONRESPONSE;
				}else{
					return WeaConstant.FORBIDDENINPAGE;
				}
			}
		}
		
		String method = invocation.getProxy().getMethod();
		String key=actionClassName+"."+method;
		logger.info("invocate actoin =============="+key);
		
		Map<String, AccessFuncMethod> accessAuthMap= WeaDataCache.getCache().getAccessAuthMap();
	
		if(!accessAuthMap.containsKey(key)){
			logger.info(key+" no limited, invoke continue...");
			return invocation.invoke();
		}
		else{
			String result = null;
			AccessFuncMethod currentAccessFuncMethod = accessAuthMap.get(key);
			switch(currentAccessFuncMethod.getAffectRole()){
				case WeaConstant.SYS_ROLE_ADMIN:
					Admin admin = (Admin)session.get(WeaConstant.CURADMIN);
					if(admin==null){
						result = getNoLoginResponse(invocation,WeaConstant.ADMINLOGINPAGE);
					}else{
						if(admin.getReserveFlag()==1){
							result = invocation.invoke();
						}else{
						
							result = getNoAccessAuthResponse(invocation,currentAccessFuncMethod,admin.getAccessOperationList());
						}
					}
					break;
				case WeaConstant.SYS_ROLE_CUST:
					Customer cust = (Customer)session.get(WeaConstant.CURCUST);
					if(cust==null){
						result = getNoLoginResponse(invocation,WeaConstant.CUSTLOGINPAGE);
					}else{
						
						result = getNoAccessAuthResponse(invocation,currentAccessFuncMethod,cust.getAccessOperationList());
					}
					break;
				case WeaConstant.SYS_ROLE_OWNER:
					OwnerAdmin ownerAdmin = (OwnerAdmin)session.get(WeaConstant.CUROWNERADMIN);
					if(ownerAdmin==null){
						result = getNoLoginResponse(invocation,WeaConstant.OWNERADMINLOGINPAGE);
					}else{
						
						if(ownerAdmin.getReserveFlag()==1){
							result = invocation.invoke();
						}else{
						
							result = getNoAccessAuthResponse(invocation,currentAccessFuncMethod,ownerAdmin.getAccessOperationList());
						}
					}
					break;
				default:
					result = WeaConstant.FORBIDDENINPAGE;
			}
			return result;
		}
	}
	
	private String getNoLoginResponse(ActionInvocation invocation,String loginPage) throws Exception{
		
		if(isAjaxResponse(invocation)){
			WeaResponse weaResponse = new WeaResponse();
			weaResponse.setFailStatus();
			weaResponse.setMessage("您还没有登录");
			ActionContext.getContext().getValueStack().set(WeaConstant.RESPONSEROOT, weaResponse);
			return WeaConstant.JSONRESPONSE;
		}else{
			return loginPage;
		}
	}
	
	private String getNoAccessAuthResponse(ActionInvocation invocation,AccessFuncMethod currentAccessFuncMethod,List<AccessOperation> accessOperationList) throws Exception{
		for(AccessOperation accessOperation:accessOperationList){
			if(accessOperation.getModuleName().equalsIgnoreCase(currentAccessFuncMethod.getModuleName())
					&&accessOperation.getOperationName().equalsIgnoreCase(currentAccessFuncMethod.getOperationName())){
				return invocation.invoke();
			}
		}
		return WeaConstant.FORBIDDENINPAGE;
	}


	@SuppressWarnings("unused")
	private boolean isAjaxRequest(){
		String requestType = ServletActionContext.getRequest().getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {
			return true;
		} else {
			return false; 
		}
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
