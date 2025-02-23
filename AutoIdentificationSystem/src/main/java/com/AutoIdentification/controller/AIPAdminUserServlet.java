package com.AutoIdentification.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoIdentification.dao.AIPAdminDao;
import com.AutoIdentification.dao.BankEmployeeDao;
import com.AutoIdentification.dao.HelpDao;
import com.AutoIdentification.model.BankEmployee;
import com.AutoIdentification.model.Help;

/**
 * Servlet implementation class AIPAdminUserServlet
 */
@WebServlet("/AIPAdminUserServlet")
public class AIPAdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AIPAdminUserServlet() {
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
		AIPAdminDao aipAdminDao = new AIPAdminDao();
		BankEmployeeDao bankEmployeeDao = new BankEmployeeDao();
		// TODO Auto-generated method stub
		if (request.getParameter("login") != null) {
			try {
				PrintWriter out = response.getWriter();
				String a = request.getParameter("User_Id");
				String b = request.getParameter("Password");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sp1", "root",
						"Password-1");
				PreparedStatement ps = (PreparedStatement) con
						.prepareStatement("select User_Id,Password from AIPAdmin");
				ResultSet rs = (ResultSet) ps.executeQuery();

				int i = 0;

				while (rs.next()) {

					if (a.equals(rs.getString(1))) {
						i = 1;

						if (b.equals(rs.getString(2))) {
							out.println("Logged in successfully");
							RequestDispatcher dispatcher = request.getRequestDispatcher("/views/LoginAIPAdminPage.jsp");
							dispatcher.forward(request, response);

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
		} else if (request.getParameter("listEmployees") != null) {
			System.out.println("After refreshBankEmployeeList();");
			List<BankEmployee> bankEmployee = new ArrayList<BankEmployee>();
			try {
				bankEmployee = bankEmployeeDao.listOfBankEmployees();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bankEmployee", bankEmployee);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/BankEmployeeDetails.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			} else {
				response.getWriter().append("Failed to dispatch ");
			}
		} else if (request.getParameter("reject") != null) {

			String empId = request.getParameter("rejectedbankEmployeeId");
			System.out.println(empId);
			int res1;
			try {
				res1 = bankEmployeeDao.removeBankEmployee(empId);
				if (res1 == 1) {
					List<BankEmployee> bankEmployees = new ArrayList<BankEmployee>();
					bankEmployees = bankEmployeeDao.listOfBankEmployees();
					request.setAttribute("bankEmployee", bankEmployees);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/views/BankEmployeeDetails.jsp");
					if (dispatcher != null) {
						dispatcher.forward(request, response);
					} else {
						response.getWriter().append("Failed to dispatch ");
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (request.getParameter("ForgotDetails") != null) {
			request.setAttribute("message", " ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/forgotDetailsAdmin.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("verify") != null) {
			String userId = request.getParameter("UserId");
			String answerOne = request.getParameter("AnswerOne");
			String answerTwo = request.getParameter("AnswerTwo");
			String answerThree = request.getParameter("AnswerThree");
			String password = request.getParameter("password");

			System.out.println("???????????");
			int res1;
			try {
				res1 = aipAdminDao.resetPassword(userId, answerOne, answerTwo, answerThree, password);

				if (res1 == 1) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/AIPAdminlogin_form.jsp");
					requestDispatcher.forward(request, response);
				} else {
					request.setAttribute("message", "Invalid Answers");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/forgotDetailsAdmin.jsp");
					requestDispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (request.getParameter("helpButton") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/helpForm.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("help") != null) {
			String description = request.getParameter("Description");
			Help help = new Help();
			HelpDao helpDao=new HelpDao();
			help.setDescription(description);
			try {
				int res=helpDao.help(help);
				if(res!=0) {
					System.out.println("After HelpDao");
				}
				else {
					System.out.println("Failed to store help in dao");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (request.getParameter("logoff") != null) {
					System.out.println("logged off");
				}
			} 
		
}