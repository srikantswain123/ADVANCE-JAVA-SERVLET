package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;
@WebServlet("/uploadurl")
public class File_Upload extends HttpServlet {
	private final static String INSERT="INSERT INTO FILEUPLOADANDDOWNLOAD VALUES(SEQ_NO.NEXTVAL,?,?,?)";
	@Resource(name="DsJndi")
	private DataSource ds;
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw=null;
		//get Response Object
		pw=res.getWriter();
		//create Multi Part Request Object
		MultipartFormDataRequest mreq=null;
		//create Upload Beanjar
		UploadBean bean=null;
		Connection con=null;
		PreparedStatement ps=null;
		String name=null,frame1=null,frame2=null;
		Hashtable map=null;
		try {
			con=ds.getConnection();
			mreq=new MultipartFormDataRequest(req);
			bean=new UploadBean();
			bean.setFolderstore("c:/store");
			bean.setOverwrite(false);
			name=mreq.getParameter("pname");
			bean.store(mreq,"photo");
			bean.store(mreq,"resume");
			map=mreq.getFiles();
			frame1=((UploadFile)map.get("photo")).getFileName();
			frame2=((UploadFile)map.get("resume")).getFileName();
			ps=con.prepareStatement(INSERT);
			ps.setString(1,name);ps.setString(2,getServletContext().getInitParameter("location")+ frame1);
			ps.setString(3,getServletContext().getInitParameter("location")+ frame2);
			int count=ps.executeUpdate();
			String Result=count==0?"invalid type":"sucessfully submited";
			pw.println("<h1 style='color:red;text-align:center'>"+Result+"</h1>");

		}catch(Exception e) {
			pw.println("<h1 style='color:red;text-align:center'>Interna Problem</h1>");
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			pw.println("<a href='index.html'>Home</a>");
			pw.close();
		}


	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
