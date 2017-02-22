package com.praveen.handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public CreateServlet() {
        super();
        System.out.println("Constructor");
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
			ps=con.prepareStatement(QueryConstants.create_query);
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
		System.out.println("destroy");
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
