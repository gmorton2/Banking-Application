package com.revature.model;

public class User extends System{
	String name;
	String userName;
	String password;
	int userID;
	
	public User() {
		this.name = "";
		this.userName = "";
		this.password = "";
		this.userID = 0;
	}
	
	public User(String name, String userName, String password, int userID) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean isValidTransaction() {
		return false;
	}
}
