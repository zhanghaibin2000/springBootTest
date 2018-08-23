package com.zhb.server.webfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterSecond implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化FilterSecond");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入FilterSecond");
		chain.doFilter(request, response);
		System.out.println("结束FilterSecond");
	}

	@Override
	public void destroy() {
		System.out.println("FilterSecond结束处理");
	}
}
