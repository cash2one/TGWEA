package com.etaoguan.wea.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaLogInfo;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.vo.AccessFuncMethod;
import com.etaoguan.wea.vo.MethodLog;

public class AnnoUtil {
	
	public static HashMap<String, AccessFuncMethod> getAccessAuthMap(){
		
		HashMap<String,AccessFuncMethod> accessAuthMap = new HashMap<String, AccessFuncMethod>();
		addAdminAccessAuthMap(accessAuthMap);
		addCustAccessAuthMap(accessAuthMap);
		addOwnerAccessAuthMap(accessAuthMap);
		return accessAuthMap;
	}
	
	private static void addAdminAccessAuthMap(HashMap<String,AccessFuncMethod> accessAuthMap){
		
		addAccessAuthMap(getAdminActionClassSet(),WeaConstant.SYS_ROLE_ADMIN,accessAuthMap);

	}
	
	private static void addCustAccessAuthMap(HashMap<String,AccessFuncMethod> accessAuthMap){
		
		addAccessAuthMap(getCustActionClassSet(),WeaConstant.SYS_ROLE_CUST,accessAuthMap);

	}
	
	private static void addOwnerAccessAuthMap(HashMap<String,AccessFuncMethod> accessAuthMap){

		addAccessAuthMap(getOwnerActionClassSet(),WeaConstant.SYS_ROLE_OWNER,accessAuthMap);

	}
	@SuppressWarnings("rawtypes")
	private static void addAccessAuthMap(Set<Class> classes ,int authRole,HashMap<String,AccessFuncMethod> accessAuthMap ){
		
		Class<WeaModule> moduleAnno = WeaModule.class;
		Class<WeaFunction> functionAnno = WeaFunction.class;
		
		for (Class<?> item : classes) {
			WeaModule classs  = item.getAnnotation(moduleAnno);
			String moduleName = null;
			if(classs != null ){
				moduleName = classs.mname();
				Method[] methods = item.getMethods();
				for (Method method : methods) {
					if(method.isAnnotationPresent(functionAnno)){
						String classMethod = method.getDeclaringClass().getName()+ "."+method.getName() ;
						String functionName = method.getAnnotation(functionAnno).fname();
						String operationName = method.getAnnotation(functionAnno).oname().toString();
						AccessFuncMethod accessFuncMethod = new AccessFuncMethod();
						accessFuncMethod.setClassMethod(classMethod);
						accessFuncMethod.setFunctionName(functionName);
						accessFuncMethod.setOperationName(operationName);
						accessFuncMethod.setModuleName(moduleName);
						accessFuncMethod.setAffectRole(authRole);
						accessAuthMap.put(classMethod, accessFuncMethod);
	
					}
				}
			}
		}
	
	}
	
	public static HashMap<String, MethodLog> getMethodLogInfo(){
		
		HashMap<String,MethodLog> methodLogInfoMap = new HashMap<String, MethodLog>();	
		addAdminMethodLogMap(methodLogInfoMap);
		addCustMethodLogMap(methodLogInfoMap);
		addOwnerMethodLogMap(methodLogInfoMap);
		return methodLogInfoMap;
	}
	
	private static void addAdminMethodLogMap(HashMap<String,MethodLog> methodLogMap){

		addMethodLogMap(getAdminActionClassSet(),WeaConstant.SYS_ROLE_ADMIN,methodLogMap);

	}
	
	private static void addCustMethodLogMap(HashMap<String,MethodLog> methodLogMap){

		addMethodLogMap(getCustActionClassSet(),WeaConstant.SYS_ROLE_CUST,methodLogMap);

	}
	
	private static void addOwnerMethodLogMap(HashMap<String,MethodLog> methodLogMap){
		
		addMethodLogMap(getOwnerActionClassSet(),WeaConstant.SYS_ROLE_OWNER,methodLogMap);

	}

	@SuppressWarnings("rawtypes")
	private static Set<Class> getAdminActionClassSet(){
		List<String> packagePathList = new ArrayList<String>();
		packagePathList.add("com.etaoguan.wea.client.mobile.action.admin");
		packagePathList.add("com.etaoguan.wea.client.web.action.admin");
		return getClassSetByPackagePath(packagePathList);
	} 
	@SuppressWarnings("rawtypes")
	private static Set<Class> getCustActionClassSet(){
		List<String> packagePathList = new ArrayList<String>();
		packagePathList.add("com.etaoguan.wea.client.mobile.action.cust");
		packagePathList.add("com.etaoguan.wea.client.web.action.cust");
		return getClassSetByPackagePath(packagePathList);
	} 
	@SuppressWarnings("rawtypes")
	private static Set<Class> getOwnerActionClassSet(){
		List<String> packagePathList = new ArrayList<String>();
		packagePathList.add("com.etaoguan.wea.client.mobile.action.owner");
		packagePathList.add("com.etaoguan.wea.client.web.action.owner");
		return getClassSetByPackagePath(packagePathList);
	} 
	
	@SuppressWarnings("rawtypes")
	private static void addMethodLogMap(Set<Class> classes ,int operatorRole,HashMap<String,MethodLog> methodLogMap ){
			
		for(Class clz:classes){
	    	Method[] methods = clz.getMethods();
	    	for(Method method:methods){
	    		if(method.getAnnotation(WeaLogInfo.class)!=null){
	    			String classMethod = method.getDeclaringClass().getName()+ "."+method.getName() ;
	    			MethodLog methodLog = new MethodLog();
	    			methodLog.setClassName(clz.getName());
	    			methodLog.setMethodName(method.getName());
	    			methodLog.setInfo(method.getAnnotation(WeaLogInfo.class).loginfo());
	    			methodLog.setOperatorRole(operatorRole);
	    			methodLogMap.put(classMethod, methodLog);
	    		}
	    	}
	    }
	}
	
	@SuppressWarnings("rawtypes")
	private static Set<Class> getClassSetByPackagePath(List<String> packagePathList){
		Set<Class> classSet = new LinkedHashSet<Class>();
		for(String packagePath:packagePathList){
			classSet.addAll(ClassPathScanManager.getClasses(packagePath));
		}
		return classSet;
	}
}
