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
@WebServlet("/downloadurl")
public class File_Download extends HttpServlet {
	@Resource(name="DsJndi")
	private DataSource ds;
	//private final static String SELECTQUERY="SELECT PID,PNAME,PHOTO,RESUME FROM FILEUPLOADANDDOWNLOAD";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          Connection con=null;
          PreparedStatement ps=null;
          InputStream is=null;
         
		//create output stream for read binary data
		ServletOutputStream sos=null;
		String param=null,filepath=null,mimetypes=null;;
		param=req.getParameter("type");
		sos=res.getOutputStream();
		if(param.equalsIgnoreCase("report")) {
			try {
				con=ds.getConnection();
				res.setContentType("text/html");
				String SELECTQUERY="SELECT PID,PNAME,PHOTO,RESUME FROM FILEUPLOADANDDOWNLOAD";
				ps=con.prepareStatement(SELECTQUERY);
				ResultSet rs=null;
				rs=ps.executeQuery();
				sos.println("<h1 style='color:red;text-align:center'>File Download</h1>");
				sos.println("<table border='1' bgcolor='cyan' align='center'");
				while(rs.next()) {
					sos.println("<tr><th>Person Id</th><th>Person Name</th><th>Photo</th><th>Resume</th></tr>");
					sos.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+
							"</td><td><img src="+rs.getString(3)+" width='50' height='50'><a href='downloadurl?type=&path="+rs.getString(3)+
							"'>Download</a></td><td><img src="+rs.getString(4)+"><a href='downloadurl?type=&path="+rs.getString(4)+"'>Download</a></td></tr>");
				}
				sos.println("</table>");
				
				
				
				
				
			}catch(Exception e){
				e.printStackTrace();
				sos.println("<h1 style='color:red;text-align:center'>Internal Problem</h1>");
			}finally {
				try {
					if(ps!=null)
						ps.close();
				}catch(Exception e) {
					e.printStackTrace();
				}try {
					if(con!=null)
						con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			
		}else {
			filepath=req.getParameter("path");
			System.out.println(req.getParameter("path"));
			File f=new File(filepath);
			res.setContentLengthLong(f.length());
			mimetypes=getServletContext().getMimeType(filepath);
			res.setContentType(mimetypes!=null?mimetypes:"application/octet-stream");
			res.addHeader("Content-disposition","attachment;filename="+f.getName());
			is=new FileInputStream(f);
			IOUtils.copy(is, sos);
			sos.println("<a href='index.html'>Home</a>");
			sos.close();
			
			
			
		}
		
		
		
	
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	

}
