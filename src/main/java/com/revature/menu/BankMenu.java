package com.revature.menu;


import java.util.Scanner;


import com.revature.model.Customer;

public class BankMenu {
	private static Scanner scan = new Scanner(System.in);

	
	public static void main(String[] args) {
		System.out.println("Welcome to The Revature Bank\n"+
						   "If you are currently a user then sign in below\n");
		
		System.out.print("Username: ");
		String username = scan.next();
		System.out.print("Password: ");
		String password = scan.next();
		
		//call user service 
		
		System.out.println("\nWelcome Back "+ username + "!\n" +
				           "\nPlease select one of the options below:\n"+
				           "1. Sign into Employee Account\n"+
				           "2. Sign into Customer Account\n"+
				           "3. Register for Customer Account\n");
		
		int choice = scan.nextInt();
		
		switch (choice) {
		case 1:
			System.out.print("Please Enter Employee Identification Nummber: ");
			int id = scan.nextInt();
			System.out.println("Welcome back trusted Employee: "+ id + "!\n"+
							   "\nPlease select one of the options below:\n"+
			                   "1. Approve or Reject an Account\n"+
			                   "2. View Customer Bank Accounts\n"+
			                   "3. View log of all Transactions\n");
			break;
		case 2:
			System.out.print("Please Enter Customer Identification Nummber: ");
			int cID = scan.nextInt();
			System.out.println("Welcome back Loyal Customer: "+ cID + "!\n"+
					           "\nPlease select one of the options below:\n"+
	                           "1. Apply for new Bank Account\n"+
	                           "2. View Balance of Specific Account\n"+
	                           "3. Transfer Money from Account\n"+
	                           "4. Accept a Transfer from Another Account\n");
			break;
		case 3:
			Customer c = new Customer();
			System.out.println("Customer Registeration Form: ");
			break;
		default:
			System.out.println("That's not an option!");
		}


	}

}
