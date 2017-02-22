package com.praveen.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.praveen.query.QueryConstants;
import com.praveen.utility.JdbcUtility;

/**
 * Servlet implementation class RetriveServlet
 */
@WebServlet("/RetriveServlet")
public class RetriveServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public RetriveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
    PreparedStatement ps=null;
    
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			con=JdbcUtility.getConnection();
			ps=con.prepareStatement(QueryConstants.select_query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("init Method");
	}


	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	ResultSet rs=null;
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=response.getWriter();
		int eno=Integer.parseInt(request.getParameter("eno"));
		try {
			ps.setInt(1,eno);
			rs=ps.executeQuery();
			if(rs.next())
			{
				pw.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				pw.println("<br><a href=Insert.html>Insert data</a><br>");
				pw.println("<br><a href=Retrive.html>Retrive data</a><br>");
				pw.println("<br><a href=Modify.html>Modify data</a><br>");
				pw.println("<br><a href=Delete.html>Delete Data</a><br>");
			}
			else
			{
				pw.println("Unble to Retive the record plz try once again");
				pw.println("<br><a href=Insert.html>Insert data</a><br>");
				pw.println("<br><a href=Retrive.html>Retrive data</a><br>");
				pw.println("<br><a href=Modify.html>Modify data</a><br>");
				pw.println("<br><a href=Delete.html>Delete Data</a><br>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
