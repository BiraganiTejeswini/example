package com.hcl.employee.repositry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.hcl.employee.beans.*;
import com.hcl.employee.util.*;

public class EmployeeDAO 
{
	   Connection con= DBConnection.getConection();

	//table creation using create
	public   void createTable() {
		Statement stmt=null;
		try {
			stmt = con.createStatement();
			String tablecreation="create table Employee(id int primary key,ename varchar(50),"
					+ "designation varchar(50),loc varchar(50));";
		
		 stmt.executeUpdate(tablecreation);
		   } catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			closeStatement(stmt);		}

		}
	//inserting values
	public   int addDetails(Employee emp) throws UserDefinedException
	{
		PreparedStatement psstmt=null;
		
		int n=0;
		try 
		{   if(!searchById(emp.getId()))
		{
			String insertvalues="insert into employee values(?,?,?,?)";
			psstmt =con.prepareStatement(insertvalues);
			psstmt.setInt(1,emp.getId());
			psstmt.setString(2, emp.getEname());
			psstmt.setString(3, emp.getDesignation());
			psstmt.setString(4, emp.getLoc());
     		n=psstmt.executeUpdate();
		}
		else
		{
			 throw new UserDefinedException("Employee id already exsits");
		}
			
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		finally
		{
			closeStatement(psstmt);
		}
		return n;
		
	}
	//Executing select statement
	public   List<Employee> display() 
	{
		Statement stmt=null;
		ResultSet rs=null;

	      List<Employee> ls = new ArrayList<Employee>();
		try {
			stmt = con.createStatement();
			String str="select id,ename,designation,loc from employee";
			rs = stmt.executeQuery(str);
			while(rs.next())
			{ 
	            Employee emp = new Employee();
	            emp.setId(rs.getInt("id"));
	            emp.setEname(rs.getString("ename"));
	           emp.setDesignation(rs.getString("designation"));
	            emp.setLoc(rs.getString("loc"));
	           ls.add(emp); 
			}
		} catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
		
		return ls;  
		
	}
	//search byid to check primary key
	public  boolean searchById(int id)
	{
		PreparedStatement ps=null;	
		 try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM employee WHERE id = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			int n = 0;
			while ( rs.next() ) {
			    n = rs.getInt(1);
			
			}
			if ( n > 0 ) {
			   return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}

	//Searching the employee
	public   void search(int id) 
	{
		ResultSet rs=null;
		PreparedStatement ps=null;
		try 
		{
           String del = "select id,ename,designation,loc from employee where id =?";
            ps = con.prepareStatement(del);
        ps.setInt(1, id);
        rs = ps.executeQuery();
		while(rs.next())
		{ 
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
           
		}

		}catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			
			closeStatement(ps);
		}
	}
	//updating the employee details
	public  void update(Employee emp) throws UserDefinedException
	{
		PreparedStatement ps=null;
		
		try {
			 if(searchById(emp.getId()))
		{
			String update=("update employee set loc=? where id=?");
			ps=con.prepareStatement(update);
			ps.setString(1, emp.getLoc());
			ps.setInt(2, emp.getId());
			ps.executeUpdate();
		}
			 else {
				 throw new UserDefinedException("Employee id not found......");
			 }
		} catch (SQLException e) 
		   {
			// TODO Auto-generated catch block
			e.printStackTrace();
     		}
		finally
		{
			
			closeStatement(ps);
		}
		
	}
	//deleting the employee details
	public  void delete(Employee emp) throws UserDefinedException
	{
		PreparedStatement ps=null;
		try 
		{
			 if(searchById(emp.getId()))
				{
			String del = "delete from employee where id =?";
            ps = con.prepareStatement(del);
        ps.setInt(1, emp.getId());
        ps.executeUpdate();
		}
	 else {
				 throw new UserDefinedException("Employee id not found......");
		 }
			 
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			
			closeStatement(ps);
		}

	}
	
	public   void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
				//stmt.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		
		}
	}
	public   void closeStatement(Statement stmt)
	{
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		
		}
	}
	
	}
