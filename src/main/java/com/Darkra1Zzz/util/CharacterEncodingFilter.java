package com.Darkra1Zzz.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*")
public class CharacterEncodingFilter implements Filter {

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器实例化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
//		httpServletRequest.setCharacterEncoding("utf-8");
//		chain.doFilter(httpServletRequest, httpServletResponse);
//		httpServletResponse.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request,response);
		response.setCharacterEncoding("utf-8");
	}
	
	

	@Override
	public void destroy() {
		System.out.println("过滤器销毁");
	}

}
