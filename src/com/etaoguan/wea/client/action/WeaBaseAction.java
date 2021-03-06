package com.etaoguan.wea.client.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.util.AppSessionUtil;
import com.etaoguan.wea.vo.Admin;
import com.etaoguan.wea.vo.Customer;
import com.etaoguan.wea.vo.OwnerAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class WeaBaseAction extends ActionSupport implements SessionAware{

	private final static String[] LOGINROLES = new String[]{WeaConstant.CUROWNERADMIN,WeaConstant.CURCUST,WeaConstant.CURADMIN};

	private static final long serialVersionUID = 7817071812096412211L;
	private final static Log logger = LogFactory.getLog(WeaBaseAction.class);

	protected SortParam sortParam = new SortParam();
	

	
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected String getRequestParamValue(String paramName) {
		return getRequest().getParameter(paramName);
	}

	protected HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	
	protected Object getSessionAttribute(String attrName) {
		return getSession().getAttribute(attrName);
	}
	
	protected void removeSessionAttribute(String attrName) {
		getSession().removeAttribute(attrName);
	}
	
	protected void setLoginSessionAttribute(String attrName,Object attrValue) {

		clearLoginSession();
		setSessionAttribute(attrName,attrValue);	
	}
	
	private void clearLoginSession(){
		for(String loginRole:LOGINROLES){
			removeSessionAttribute(loginRole);
		}	
	}
	
	protected void setSessionAttribute(String attrName,Object attrValue) {
		getSession().setAttribute(attrName,attrValue);
	}
	
	public OwnerAdmin getCurrentOwnerAdmin() {
		return (OwnerAdmin)getSessionAttribute(WeaConstant.CUROWNERADMIN);
	}
	
	public Customer getCurrentCust() {
		return (Customer)getSessionAttribute(WeaConstant.CURCUST);
	}
	
	public Admin getCurrentAdmin() {
		return (Admin)getSessionAttribute(WeaConstant.CURADMIN);
	}
	
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected String getDomainBaseUrl(){
		HttpServletRequest request = getRequest();
		StringBuffer domainBaseUrl = new StringBuffer();
		domainBaseUrl.append(request.getScheme());
		domainBaseUrl.append("://");
		domainBaseUrl.append(request.getServerName().toLowerCase());
		domainBaseUrl.append(":");
		domainBaseUrl.append(request.getServerPort());
		domainBaseUrl.append(request.getContextPath());
		domainBaseUrl.append("/");
		
		return domainBaseUrl.toString().replaceAll(":80/", "/");
	}

	public String htmlspecialchars(String str) {
		if (str == null)
			return str;
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}

	protected boolean isGetRequest() {
		boolean isGet = true;
		String method = ServletActionContext.getRequest().getMethod();
		if("post".equalsIgnoreCase(method)){
			isGet = false;
		}
		return isGet;
	}
	
	public String getIpAddr() {
		String ip = getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getRemoteAddr();
		}
		return ip;
	}


	public SortParam getSortParam() {
		return sortParam;
	}

	public void setSortParam(SortParam sortParam) {
		this.sortParam = sortParam;
	}

	@Override
	public void setSession(Map<String, Object> attrs) {
		
		String operator = "";
		if(attrs.get(WeaConstant.CUROWNERADMIN)!=null){
			operator = ((OwnerAdmin)attrs.get(WeaConstant.CUROWNERADMIN)).getAdminName();
		}else if(attrs.get(WeaConstant.CURADMIN)!=null){
			operator = ((Admin)attrs.get(WeaConstant.CURADMIN)).getAdminName();
		}else if(attrs.get(WeaConstant.CURCUST)!=null){
			operator = ((Customer)attrs.get(WeaConstant.CURCUST)).getCustName();
		}
		AppSessionUtil.getAppSession().setOperator(operator);
	

	}

	public void writeResponse(String responseMsg){
		try {
			/*ServletActionContext.getResponse().setContentType(
					"text/xml;charset=UTF-8");*/
			ServletActionContext.getResponse().setHeader("Cache-Control",
					"no-cache");
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(responseMsg);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
