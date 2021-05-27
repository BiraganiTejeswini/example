package com.jdbc.examples;
import java.sql.*;  
class MySqlCon
{  
public static void main(String args[])
{  
try
{  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","9606");  
Statement stmt=con.createStatement(); 
String tablecreation=("create table student(sid int primary key,sname varchar(50),scourse varchar(50))");
stmt.executeUpdate(tablecreation);
System.out.println("Table is created.....");
String insertvalues=("insert into student values(1,'tejaswini','btech'),(2,'keerthi','MBA'),(3,'vidya','medicine')");
stmt.executeUpdate(insertvalues);
System.out.println("Values are inserted.....");
ResultSet rs=stmt.executeQuery("select * from employee");  
while(rs.next())
{ 
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
}
}
catch(Exception e)
{ System.out.println(e);
}  
}  
}