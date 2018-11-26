package com.zhb.server.webListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerSecond implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ListenerSecond .... init");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
}
