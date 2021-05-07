package com.revature.model;

public class Account{
	double balance;
	int accountID;
	Customer customer = new Customer();
	
	public Account() {
		this.balance = 0.0;
		this.accountID = 0;
		this.customer = new Customer("", "", "", 0, 0);
	}
	
	
	public Account(double balance, int accountID, Customer customer) {
		super();
		this.balance = balance;
		this.accountID = accountID;
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
}
