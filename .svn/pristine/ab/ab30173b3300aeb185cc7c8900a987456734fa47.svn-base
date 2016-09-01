package com.etaoguan.wea.client.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etaoguan.wea.common.WeaApplication;

public class GenerateStaticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer domainBaseUrl = new StringBuffer();
		domainBaseUrl.append(request.getScheme());
		domainBaseUrl.append("://");
		domainBaseUrl.append(request.getServerName().toLowerCase());
		domainBaseUrl.append(":");
		domainBaseUrl.append(request.getServerPort());
		domainBaseUrl.append(request.getContextPath());
		domainBaseUrl.append("/");
		
		String baseUrl =  domainBaseUrl.toString().replaceAll(":80/", "/");
		
		
		String servletPath = WeaApplication.getInstance().getAppRealPath();
		String htmlName = String.valueOf(Math.random())+".html";
		
		String fromUrl=baseUrl+"index.jsp";//the jsp page which will create
		String toUrl=servletPath+htmlName;// the created html page  
		new StaticHtml().process(fromUrl,toUrl);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
