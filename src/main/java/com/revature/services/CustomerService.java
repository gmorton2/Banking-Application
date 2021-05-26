package com.revature.services;

import com.revature.model.Account;
import com.revature.model.Customer;

public interface CustomerService {
	public Customer logIn(int customerID);
	public Account applyForNewAccount(Customer customer);
	public void viewBalanceOfAccount(Customer customer, int choice);
	public Account depositOrWithdraw(Customer customer);
	public void transferMoneyFromAccounts(Customer customer);
}
