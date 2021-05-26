package com.revature.model;

public class Savings extends Account{
	String type;
	public Savings() {
		super();
		type="";
	}

	public Savings(double balance, int accountID, Customer customer,String type) {
		super(balance, accountID, customer);
		this.type=type;
	}
	@Override
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isValidTransaction(String transactionType, double amount) {
		if(transactionType.equals("withdraw") && (amount>balance || amount<0.0))
			return false;
		else if(transactionType.equals("deposite") && amount<0.0) 
			return false;
		else
			return true;
	}
}
