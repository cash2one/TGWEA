package com.etaoguan.wea.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class WebFilter implements javax.servlet.Filter {

	private FilterConfig f=null;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//在session中添加DefaultSavedRequest
//		HttpServletRequest req=(HttpServletRequest)arg0;
//		HttpServletResponse res=(HttpServletResponse)arg1;
		//ThreadUtil.putRequest(req,res);
		arg1.setCharacterEncoding(f.getInitParameter("encoding"));
		try{
			arg2.doFilter(arg0, arg1);
		}catch (IOException e) {
			throw e;
		}catch ( ServletException e1) {
				throw e1;
		}finally{
		}
			
	}

	@Override
	public void init(FilterConfig f) throws ServletException {
		this.f=f;

	}

}
