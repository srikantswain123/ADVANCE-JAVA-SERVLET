package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/usaurl")
public class AmericanServlet extends HttpServlet {
  @Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=null;
	  pw=res.getWriter();
	  String usSallary=req.getParameter("ins");
	  int sallary=Integer.parseInt(usSallary)+100000;
	  pw.println("<h1 style='color:red;text-align:center'>American sallaary::"+sallary+"</h1>");
	
}
  @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doPost(req,res);
	}

}
