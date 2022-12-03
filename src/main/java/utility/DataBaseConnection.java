package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	Statement statement;
	Connection connection;

	public DataBaseConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/automationbykrishna", "postgres",
					"harsh");
			statement = connection.createStatement();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	// select
	public ResultSet execuetSelectQuery(String sql) {
		try {
			return statement.executeQuery(sql);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}

	// Update, Delete, Insert
	public int execuetUpdateQuery(String sql) {
		try {
			return statement.executeUpdate(sql);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return 0;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
