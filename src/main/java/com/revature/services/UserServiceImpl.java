package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDAO;
import com.revature.model.User;
import com.revature.utilities.ConnectionUtility;

public class UserServiceImpl implements UserService{
	
	public UserDAO userL;
	private static final Logger LOG = LogManager.getLogger(ConnectionUtility.class);

	public User logIn(List<User> users, User user) {
		
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
