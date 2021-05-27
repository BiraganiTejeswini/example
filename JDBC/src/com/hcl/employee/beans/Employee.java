package com.hcl.employee.beans;

public class Employee
{
private  int id;
private String ename;
private String designation;
@Override
public String toString() {
	return "Employee [id=" + id + ", ename=" + ename + ", designation=" + designation + ", loc=" + loc + "]";
}
private String loc;
public  int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}


}
