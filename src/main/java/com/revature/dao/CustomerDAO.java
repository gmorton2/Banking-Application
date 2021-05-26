package com.revature.dao;

import java.util.List;


import com.revature.model.Account;
import com.revature.model.Customer;

public interface CustomerDAO {
	public List<Customer> getAllCustomers();
	public List<Account> getAllAccounts(Customer customer);
	public Account applyForNewAccount(Customer customer);
	public Account updateBalance(Customer customer);
	public List<Account> transferMoneyFromAccounts(Customer customer,String from,String to,double amount);
}
