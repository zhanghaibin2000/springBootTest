package com.zhb.server.webfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*
 * springBoot和webFilter整合方式
 * 1:实现javax.servlet.Filter并添加注解@WebFilter
 * 2：springBoote启动器添加@ServletComponentScan扫描
 * */

/*
 * <filter>
		<filter-name>filterFirst</filter-name>
		<filter-class>com.zhb.server.webfilter.FilterFirst</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>filterFirst</filter-name>
		<url-pattern>/servletTestFirst</url-pattern>
	</filter-mapping>
 * */

@WebFilter(filterName="filterFirst", urlPatterns="/servletTestFirst")
public class FilterFirst implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化FilterFirst");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入FilterFirst");
		chain.doFilter(request, response);
		System.out.println("结束FilterFirst");
	}

	@Override
	public void destroy() {
		System.out.println("FilterFirst结束处理");
	}

}
