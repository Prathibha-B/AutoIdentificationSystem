package com.AutoIdentification.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.AutoIdentification.model.BankEmployee;

public class BankEmployeeDao {
	public static int register( BankEmployee bankemployee ) throws ClassNotFoundException {
		String INSERT_USERS_SQL="INSERT INTO BankEmployee" +"(First_name,Last_name,Age,Gender,Contact_number,City,State,User_Id,Password,AnswerOne,AnswerTwo,AnswerThree) VALUES"+
	"(?,?,?,?,?,?,?,?,?,?,?,?);";
		int result=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp1?useSSL=false", "root", "Password-1");
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			System.out.println(bankemployee);
			preparedStatement.setString(1,bankemployee .getFirst_name());
			preparedStatement.setString(2, bankemployee.getLast_name());
			preparedStatement.setInt(3, bankemployee.getAge());
			preparedStatement.setString(4, bankemployee.getGender());
			preparedStatement.setString(5, bankemployee.getContact_number());
			preparedStatement.setString(6, bankemployee.getCity());
			preparedStatement.setString(7, bankemployee.getState());
			preparedStatement.setString(8, bankemployee.getUser_Id());
			preparedStatement.setString(9,bankemployee.getPassword());
			preparedStatement.setString(10, bankemployee.getAnswerOne());
			preparedStatement.setString(11, bankemployee.getAnswerTwo());
			preparedStatement.setString(12, bankemployee.getAnswerThree());
			
			
			System.out.println(preparedStatement);
			result=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			printSQLException(e);
			
			
		}
			
		return result;
		
		
	}

	public List<BankEmployee> listOfBankEmployees() throws ClassNotFoundException {
		String sql = "select * from bankemployee";
		List<BankEmployee> BankEmployees = new ArrayList<BankEmployee>();


		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp1?useSSL=false", "root", "Password-1");
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){

		Statement s;
		
			s = connection.createStatement();
			s.executeQuery(sql);

			ResultSet rs = s.getResultSet();

			while (rs.next()) {

				BankEmployee bankEmployee = new BankEmployee();
				bankEmployee.setUser_Id(rs.getString("User_Id"));
				bankEmployee.setFirst_name(rs.getString("First_name"));
				bankEmployee.setLast_name(rs.getString("Last_name"));
				bankEmployee.setAge(rs.getInt("Age"));
				bankEmployee.setGender(rs.getString("Gender"));
				bankEmployee.setContact_number(rs.getString("Contact_number"));
				bankEmployee.setCity(rs.getString("City"));
				bankEmployee.setState(rs.getString("State"));
				bankEmployee.setPassword(rs.getString("Password"));
				
				BankEmployees.add(bankEmployee);
				System.out.println(bankEmployee);
				System.out.println("After fetching list");

			}
			rs.close();

			s.close();
		} catch (SQLException e) {
			printSQLException(e);
		}

		return BankEmployees;

	}

	public int removeBankEmployee(String bankEmployeeId) throws ClassNotFoundException {
		System.out.println("in removeBankEmployee()");
		System.out.println(bankEmployeeId);
		String deleteRow = "DELETE FROM bankemployee WHERE User_Id=?";
		int res = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp1?useSSL=false", "root", "Password-1");
				PreparedStatement preparedStatement = connection.prepareStatement(deleteRow)){
			PreparedStatement st = connection.prepareStatement(deleteRow);
			st.setString(1, bankEmployeeId);
			st.executeUpdate();
			System.out.println("BankEmployee Removed");
			res = 1;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return res;
	}
		
	private static void printSQLException(SQLException ex) {
		for(Throwable e:ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState:"+((SQLException)e).getSQLState());
				System.err.println("ErrorCode:"+((SQLException)e).getErrorCode());
				System.err.println("Message:"+e.getMessage());
				Throwable t=ex.getCause();
				while(t!=null) {
					System.out.println("Cause:"+t);
					t=t.getCause();
				}
				
			}
		}
	}
}

	


