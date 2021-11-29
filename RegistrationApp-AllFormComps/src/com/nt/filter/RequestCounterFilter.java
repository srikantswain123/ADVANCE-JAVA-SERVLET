package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebFilter("/*")
public class RequestCounterFilter extends HttpFilter {
	int counter=0;
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		counter++;
		ServletContext sc=null;
		sc=getServletContext();
		sc.setAttribute("reqCount",counter);
		chain.doFilter(req, res);
		
		
	}
	
	

}
