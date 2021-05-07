package com.revature.model;

public class Checkings extends Account{
	
	public Checkings() {
		super();
	}

	public Checkings(double balance, int accountID, Customer customer) {
		super(balance, accountID, customer);
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
