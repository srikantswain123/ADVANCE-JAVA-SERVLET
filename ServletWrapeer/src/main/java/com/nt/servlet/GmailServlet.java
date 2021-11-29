package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/curl")
public class GmailServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = res.getWriter();
		String gmail = null;
		gmail = req.getParameter("uname");
		if (gmail.equals("srikant@gmail.com")) {
			pw.println("<h1 style='color:green;text-align:center'>Valid Credential</h1>");
		} else {
			pw.println("<h1 style='color:red;text-align:center'>InValid Credential</h1>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
