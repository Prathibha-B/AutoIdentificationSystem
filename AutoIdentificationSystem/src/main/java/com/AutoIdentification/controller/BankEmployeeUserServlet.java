package com.AutoIdentification.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankEmployeeUserServlet
 */
@WebServlet("/BankEmployeeUserServlet")
public class BankEmployeeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankEmployeeUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("login")!=null) {

			try {
				PrintWriter out = response.getWriter();
				String a = request.getParameter("User_Id");
				String b = request.getParameter("Password");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sp1", "root",
						"Password-1");
				PreparedStatement ps = (PreparedStatement) con
						.prepareStatement("select User_Id,Password from bankemployee");
				ResultSet rs = (ResultSet) ps.executeQuery();
				int i = 0;

				while (rs.next()) {

					if (a.equals(rs.getString(1))) {
						i = 1;

						if (b.equals(rs.getString(2))) {
							out.println("Logged in successfully");
						} else {
							out.println("Password is not matching");
						}
						break;
					}

				}

				if (i == 0) {
					out.println("User Id is not present");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Admin login Servlet " + e);
			}
		}

}
}
