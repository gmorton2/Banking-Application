package com.revature.services;

import java.util.List;

import java.util.Scanner;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.model.Account;
import com.revature.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	public CustomerDAO customerDAO = new CustomerDAOImpl();
	private static Scanner scan = new Scanner(System.in);

	public CustomerServiceImpl() {}

	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO=customerDAO;
	}

	public Customer logIn(int customerID) {
		List<Customer> customers = customerDAO.getAllCustomers();
		System.out.println("\nChecking database of customers...");
		for (Customer c : customers) {
			if (c.getCustomerID() == customerID) {
				System.out.println("Login was Successful.\n");
				return c;
			}
		}
		System.out.println("Login was Unsuccessful.\n");
		return null;
	}

	public void viewBalanceOfAccount(Customer customer, int choice) {
		List<Account> accounts = customerDAO.getAllAccounts(customer);
		for(Account a : accounts) {
			if (choice == 1 && a.getType().equals("Checking"))
				System.out.println("\nChecking account has: $" + String.format("%.2f", a.getBalance())+"\n");

			if (choice == 2 && a.getType().equals("Saving"))
				System.out.println("\nSaving account has: $" + String.format("%.2f", a.getBalance())+"\n");
		}
		
	}

	public Account depositOrWithdraw(Customer customer) {
		Account account = customerDAO.updateBalance(customer);
		return account;
	}


	public Account applyForNewAccount(Customer customer) {
		Account account = customerDAO.applyForNewAccount(customer);
		return account;
	}

	public void transferMoneyFromAccounts(Customer customer) {
		System.out.print("Enter which account you would like to transfer money from: ");
		String from = scan.next();
		System.out.print("Enter which account you would like to transfer money to: ");
		String to = scan.next();
		System.out.print("Enter the amount of money you would like to transfer: $");
		double amount = scan.nextDouble();
		System.out.println("Would you like to accept this money transfer?");
		String choice=scan.next();
		if(choice.equals("Yes")) {
			List<Account> accounts = customerDAO.transferMoneyFromAccounts(customer,from,to,amount);
			for(Account a : accounts) 
				System.out.println("Your new Balance for "+a.getType()+ " is $"+String.format("%.2f",a.getBalance()));
		}
		else System.out.println("This money transfer was declined by Customer: "+customer.getCustomerID());;
	}
}
		
		
		
	
	
