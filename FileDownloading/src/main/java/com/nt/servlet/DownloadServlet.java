package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
@WebServlet("/Downloadurl")
public class DownloadServlet extends HttpServlet {
	private final static String FILE_DOWNLOAD_QUERY="SELECT CID,CNAME,CPOTO,CRESUME FROM UPLOAD_FILE";
	@Resource(name="DsJndi")
	private DataSource ds=null;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param=null;
		//get Output Stream 
		ServletOutputStream sos=null;
		//get response OutpUt Stream Object
		sos=res.getOutputStream();
		//set response object
		res.setContentType("text/html");
		Connection con=null;
		File f=null;
		String filepath=null,mimetype=null;
		InputStream is=null;
		
		
		
		//get prepaired Statement
		PreparedStatement ps=null;
		ResultSet rs=null;
		param=req.getParameter("type");
		
			if(param.equalsIgnoreCase("report")) {
				try {
				con=ds.getConnection();
				ps=con.prepareStatement(FILE_DOWNLOAD_QUERY);
				rs=ps.executeQuery();
				System.out.println(req.getParameter("type"));
				sos.println("<table border='1' bgcolor='cyan' align='center'>");
				sos.println("<tr><th>Customer Id</th><th>Customer Name</th><th>customer Photo</th><th>Customer Resume</th>");
				while(rs.next()) {
					sos.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+
							"</td><td><a href='Downloadurl?type=&path="+rs.getString(3)+
							"'>download </a></td><td><a href='Downloadurl?type=&path="
								+rs.getString(4)+"'>download</a></td></tr>");

				}
				sos.println("</table>");


			}
		catch(Exception e) {
			sos.println("<h1 style='color:red;text-align:center'>InterNal Problem</h1>");
			e.printStackTrace();
		}
			}else {
				filepath=req.getParameter("path");
				System.out.println(req.getParameter("path"));
				System.out.println("filepath::"+filepath.length());
				f=new File(filepath);
				System.out.println("file::"+f.length());
				res.setContentLengthLong(f.length());
				mimetype=getServletContext().getMimeType(filepath);
				res.setContentType(mimetype!=null?mimetype:"application/octet-stream");
				is=new FileInputStream(f);
				res.addHeader("Content-Disposition","attachment;filename="+f.getName());
				IOUtils.copy(is, sos);
				
			}

	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
