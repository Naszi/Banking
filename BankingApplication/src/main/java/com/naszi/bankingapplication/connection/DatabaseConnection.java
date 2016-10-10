package com.naszi.bankingapplication.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
	private static final String DB_URL = "jdbc:hsqldb:hsql://localhost/";

	public static DatabaseConnection instance;
	private Connection connection;

	public DatabaseConnection() {

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, "SA", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized static DatabaseConnection customerConnection() {

		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() {
		instance = null;
	}

}
