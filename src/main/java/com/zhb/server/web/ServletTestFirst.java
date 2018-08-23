package com.zhb.server.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.ServletComponentScan;


/*
 * springBoot和servlet整合方式1
 * 1：继承javax.servlet.http.HttpServlet并添加@WebServlet注解
 * 2：springBoote启动器添加@ServletComponentScan扫描
 * */

/*
 * <servlet>
		<servlet-name>servletTestFirst</servlet-name>
		<servlet-class>com.zhb.server.web.ServletTestFirst</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>servletTestFirst</servlet-name>
		<url-pattern>/servletTestFirst</url-pattern>
	</servlet-mapping>
 * */

@WebServlet(name = "servletTestFirst", urlPatterns = "/servletTestFirst")
public class ServletTestFirst extends HttpServlet{
	private static final long serialVersionUID = 7658481975023951467L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servletTestFirst");
	}
}
