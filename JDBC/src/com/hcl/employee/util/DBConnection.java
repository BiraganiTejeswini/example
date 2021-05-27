package com.hcl.employee.util;
import java.sql.*;
public class DBConnection
{

	static final String url = "jdbc:mysql://localhost:3306/jdbc";
	static final String user = "root";
	static final String pwd = "9606";
	public DBConnection()
	{
		
	}
	private static Connection con=null;
	public static Connection getConection()
	{
		
		try {
			if(con==null) 
			con=DriverManager.getConnection(url,user,pwd);
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			}
	
		return con;
	}
	}
