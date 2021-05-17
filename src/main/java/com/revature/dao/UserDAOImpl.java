package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.User;
import com.revature.utilities.ConnectionUtility;

public class UserDAOImpl implements UserDAO{
	Connection connection;
	private static final Logger LOG = LogManager.getLogger(UserDAOImpl.class);

	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		try {
			connection = ConnectionUtility.getConnection();
			LOG.debug("Connection is valiid "+connection.isValid(5));
			String sql = "SELECT * FROM users";
			PreparedStatement statement = connection.prepareStatement(sql);
			//statement.setString(1,  "%%");
			ResultSet set = statement.executeQuery();
			LOG.trace("Executed query: "+sql);
			while(set.next()) {
				//might want to leave as prints
				User u = new User();
				u.setUserID(set.getInt("userID"));
				u.setName(set.getString("fullName"));
				u.setUserName(set.getString("username"));
				u.setPassword(set.getString("passwrd"));
				userList.add(u);
				
				LOG.info(set.getInt("userID"));
				LOG.info(set.getString("fullName"));
				LOG.info(set.getString("username"));
				LOG.info(set.getString("passwrd"));
			}
		}
		catch(SQLException ex){
			LOG.fatal("Failure.");
			ex.printStackTrace();
		}
		return userList;
	}
}
