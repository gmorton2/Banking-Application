package com.revature.model;

public class Employee extends User{
	int employeeID;

	public Employee() {
		super();
		this.employeeID = 0;
	}

	public Employee(String name, String userName, String password, int userID, int employeeID) {
		super(name, userName, password, userID);
		this.employeeID = employeeID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
}
