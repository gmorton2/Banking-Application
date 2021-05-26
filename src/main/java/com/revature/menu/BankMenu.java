package com.revature.menu;

import java.util.Scanner;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.User;
import com.revature.services.CustomerService;
import com.revature.services.CustomerServiceImpl;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class BankMenu {
	private static Scanner scan = new Scanner(System.in);
	private static User user = null;
	private static Customer customer = null;
	private static Employee employee = null;
	private static Account account=null;
	private static UserService userService;
	private static CustomerService customerService;
	private static EmployeeService employeeService;
	private static String username;
	private static String password;
	private static int id;
	private static int choice;
	private static String decision;

	public static void userLogin() {
		System.out.println("Welcome to The Revature Bank\n" + 
						   "If you are currently a user then sign in below\n");
		//===============================================================================user can login [complete]
		userService = new UserServiceImpl();
		do {
			System.out.print("Username: ");
			username = scan.next();
			System.out.print("Password: ");
			password = scan.next();
			user = userService.logIn(username, password);
			if (user == null)
				System.out.println("These credentials are not in the Database. Please try again.\n");
		} while (user == null);
		//===============================================================================user can login [complete]
	}

	public static void customerLogin() {
		customerService = new CustomerServiceImpl();
		do {
			System.out.print("Please Enter Customer Identification Nummber: ");
			id = scan.nextInt();
			customer = customerService.logIn(id);
			if (customer == null)
				System.out.println("The ID entered is not with a registered Customer. Please try again.\n");
		} while (customer == null);
	}

	public static void employeeLogin() {
		employeeService = new EmployeeServiceImpl();
		do {
			System.out.print("Please Enter Employee Identification Nummber: ");
			id = scan.nextInt();
			employee = employeeService.logIn(id);
			if (employee == null)
				System.out.println("The ID entered is not with a registered Employee. Please try again.\n");
		} while (employee == null);
	}
	
	public static void customerMenu() {
		customerLogin();
		do {
			System.out.println(
					"Welcome back Loyal Customer: " + id + "!\n" + "\nPlease select one of the options below:\n"
							+ "1. Apply for new Bank Account\n" 
							+ "2. View Balance of Specific Account\n"
							+ "3. Withdraw or Desposit From/To an Account\n"
							+ "4. Transfer Money to Another Account\n");
			
			choice = scan.nextInt();
			switch(choice) {
			//===============================================================================customer apply for new account [complete]
			case 1:
				account=customerService.applyForNewAccount(customer);
				System.out.println("\nA new "+account.getType()+" account has been created\n"
								  +"with a starting balance of: $"+String.format("%.2f",account.getBalance())+"\n");
				System.out.println("Type 'exit' to leave or 'back' to return to main menu.");
				decision=scan.next();
				break;
			//===============================================================================customer apply for new account [complete]
			
			//===============================================================================customer viewing account balance [complete]
			case 2: 
				System.out.println("Please select which account balance you would like to view:\n"
								  +"1. Checkings\n"
								  +"2. Savings\n");
				choice = scan.nextInt();
				customerService.viewBalanceOfAccount(customer,choice);
				System.out.println("Type 'exit' to leave or 'back' to return to main menu.");
				decision=scan.next();
				break;
			//===============================================================================customer viewing account balance [complete]
				
			//===============================================================================customer withdraw/deposit from/to account [complete]
			case 3:
				account=customerService.depositOrWithdraw(customer);
				System.out.println("\nYour new Balance for your "+account.getType()+" account is: $"+String.format("%.2f",account.getBalance())+"\n");
				System.out.println("Type 'exit' to leave or 'back' to return to main menu.");
				decision=scan.next();
				break;
			//===============================================================================customer withdraw/deposit from/to account [complete]
			case 4:
				customerService.transferMoneyFromAccounts(customer);
				System.out.println("Type 'exit' to leave or 'back' to return to main menu.");
				decision=scan.next();
				break;
			}
			
		}while(!decision.equals("exit"));
	}
	
	public static void employeeMenu() {
		employeeLogin();
		do {
			System.out.println("Welcome back trusted Employee: " + id + "!\n"
					+ "\nPlease select one of the options below:\n" 
					+ "1. Approve or Reject an Account\n"
					+ "2. View Customer Bank Accounts\n" 
					+ "3. View log of all Transactions\n");
			choice=scan.nextInt();
			switch(choice) {
			case 1:
				employeeService.acceptOrDecline();
				System.out.println("Type 'exit' to leave or 'back' to return to main menu.");
				decision=scan.next();
				break;
			//===============================================================================employee views accounts of a customer [complete]
			case 2:
				employeeService.showAccountsForCustomer(customer);
				System.out.println("Type 'exit' to leave or 'back' to return to main menu.");
				decision=scan.next();
				break;
			//===============================================================================employee views accounts of a customer [complete]
			case 3:
			//===============================================================================employee prints transaction history [complete]
				employeeService.printTransactionHistory();
				System.out.println("Type 'exit' to leave or 'back' to return to main menu.");
				decision=scan.next();
				break;
			//===============================================================================employee prints transaction history [complete]
			}
			
		}while(!decision.equals("exit"));
	}
	
	public static void postUserLoginPrompt() {
		do {
			userLogin();
			System.out.println("\nWelcome Back " + username + "!\n" 
					+ "\nPlease select one of the options below:\n"
					+ "1. Sign into Employee Account\n" 
					+ "2. Sign into Customer Account\n"
					+ "3. Register for Customer Account\n");

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				employeeMenu();
				System.out.println("Type 'logout' to return to the main menu.");
				decision=scan.next();
				break;
			case 2:
				customerMenu();
				System.out.println("Type 'logout' to return to the main menu.");
				decision=scan.next();
				break;
			case 3:
				customer=userService.regsiterForCustomerAccount(user);
				customerMenu();
				System.out.println("Type 'logout' to return to the main menu.");
				decision=scan.next();
				break;
			default:
				System.out.println("That's not an option!");
			}
		}while(decision.equals("logout"));
		
	}
	
	public static void main(String[] args) {
		postUserLoginPrompt();
	}

}
