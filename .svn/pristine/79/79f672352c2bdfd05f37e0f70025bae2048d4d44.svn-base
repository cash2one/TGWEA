package com.etaoguan.wea.vo;

public class AccessOperation {
	private String moduleName;
	private String operationName;
	private int affectRole;
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
	@Override
	public boolean equals(Object o){
		if(this==o) return true;
		if (!(o instanceof AccessOperation)) return false;
		final AccessOperation accessFunc=(AccessOperation)o;
		if ((this.operationName==accessFunc.getOperationName()||this.operationName.equals(accessFunc.getOperationName()))
			&&(this.moduleName==accessFunc.getModuleName()||this.moduleName.equals(accessFunc.getModuleName()))
			&&this.affectRole==accessFunc.getAffectRole())
		    return true;
		else
		  return false;
	}
	public int getAffectRole() {
		return affectRole;
	}
	public void setAffectRole(int affectRole) {
		this.affectRole = affectRole;
	}
}
