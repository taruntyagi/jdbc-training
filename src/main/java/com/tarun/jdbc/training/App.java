package com.tarun.jdbc.training;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!.
 */
public class App {
	
	public void testCallableStatement() {
		String query = "{call yourProcedureName(?,?,?)}";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kareermatrixnew", "root",
					"");
			CallableStatement callableStatement = connection.prepareCall(query);
			callableStatement.setString(1, "sample-value");
			callableStatement.setString(2, "sample-value");
			callableStatement.setString(3, "sample-value");
			
			callableStatement.executeQuery();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Test prepared statement.
	 */
	public void testPreparedStatement() {
		System.out.println("Loading database driver !");
		try {
			String prepareQuery = "SELECT * FROM applicationattributes WHERE attributeType = ? ";
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loaded database driver !");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kareermatrixnew", "root",
					"");
			System.out.println("Connection built successfully!" + connection);
			PreparedStatement preparedStatement = connection.prepareStatement(prepareQuery);
			preparedStatement.setString(1, "testing-type");
			ResultSet result = preparedStatement.executeQuery();
			
			if (result != null) {
				while (result.next()) {
					String attributeName = result.getString("attributeName");
					String attributeType = result.getString("attributeType");
					int applicationAttributeId = result.getInt("applicationAttributeId");
					System.out.println("applicationAttributeId: " + applicationAttributeId + ", attributeName:"
							+ attributeName + ", attributeType:" + attributeType);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test simple JDBC connection.
	 */
	public void testSimpleJDBCConnection() {
		try {
			System.out.println("Loading database driver !");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loaded database driver !");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kareermatrixnew", "root",
					"");
			System.out.println("Connection built successfully!" + connection);
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM applicationattributes";
			ResultSet result = statement.executeQuery(query);
			if (result != null) {
				while (result.next()) {
					String attributeName = result.getString("attributeName");
					String attributeType = result.getString("attributeType");
					int applicationAttributeId = result.getInt("applicationAttributeId");
					System.out.println("applicationAttributeId: " + applicationAttributeId + ", attributeName:"
							+ attributeName + ", attributeType:" + attributeType);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
