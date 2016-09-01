package com.etaoguan.wea.vo;

public class AccessFuncMethod {
	private String moduleName;
	private String functionName;
	private String operationName;
	private String classMethod;
	private int affectRole;
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getClassMethod() {
		return classMethod;
	}
	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}
	public int getAffectRole() {
		return affectRole;
	}
	public void setAffectRole(int affectRole) {
		this.affectRole = affectRole;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
}
