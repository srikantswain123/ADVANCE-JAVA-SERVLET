package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/registerurl")
public class TimeCheckingFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		Calendar cl=null;
		cl=Calendar.getInstance();
		int time=cl.get(Calendar.HOUR_OF_DAY);
		if(time<8 || time>16) {
			pw.println("<h1 style='color:red;text-align:center'>Plz visit this site between 8 to 4 o clock</h1>");
			return;
		}else {
			chain.doFilter(req, res);
			
			
		}
	}

}
