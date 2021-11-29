package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/surl")
public class SecondServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		
		res.setContentType("text/html");
		String pname=null,addr=null,ms=null,spn=null,cn=null;
	HttpSession ses=null;
	//get Session Object
	ses=req.getSession(false);
	pw.println("<b>"+ses.getId()+"<br>"+ses.isNew()+"</b>");
	
	pname=(String)ses.getAttribute("name");
	addr=(String)ses.getAttribute("addr");
	ms=(String)ses.getAttribute("ms");
	spn=req.getParameter("spn");
	cn=req.getParameter("cn");
	
	pw.println("<h1 style='color:green;text-align'>Person name"+pname+"</h1>");
	pw.println("<h1 style='color:green;text-align'>Person addr"+pname+"</h1>");
	pw.println("<h1 style='color:green;text-align'>"+spn+" "+cn+"</h1>");
	
	
	
	
	pw.close();
	
	
		
		
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
