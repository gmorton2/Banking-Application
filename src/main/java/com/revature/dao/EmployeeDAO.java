package com.revature.dao;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees();
	public List<Account> getCustomerAccounts(Customer customer);
	public List<Account> getAllPendingAccounts();
	public void acceptOrDeclineAccounts();
}
