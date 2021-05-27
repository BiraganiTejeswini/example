package com.jdbc.examples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConnection
{

	static final String url = "jdbc:mysql://localhost:3306/assignment";
	static final String user = "root";
	static final String pwd = "9606";
	public DBConnection()
	{
		
	}
	private static Connection con=null;
	public static Connection getConection()
	{
		
		try {
			if(con==null) {
			con=DriverManager.getConnection(url,user,pwd);
			Statement stmt=con.createStatement(); 
			//table creation using create
			String tablecreation=("create table studentdetails(sid int primary key,sname varchar(50),scourse varchar(50))");
			stmt.executeUpdate(tablecreation);
			System.out.println("Table is created.....");
			//Inserting values 
			String insertvalues=("insert into studentdetails values(1,'tejaswini','btech'),(2,'keerthi','MBA'),"
					+ "(3,'vidya','medicine'),(4,'radha','medicine')");
			stmt.executeUpdate(insertvalues);
			System.out.println("Values are inserted.....");
			//using select statement
			System.out.println("Before Updating...........");
			ResultSet rs=stmt.executeQuery("select * from studentdetails");  
			while(rs.next())
			{ 
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));  
			}
			String update=("update student11 set scourse='fashion design' where sid=3 ");
			stmt.executeUpdate(update);
			String del=("delete from student11 where sid=4");
			stmt.executeUpdate(del);
			System.out.println("After updating and deleting.....");
			ResultSet rs1=stmt.executeQuery("select * from student11");  
			while(rs1.next())
			{ 
			System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+" "+ rs1.getString(3));  
			}
		    }
			}
			catch(Exception e)
			{ System.out.println(e);
			}
	
		return con;
		
		
	}
	}
