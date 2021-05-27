package com.hcl.employee.service;

import java.util.List;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.util.UserDefinedException;

public interface IEmployeeDetails 
{
	  void createTable();
      int addDetails(Employee e) throws UserDefinedException;
	  List<Employee> display();
	  void update(Employee e) throws UserDefinedException;
	  void delete(Employee e) throws UserDefinedException;
	  void search(int id);

	
}
