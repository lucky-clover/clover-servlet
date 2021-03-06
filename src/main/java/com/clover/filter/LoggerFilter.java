package com.clover.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(filterName = "LoggerFilter", urlPatterns = "/*", 
		   initParams = {@WebInitParam(name = "name", value = "clover")})
public class LoggerFilter implements Filter {
	private String name;
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(request.getRemoteHost());
		System.out.println(response.getContentType());
		System.out.println("----------------------------------" + name);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("日志过滤器~");
		System.out.println("请求参数：" + fConfig.getInitParameter("name"));
		name = fConfig.getInitParameter("name");
	}
}
