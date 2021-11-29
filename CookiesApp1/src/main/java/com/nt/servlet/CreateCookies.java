package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/curl")
public class CreateCookies extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//create printWriter Object
		pw=res.getWriter();
		//set response Content Type
		res.setContentType("text/html");
		//create inmemory cookies
		Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		//asign value into cookie
		ck1=new Cookie("name", "raja");
		ck2=new Cookie("addr","mumbai");
		
		//create persistent Cookies
		 ck3=new Cookie("gujurat", "gandhinagr");
		 ck4=new Cookie("ladakh", "leh");
		 ck3.setMaxAge(120);
		 ck4.setMaxAge(60);
		 
		 res.addCookie(ck1);
		 res.addCookie(ck2);
		 res.addCookie(ck3);
		 res.addCookie(ck4);
pw.println("<h1 style='color:red;text-align'>cookies Created</h1>");		
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				doGet(req, res);
	}

}
