package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;
import com.revature.model.User;

public interface UserDAO {	
	public List<User> getAllUsers();
	public Customer createAccount(User user);
}
