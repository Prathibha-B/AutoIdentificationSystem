package com.AutoIdentification.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.AutoIdentification.model.Help;


public class HelpDao {
	public int help(Help help) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO help"
				+ "(Description) VALUES"
				+ "(?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp1?useSSL=false", "root",
				"Password-1"); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

			preparedStatement.setString(1, help.getDescription());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			

		}
		return result;
	}
}