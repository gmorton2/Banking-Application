package com.revature.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.model.Account;
import com.revature.model.Checkings;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.Savings;
import com.revature.utilities.ConnectionUtility;

public class EmployeeDAOImpl implements EmployeeDAO{
	private static Scanner scan = new Scanner(System.in);
	CustomerDAO custDAO=new CustomerDAOImpl();
	Connection connection;
	
	public List<Employee> getAllEmployees(){
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			connection = ConnectionUtility.getConnection();
			String sql = "SELECT * FROM employees;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				Employee e = new Employee();
				e.setUserID(set.getInt("userID"));
				e.setEmployeeID(set.getInt("employeeID"));
				employeeList.add(e);
			}
		}
		catch(SQLException ex){
			System.out.println("Failure.");
			ex.printStackTrace();
		}
		return employeeList;
	}
	
	public List<Account> getCustomerAccounts(Customer customer){
		List<Account> accountList = new ArrayList<Account>();
		Account a = null;
		System.out.print("Enter the customer ID of the accounts you'd like to view: ");
		int id = scan.nextInt();
		try {
			connection = ConnectionUtility.getConnection();
			String sql = "select * from accounts where customerID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
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
			System.out.println("Failure.");
			ex.printStackTrace();
		}
		return accountList;
	}
	public List<Account> getAllPendingAccounts(){
		List<Account> accountList = new ArrayList<Account>();
		try {
			connection = ConnectionUtility.getConnection();			
			String sql = "SELECT * FROM pendingAccounts";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			List<Customer> customerList = custDAO.getAllCustomers();
			while(set.next()) {
				Account a = new Account();
				for(Customer c: customerList) {
					if(set.getInt("pCustomerID")==c.getCustomerID()) {
						if(set.getString("paccountType").equals("Checking")) {
							a = new Checkings(set.getDouble("pbalance"), set.getInt("paccountID"),c,set.getString("paccountType"));
						}
						else if(set.getString("paccountType").equals("Saving")){
							a = new Savings(set.getDouble("pbalance"), set.getInt("paccountID"),c,set.getString("paccountType"));
						}
					}
				}
				accountList.add(a);
			}
		}
		catch(SQLException ex){
			System.out.println("Failure.");
			ex.printStackTrace();
		}
		return accountList;
	}

	public void acceptOrDeclineAccounts() {
		List<Account> accountList = getAllPendingAccounts();
		for(Account a : accountList) {
			System.out.println(a.toString());
			System.out.print("\nDo you want to Approve or Decline this account? ");
			String choice = scan.next();
			if(choice.equals("Approve")) {
				try {
					connection = ConnectionUtility.getConnection();			
					String sql = "INSERT into accounts(accountID,customerID,accountType,balance) VALUES(?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(sql);			
					statement.setInt(1, a.getAccountID());
					statement.setInt(2, a.getCustomerID());
					statement.setString(3, a.getType());
					statement.setDouble(4, a.getBalance());
					statement.executeUpdate();
					System.out.println("This account has been accepted.\n");
				}
				catch(SQLException ex){
					System.out.println("Failure.");
					ex.printStackTrace();
				}
			}
			else {
				try {
					connection = ConnectionUtility.getConnection();			
					String sql = "delete from pendingaccounts where pcustomerID = ? and paccounttype = ?";
					PreparedStatement statement = connection.prepareStatement(sql);			
					statement.setInt(1, a.getCustomerID());
					statement.setString(2, a.getType());
					statement.executeUpdate();
					System.out.println("This account has been declined.\n");
				}
				catch(SQLException ex){
					System.out.println("Failure.");
					ex.printStackTrace();
				}
			}
		}
	}
}
