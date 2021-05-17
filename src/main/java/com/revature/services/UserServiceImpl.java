package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.model.User;
import com.revature.utilities.ConnectionUtility;

public class UserServiceImpl implements UserService{
	
	public UserDAO userL = new UserDAOImpl();
	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
	
	public UserServiceImpl() {}
	
	public UserServiceImpl(UserDAO userDAO) {
		userL=userDAO;
	}
	
	public User logIn(User user) {
		List<User> users = userL.getAllUsers();
		LOG.trace("Checking database of users...");
		for(User u : users) {
			if(u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) {
				LOG.debug("Login was Successful.");
				return u;
			}	
		}
		LOG.fatal("Login was Unsuccessful.");
		return null;
	}
}
