package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
@WebServlet("/rdurl")
public class TestServlet extends HttpServlet {
	@Resource(name="DsJndi")
	DataSource ds=null;
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String empno=req.getParameter("empno");
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");


		Connection con=null;
		PreparedStatement ps=null;
		RequestDispatcher rd=null,rd1=null,rd2=null;
		String query="SELECT * FROM EMPLOYE WHERE EMPNO=?";
		try {
			
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(empno));
			ResultSet rs=null;
			rs=ps.executeQuery();
			rd=req.getRequestDispatcher("/headerurl");
			rd.include(req, res);
			if(rs.next()) {
				pw.println("<table border='1' bgcolor='cyan' align='center'>");
				pw.println("<tr><th>Empno</th><th>Empname</th><th>Age</th><th>Sallary</th></tr>");
				pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getFloat(4)+"</td></tr>");
                pw.println("</table>");
			}



			rd1=req.getRequestDispatcher("footer.html");
			rd1.include(req, res);
			pw.println("<a href='index.html'>HOME</a>");
		}catch(Exception e) {
			e.printStackTrace();
			rd2=req.getRequestDispatcher("/errurl");
			rd2.forward(req, res);


		}finally {
			try {
				con.close();
				ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}


	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
