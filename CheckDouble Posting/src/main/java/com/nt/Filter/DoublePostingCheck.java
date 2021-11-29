package com.nt.Filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/*")
public class DoublePostingCheck extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		int clientToken=0,serverToken=0;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		String method=null;
		method=req.getMethod();
		ses=req.getSession();
		if(method.equalsIgnoreCase("get")) {
			System.out.println("first if block");
			ses.setAttribute("stoken",new Random().nextInt(10000));
			System.out.println(ses.getAttribute("stoken"));
			chain.doFilter(req, res);
		}
		else {
			System.out.println(" first else block");
			serverToken=(int)ses.getAttribute("stoken");
			clientToken=Integer.parseInt(req.getParameter("ctoken"));
			if(serverToken==clientToken) {
				System.out.println("second if block");
				System.out.println(serverToken+"   "+clientToken);
				ses.setAttribute("stoken",new Random().nextInt(10000));
				System.out.println("///"+ses.getAttribute("stoken"));
				chain.doFilter(req, res);
			}else {
				System.out.println("second else block");
				System.out.println(serverToken+"   "+clientToken);
				rd=req.getRequestDispatcher("/errurl");
				rd.forward(req, res);
				
			}
			
		}
		
		
	}

}
