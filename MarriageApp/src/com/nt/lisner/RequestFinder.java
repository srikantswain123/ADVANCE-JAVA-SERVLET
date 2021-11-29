package com.nt.lisner;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

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
		sc.log(((HttpServletRequest) sre.getServletRequest()).getRequestURL()+" has Taken "+(end-start)+" ms");
	}
}
