package com.AutoIdentification.controller;

import java.io.IOException;
import java.lang.NumberFormatException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoIdentification.dao.AIPAdminDao;
import com.AutoIdentification.model.AIPAdmin;

/**
 * Servlet implementation class AIPAdminServlet
 */
@WebServlet("/AIPAdminServlet")
public class AIPAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AIPAdminDao aipadmindao = new AIPAdminDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AIPAdminServlet() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/AIPAdminRegistration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String First_name = request.getParameter("First_name");
		String Last_name = request.getParameter("Last_name");
		Integer Age = Integer.parseInt(request.getParameter("Age"));
		String Gender = request.getParameter("Gender");
		String Contact_number = request.getParameter("Contact_number");
		String City = request.getParameter("City");
		String State = request.getParameter("State");
		String User_Id = request.getParameter("User_Id");
		String Password = request.getParameter("Password");
		String AnswerOne = request.getParameter("AnswerOne");
		String AnswerTwo = request.getParameter("AnswerTwo");
		String AnswerThree = request.getParameter("AnswerThree");

		AIPAdmin aipadmin = new AIPAdmin();
		aipadmin.setFirst_name(First_name);
		aipadmin.setLast_name(Last_name);
		aipadmin.setAge(Age);
		aipadmin.setGender(Gender);
		aipadmin.setContact_number(Contact_number);
		aipadmin.setCity(City);
		aipadmin.setState(State);
		aipadmin.setUser_id(User_Id);
		aipadmin.setPassword(Password);
		aipadmin.setAnswerOne(AnswerOne);
		aipadmin.setAnswerTwo(AnswerTwo);
		aipadmin.setAnswerThree(AnswerThree);
		try {
			aipadmindao.register(aipadmin);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/AIPAdminRegister.jsp");
		dispatcher.forward(request, response);

	}

}
