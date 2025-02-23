package com.AutoIdentification.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AutoIdentification.model.AIPAdmin;

public class AIPAdminDao {
	public int register(AIPAdmin aipadmin) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO AIPAdmin"
				+ "(First_name,Last_name,Age,Gender,Contact_number,City,State,User_Id,Password,AnswerOne,AnswerTwo,AnswerThree) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp1?useSSL=false", "root",
				"Password-1"); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

			preparedStatement.setString(1, aipadmin.getFirst_name());
			preparedStatement.setString(2, aipadmin.getLast_name());
			preparedStatement.setInt(3, aipadmin.getAge());
			preparedStatement.setString(4, aipadmin.getGender());
			preparedStatement.setString(5, aipadmin.getContact_number());
			preparedStatement.setString(6, aipadmin.getCity());
			preparedStatement.setString(7, aipadmin.getState());
			preparedStatement.setString(8, aipadmin.getUser_id());
			preparedStatement.setString(9, aipadmin.getPassword());
			preparedStatement.setString(10, aipadmin.getAnswerOne());
			preparedStatement.setString(11, aipadmin.getAnswerTwo());
			preparedStatement.setString(12, aipadmin.getAnswerThree());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);

		}

		return result;

	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState:" + ((SQLException) e).getSQLState());
				System.err.println("ErrorCode:" + ((SQLException) e).getErrorCode());
				System.err.println("Message:" + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause:" + t);
					t = t.getCause();
				}

			}
		}
	}

	public int resetPassword(String userId, String answerOne, String answerTwo, String answerThree,String password) throws ClassNotFoundException {
		String answer = "select AnswerOne,AnswerTwo,AnswerThree from aipadmin where User_Id='" + userId + "'";
		int result = 0;
		System.out.println("???");
		Statement stmt;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp1?useSSL=false", "root",
				"Password-1"); PreparedStatement preparedStatement = connection.prepareStatement(answer)) {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(answer);
			String ans1 = "", ans2 = "", ans3 = "";
			while (rs.next()) {
				ans1 = rs.getString("AnswerOne");
				ans2 = rs.getString("AnswerTwo");
				ans3 = rs.getString("AnswerThree");

				System.out.println(ans1+ans2+ans3);
			}
			if (answerOne.equalsIgnoreCase(ans1)&&answerTwo.equalsIgnoreCase(ans2)&&answerThree.equalsIgnoreCase(ans3)) {
				System.out.println("///////");
				String reset = "update aipadmin set password=? where User_Id='" + userId + "'";
				PreparedStatement ps = connection.prepareStatement(reset);
				System.out.println("In dao update");
				ps.setString(1, password);
				result = ps.executeUpdate();

			} else {
				result = 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
