package com.revature.services;

import com.revature.model.Customer;
import com.revature.model.Employee;

public interface EmployeeService {
	public Employee logIn(int employeeID);
	public void showAccountsForCustomer(Customer customer);
	public void printTransactionHistory();
	public void acceptOrDecline();

}
