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

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", userName=" + userName + ", password="
				+ password + ", userID=" + userID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	
	
}
