package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public class UserDAO {
	
	private List<User> users;
	
	public UserDAO(List<User> users) {
		super();
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
