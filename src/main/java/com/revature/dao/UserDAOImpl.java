package com.revature.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.model.Customer;
import com.revature.model.User;
import com.revature.utilities.ConnectionUtility;

public class UserDAOImpl implements UserDAO{
	Connection connection;
	private static Scanner scan = new Scanner(System.in);

	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		try {
			connection = ConnectionUtility.getConnection();
			String sql = "SELECT * FROM users";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				User u = new User();
				u.setUserID(set.getInt("userID"));
				u.setName(set.getString("fullName"));
				u.setUserName(set.getString("username"));
				u.setPassword(set.getString("passwrd"));
				userList.add(u);
			}
		}
		catch(SQLException ex){
			System.out.println("Failure.");
			ex.printStackTrace();
		}
		return userList;
	}
	
	public Customer createAccount(User user) {
		Customer c = new Customer();
		try {
			System.out.println("In order to create a customer account please enter a customer ID: ");
			int id = scan.nextInt();
			connection = ConnectionUtility.getConnection();
			String sql = "INSERT into customers(customerid,userid) VALUES(?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, user.getUserID());
			int set = statement.executeUpdate();
			if(set==1) {
				c.setName(user.getName());
				c.setUserName(user.getUserName());
				c.setPassword(user.getPassword());
				c.setCustomerID(id);
				c.setUserID(user.getUserID());
			}
			else return null;
		}
		catch(SQLException ex){
			System.out.println("Failure.");
			ex.printStackTrace();
		}
		return c;
	}
}
