package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.model.Customer;
import com.revature.model.User;

public class UserServiceImpl implements UserService{
	public UserDAO userDAO = new UserDAOImpl();
	
	public UserServiceImpl() {}
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO=userDAO;
	}
	
	public User logIn(String username,String password) {
		List<User> users = userDAO.getAllUsers();
		System.out.println("\nChecking database of users...");
		for(User u : users) {
			if(u.getUserName().equals(username) && u.getPassword().equals(password)) {
				System.out.println("Login was Successful.");
				return u;
			}	
		}
		System.out.println("Login was Unsuccessful.");
		return null;
	}
	
	public Customer regsiterForCustomerAccount(User user) {
		Customer customer = userDAO.createAccount(user);
		return customer;
	}
}
