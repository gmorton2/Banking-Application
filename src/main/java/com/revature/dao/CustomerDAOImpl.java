package com.revature.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.Account;
import com.revature.model.Checkings;
import com.revature.model.Customer;
import com.revature.model.Savings;
import com.revature.utilities.ConnectionUtility;

public class CustomerDAOImpl implements CustomerDAO{
	Connection connection;
	private static final Logger LOG = LogManager.getLogger(UserDAOImpl.class);
	private static Scanner scan = new Scanner(System.in);
	
	public List<Customer> getAllCustomers(){
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			connection = ConnectionUtility.getConnection();
			String sql = "SELECT * FROM customers";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				Customer c = new Customer();
				c.setUserID(set.getInt("userID"));
				c.setCustomerID(set.getInt("customerID"));

				customerList.add(c);
			}
		}
		catch(SQLException ex){
			System.out.println("Failure.");
			ex.printStackTrace();
		}
		return customerList;
	}
	
	public List<Account> getAllAccounts(Customer customer){
		List<Account> accountList = new ArrayList<Account>();
		Account a = null;
		try {
			connection = ConnectionUtility.getConnection();			
			String sql = "SELECT * FROM accounts where customerID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, customer.getCustomerID());
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				if(set.getString("accountType").equals("Checking")) {
					a = new Checkings(set.getDouble("balance"), set.getInt("accountID"),customer,set.getString("accountType"));
				}
				else if(set.getString("accountType").equals("Saving")){
					a = new Savings(set.getDouble("balance"), set.getInt("accountID"),customer,set.getString("accountType"));
				}
				
				accountList.add(a);
			}
		}
		catch(SQLException ex){
			System.out.println("Get all Accounts Failure.");
			ex.printStackTrace();
		}
		return accountList;
	}
	public Account updateBalance(Customer customer) {
		PreparedStatement statement;
		Account one = null;
		List<Account> a = getAllAccounts(customer);
		try {
			System.out.print("Which Account would you like to preform a transaction on? ");
			String account = scan.next();
			System.out.print("Would you like to Deposit or Withdraw? ");
			String transaction = scan.next();
			boolean flag = false;
			do {
				System.out.print("How much money would you like to "+ transaction+"? $");
				double money = scan.nextDouble();
				connection = ConnectionUtility.getConnection();				
				String sql = "UPDATE accounts SET balance = ? where customerID = ? and accountType = ?";
				statement = connection.prepareStatement(sql);
				for(Account acc:a) {
					if(acc.getType().equals(account))
						one=acc;
					else continue;
				}
				if(transaction.equals("Withdraw")) {
					if(money<0) System.out.println("\nCannot Withdraw a Negative amount of money.\n"
												  +"Please Enter a valid amount of money.\n");
					else if(money>one.getBalance()) System.out.println("\nThe amount you've requested is greater than your current balance.\n"
																	  +"Please Enter a valid amount of money.\n");
					else {
						statement.setDouble(1, one.getBalance()-money);
						one.setBalance(one.getBalance()-money);
						
						LOG.trace("Customer: "+ customer.getCustomerID()+" made a withdraw of $"+ String.format("%.2f",money)
								 +" from their "+one.getType()+" account.");
						flag=true;
					}
				}
				else {
					if(money<0) System.out.println("\nCannot Deposit a Negative amount of money.\n"
												  +"Please Enter a valid amount of money.\n");
					else {
						statement.setDouble(1, one.getBalance()+money);
						one.setBalance(one.getBalance()+money);
						
						LOG.trace("Customer: "+ customer.getCustomerID()+" made a Deposit of $"+ String.format("%.2f",money)
						 		 +" from their "+one.getType()+" account.");
						flag=true;
					}
				}
			}while(!flag);
			statement.setInt(2, customer.getCustomerID());
			statement.setString(3, one.getType());	
			statement.executeUpdate();

		}
		catch(SQLException ex){
			System.out.println("Update Balance Failure.");
			ex.printStackTrace();
		}
		return one;
	}
	public Account applyForNewAccount(Customer customer) {
		Account a = null;
		try {
			System.out.print("In order to create a new account please enter an Account ID: ");
			int aID = scan.nextInt();
			System.out.print("\nWould you like to create a Checkings or a Savings Account? ");
			String type=scan.next();
			System.out.print("\nLastly, how much money would you like to deposit? $");
			double money = scan.nextDouble();
			connection = ConnectionUtility.getConnection();			
			String sql = "INSERT into pendingAccounts(pAccountID,pCustomerID,pAccountType,pBalance) VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);			
			statement.setInt(1, aID);
			statement.setInt(2, customer.getCustomerID());
			statement.setString(3, type);
			statement.setDouble(4, money);
			int set = statement.executeUpdate();
			LOG.trace("Customer: "+customer.getCustomerID()+" has created a new "+type+" account with an initial deposit of $"+String.format("%.2f",money));
			if(set==1) {
				if(type.equals("Checking"))
					a = new Checkings(money,aID,customer,type);
				else
					a = new Savings(money,aID,customer,type);
			}
			else return null;
		}
		catch(SQLException ex){
			System.out.println("Failure.");
			ex.printStackTrace();
		}
		return a;
	}
	
	public List<Account> transferMoneyFromAccounts(Customer customer,String from,String to,double amount) {
		PreparedStatement statement;
		Account withdrawFrom = null;
		Account depositTo = null;
		List<Account> a = getAllAccounts(customer);
		List<Account> updatedAccounts = new ArrayList<Account>();

		try {
			connection = ConnectionUtility.getConnection();			
			String sql = "update accounts \r\n"
					+ "set balance = nv.balance\r\n"
					+ "from \r\n"
					+ "	(values\r\n"
					+ "		(?,?,?),\r\n"
					+ "		(?,?,?)\r\n"
					+ "	) as nv (customerID, accountType,balance)\r\n"
					+ "where accounts.customerID = nv.customerID and accounts.accounttype = nv.accountType";
			statement = connection.prepareStatement(sql);			
			for(Account acc:a) {
				if(acc.getType().equals(from))
					withdrawFrom = acc;
				else
					depositTo=acc;
			}
			statement.setInt(1, customer.getCustomerID());
			statement.setString(2, from);
			statement.setDouble(3, withdrawFrom.getBalance()-amount);
			statement.setInt(4, customer.getCustomerID());
			statement.setString(5, to);
			statement.setDouble(6, depositTo.getBalance()+amount);
			statement.executeUpdate();
			
			withdrawFrom.setBalance(withdrawFrom.getBalance()-amount);
			depositTo.setBalance(depositTo.getBalance()+amount);
			LOG.trace("Customer: "+customer.getCustomerID()+" transferred $"+String.format("%.2f",amount)
					 +" from their "+withdrawFrom.getType()+ " account to their "+depositTo.getType()+" account.");
			
			updatedAccounts.add(withdrawFrom);
			updatedAccounts.add(depositTo);			
		}
		catch(SQLException ex){
			System.out.println("Failure.");
			ex.printStackTrace();
		}
		return updatedAccounts;
	}
}
