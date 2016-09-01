package com.etaoguan.wea.common;

public enum Operation {
	CREATE("create"),READ("read"),UPDATE("update"),DELETE("delete");
	
	private String value;
	private Operation(String value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return value;
	}

}
