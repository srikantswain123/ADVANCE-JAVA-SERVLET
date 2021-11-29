package com.nt.lisner;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
@WebListener
public class RequestFinder implements ServletRequestListener {
	private long start,end;
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		start=System.currentTimeMillis();
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		end=System.currentTimeMillis();
		
		ServletContext sc=sre.getServletContext();
		System.out.println(((HttpServletRequest) sre.getServletRequest()).getRequestURL()+" has Taken "+(end-start)+" ms");
	}
}
