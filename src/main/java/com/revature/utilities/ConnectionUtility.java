package com.revature.utilities;

import java.sql.Connection;

import java.sql.DriverManager;
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
}
