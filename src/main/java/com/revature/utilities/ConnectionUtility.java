package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtility {
	
	private static final Logger LOG = LogManager.getLogger(ConnectionUtility.class);
	private static final String CONNECTION_USERNAME = "postgres";
	private static final String CONNECTION_PASSWORD = "power12345";
	private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e){
			LOG.fatal("Could not register driver.");
			e.printStackTrace();
		}
		if(connection == null || connection.isClosed())
			connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) {
		
		try {
			Connection connection = getConnection();
			LOG.debug("Connection is valiid "+connection.isValid(5));
			String sql = "SELECT * FROM users WHERE fullName LIKE ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,  "%t%");
			ResultSet set = statement.executeQuery();
			LOG.trace("Executed query: "+sql);
			while(set.next()) {
				//might want to leave as prints
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
	}

}
