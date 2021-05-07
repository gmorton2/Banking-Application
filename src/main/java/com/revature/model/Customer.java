package com.revature.model;

public class Customer extends User{
	int customerID;

	public Customer() {
		super();
		this.customerID = 0;
	}
	
	public Customer(String name, String userName, String password, int userID, int customerID) {
		super(name, userName, password, userID);
		this.customerID = customerID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}
