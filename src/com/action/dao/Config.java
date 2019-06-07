package com.action.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Config {

	private static Config config;
	
	// Database configuration
	private static final String url = "jdbc:mysql://localhost:3306/price_action?useSSL=false";
	private static final String user = "haytham";
	private static final String password = "toortoor";
	private static Connection connection;
	
	private Config() {
		
	}
	
	/*
	 * Singleton Pattern
	 */
	public static Config getInstance() {
		if( config == null ) {
			config = new Config();
		}
		return config;
	}
	
	/*
	 * Get an instance of connection (null in case of exception) 
	 */
	public Connection getConnection() {
		
		try {
			if( connection != null ) {
				return connection;
			}
			
			// Load mysql class
			Class.forName("com.mysql.jdbc.Driver");
			
			// Initialize Connection
			connection = DriverManager.getConnection(url, user, password);
			
			// Return retrieved connection
			return connection;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		
	}
	
}
