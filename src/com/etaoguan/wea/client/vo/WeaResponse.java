package com.etaoguan.wea.client.vo;

import java.util.HashMap;
import java.util.Map;

public class WeaResponse {

	public static final String SUCCESS = "S", FAIL = "F";
	private String status = SUCCESS;
	private String message;
	private int errorLevel;
	private String errorType;
	private String respFrom = "wea";
	@SuppressWarnings("rawtypes")
	private Map extFields = new HashMap();
	private Object respData;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorLevel() {
		return errorLevel;
	}
	public void setErrorLevel(int errorLevel) {
		this.errorLevel = errorLevel;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getRespFrom() {
		return respFrom;
	}
	public void setRespFrom(String respFrom) {
		this.respFrom = respFrom;
	}
	@SuppressWarnings("rawtypes")
	public Map getExtFields() {
		return extFields;
	}
	@SuppressWarnings("rawtypes")
	public void setExtFields(Map extFields) {
		this.extFields = extFields;
	}
	public void setSuccessStatus() {
		this.status = SUCCESS;
	}
	
	public void setFailStatus() {
		this.status = FAIL;
	}
	public Object getRespData() {
		return respData;
	}
	public void setRespData(Object respData) {
		this.respData = respData;
	}
}
