package com.zhb.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.zhb.server.web.ServletTestSecond;
import com.zhb.server.webListener.ListenerSecond;
import com.zhb.server.webfilter.FilterSecond;

@SpringBootApplication
@ServletComponentScan//在springBoote启动时会扫描web相关的注解，包括(@WebServlet\@WebFilter)
public class BootStart {

	public static void main(String[] args){  
        SpringApplication.run(BootStart.class, args);
   }
	
	/*
	 * springBoot和servlet整合方式2
	 * 1：编写注册servlet的方法如下
	 * 2：servlet方法方法上添加@Bean注解
	 * */
	@Bean
	public ServletRegistrationBean<ServletTestSecond> getServletRegistrationBean() {
		ServletRegistrationBean<ServletTestSecond> bean = new ServletRegistrationBean<ServletTestSecond>(new ServletTestSecond());
		bean.addUrlMappings("/servletTestSecond");
		return bean;
	}
	
	/*
	 * springBoot和webFilter整合方式2
	 * 1：编写注册filter的方法如下
	 * 2：filter方法方法上添加@Bean注解
	 * */
	@Bean
	public FilterRegistrationBean<FilterSecond> getFilterRegistrationBean() {
		FilterRegistrationBean<FilterSecond> bean = new FilterRegistrationBean<FilterSecond>(new FilterSecond());
		bean.addUrlPatterns("/servletTestSecond");
		return bean;
	}
	
	/*
	 * springBoot和webListener整合方式2
	 * 1：编写注册webListener的方法如下
	 * 2：webListener方法方法上添加@Bean注解
	 * */
	@Bean
	public ServletListenerRegistrationBean<ListenerSecond> ServletListenerRegistrationBean() {
		ServletListenerRegistrationBean<ListenerSecond> bean = new ServletListenerRegistrationBean<ListenerSecond>(new ListenerSecond());
		return bean;
	}
}
