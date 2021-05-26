package com.revature.services;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;



public class EmployeeServiceImpl implements EmployeeService{
	public EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	public Employee logIn(int employeeID) {
		List<Employee> employees = employeeDAO.getAllEmployees();
		System.out.println("\nChecking database of employees...");
		for(Employee e : employees) {
			if(e.getEmployeeID() == employeeID) {
				System.out.println("Login was Successful.\n");
				return e;
			}	
		}
		System.out.println("Login was Unsuccessful.");
		return null;
	}
	
	public void showAccountsForCustomer(Customer customer) {
		List<Account> accounts = employeeDAO.getCustomerAccounts(customer);
		for(Account a : accounts)
			System.out.println(a.toString());
	}

	public void printTransactionHistory() {

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader("C:\\Users\\glmor\\eclipse-workspace\\bank-application\\logs\\logfile.log");
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void acceptOrDecline() {
		employeeDAO.acceptOrDeclineAccounts();
	}

}
