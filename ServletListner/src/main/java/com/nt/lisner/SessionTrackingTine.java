package com.nt.lisner;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionTrackingTine implements HttpSessionListener {
	private long start,end;
	private ServletContext sc;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		start=System.currentTimeMillis();
		sc=se.getSession().getServletContext();
		System.out.println(("session started"+new Date()));
		
		
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		end=System.currentTimeMillis();
		sc=se.getSession().getServletContext();
		System.out.println(("session ended"+new Date()));
		System.out.println(("Session duration"+(end-start)+" ms"));
		
	}

}
