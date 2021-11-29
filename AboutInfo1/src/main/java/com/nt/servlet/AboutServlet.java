package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/about1url")
public class AboutServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String sno=null,sname=null;
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("hello");
		sno=req.getParameter("sno");
		sname=req.getParameter("sname");
		res.sendRedirect("http://localhost:4646/AaboutInfo2/about2url?eno="+sno+"&ename="+sname);
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
