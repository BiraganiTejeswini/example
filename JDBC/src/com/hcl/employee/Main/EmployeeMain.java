package com.hcl.employee.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.service.*;
import com.hcl.employee.util.DBConnection;
import com.hcl.employee.util.UserDefinedException;
public class EmployeeMain {
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IEmployeeDetails ed=new EmployeeDetailsImpl();
        while(true) 
        {
        	System.out.println("1.To create Employee Table\n"
        			+ "2.To insert values\n"
					+ "3.Display details of Employees\n"
					+ "4.update the details of Employee.\n"
					+ "5.delete the employee details\n"
					+ "6.to search and fetch the details."
					+"\n7.To exit from the Application");
			int number=sc.nextInt();
			switch(number)
			{
			case 1 :
				ed.createTable();
				System.out.println("Table is created.....");
				break;
			case 2:
				System.out.println("insert the values of id as interger");
				Employee emp=new Employee();
				int id=sc.nextInt(); 
				System.out.println("insert the values of name as String");
				String name=sc.next();
				System.out.println("insert the values of designation as String");
				String designation=sc.next();
				System.out.println("insert the values of loc as String");
				String loc=sc.next();
				emp.setId(id);
				emp.setEname(name);
				emp.setDesignation(designation);
				emp.setLoc(loc);
				try {
					ed.addDetails(emp);
					System.out.println("Values are inserted.....");
				} catch (UserDefinedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				  List<Employee> ls=ed.display();
	                for(Employee e: ls) {
	                    System.out.println(e.toString());
	                }
	                				
				System.out.println("Details of employee are displayed.............");
				break;
			case 4:
				Employee e1=new Employee();
				System.out.println("insert the values of loc as String");
				 loc=sc.next();
				e1.setLoc(loc);
				System.out.println("insert the values of id as interger");
				 id=sc.nextInt(); 
				e1.setId(id);
				try {
					ed.update(e1);
					System.out.println("Updated successfully...");
				} catch (UserDefinedException e3) {
					// TODO Auto-generated catch block
					System.out.println(e3.getMessage());
				}
				
				break;
			case 5:
				Employee e2=new Employee();
				System.out.println("enter the id as integer to delete based on that");
				id=sc.nextInt();
				e2.setId(id);
				try {
					ed.delete(e2);
					System.out.println("Deleted............");
				} catch (UserDefinedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				break;
			case 6:
				System.out.println("enter the id as integer to search that employess details");
				 id=sc.nextInt(); 
				 ed.search(id);
				 System.out.println("results based on search............");
				break;
			case 7:
				Connection con= DBConnection.getConection();
				try {
					con.close();
					System.out.println("databse connection closed......");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
				System.out.println(".............Application closed.............");
			default:System.out.println(" Enter the proper vaild option");
			   break;
			}
        }
		
		
	}

}
