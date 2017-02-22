package com.praveen.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcUtility {
	static Connection con=null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		System.out.println("Driver is Registerd");
		//Step2: Establish connection with DataBase Software
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
		if(con!=null)
			System.out.println("Connection is Established");
		else
			System.out.println("Connection is Not Established");
		return con;
		
	
	}
	
	public static void release(Connection con, Statement st) throws SQLException {
		// TODO Auto-generated method stub
		if(st!=null)
			System.out.println("st closed");
			st.close();
		if(con!=null)
			System.out.println("con closed");
			con.close();
	}
	public static void release(Connection con, Statement st, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		if(rs!=null)
			System.out.println("rs closed");
			rs.close();
		if(st!=null)
			System.out.println("st closed");
			st.close();
		if(con!=null)
			System.out.println("con closed");
			con.close();
	}
	public static void release(Connection con, Statement st, ResultSet rs, ResultSetMetaData rmd) throws SQLException {
		// TODO Auto-generated method stub
		if(rmd!=null)
			System.out.println("rmd closed");
			rs.close();
		if(rs!=null)
			System.out.println("rs closed");
			rs.close();
		if(st!=null)
			System.out.println("st closed");
			st.close();
		if(con!=null)
			System.out.println("con closed");
			con.close();
	}
	
	public static void release(Connection con, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if(ps!=null)
			ps.close();
		System.out.println("ps closed");
		if(con!=null)
			con.close();
		System.out.println("con closed");
	}

	public static void release(Connection con2) {
		// TODO Auto-generated method stub
		
	}
}
