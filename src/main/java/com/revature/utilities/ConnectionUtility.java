package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtility {
	private static final String CONNECTION_USERNAME = "postgres";
	private static final String CONNECTION_PASSWORD = "power12345";
	private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e){
			System.out.println("Could not register driver.");
			e.printStackTrace();
		}
		if(connection == null)
			connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) {
		
		try {
			Connection connection = getConnection();
			System.out.println("Connection is valiid "+connection.isValid(5));
			String sql = "SELECT * FROM users WHERE fullName LIKE ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,  "%t%");
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				System.out.println(set.getInt("userID"));
				System.out.println(set.getString("fullName"));
				System.out.println(set.getString("username"));
				System.out.println(set.getString("passwrd"));
			}
		}
		catch(SQLException ex){
			System.out.println("Failure.");
			ex.printStackTrace();
		}
	}

}
