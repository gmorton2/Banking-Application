package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDAO {
	
	//all the interactions with the db ie getallusers 
	public List<User> getAllUsers();
}
