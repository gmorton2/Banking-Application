package com.revature.services;

import com.revature.model.Customer;
import com.revature.model.User;

public interface UserService {
	public User logIn(String username,String password);
	public Customer regsiterForCustomerAccount(User user);
}
