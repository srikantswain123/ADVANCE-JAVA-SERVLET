package com.nt.lisner;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class AppMaintannceListner implements ServletContextListener {
	private ServletContext sc;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sc=sce.getServletContext();
		sc.log("Web application is deployed or reloaded at"+new Date());
		
	}
  @Override
public void contextDestroyed(ServletContextEvent sce) {
	  
	  
	  sc.log("Web application undeployed and stopped at"+new Date());
	
}
}
