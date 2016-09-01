package com.etaoguan.wea.service;

import javax.servlet.http.HttpServletRequest;

public interface IAccessCheckService {
	
	public boolean needCheckAccessAuth(String accessPath);
	
	public boolean isLogined(int accessRole);
	
	public boolean checkAccessAuth(String accessPath);
	
	public boolean isMobileAccess(String accessPath);
	
	public boolean isAjaxRequest(HttpServletRequest request);
	
	public boolean isJsonResponse(HttpServletRequest request);
	
	public boolean isValidOwner();

}
