package com.revature.services;

import java.util.List;

import com.revature.model.User;

public interface UserService {
	public User logIn(List<User> users, User user);
}
