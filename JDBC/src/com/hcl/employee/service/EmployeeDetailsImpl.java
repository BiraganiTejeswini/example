package com.hcl.employee.service;

import java.util.List;
import com.hcl.employee.beans.Employee;
import com.hcl.employee.repositry.*;
import com.hcl.employee.util.UserDefinedException;

public class EmployeeDetailsImpl implements IEmployeeDetails {
Employee e=new Employee();
EmployeeDAO ed=new EmployeeDAO();
	@Override
	public void createTable() {
		ed.createTable();
		
	}

	@Override
	public int addDetails(Employee e) throws UserDefinedException {
		return ed.addDetails(e);
	}

	@Override
	public List<Employee> display() {
		return ed.display();
	}

	@Override
	public void update(Employee e) throws UserDefinedException {
		ed.update(e);
	}

	@Override
	public void delete(Employee e) throws UserDefinedException {
		
		ed.delete(e);

	}

	@Override
	public void search(int id) {
		 ed.search(id);

	}

}
