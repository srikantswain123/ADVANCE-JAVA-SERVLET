package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/surl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		String pname=null,addr=null,ms=null,f1s=null,f1c=null;
		
		f1s=req.getParameter("f1s");
		f1c=req.getParameter("f1c");
		Cookie cks[]=req.getCookies();
		if(cks!=null) {
			pname=cks[0].getValue();
			addr=cks[1].getValue();
			ms=cks[2].getValue();
		}
		pw.println("<b>Person name::"+pname+"&nbsp;"+ms);
		pw.println("<b>Person Address::"+addr);
		pw.println("<b> Marital status::"+ms);
		pw.println("<b1>"+f1s);
		pw.println("<b1>"+f1c);
		
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
