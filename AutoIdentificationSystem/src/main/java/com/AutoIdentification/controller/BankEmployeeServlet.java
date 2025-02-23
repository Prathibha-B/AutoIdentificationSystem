package com.AutoIdentification.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoIdentification.dao.BankEmployeeDao;

import com.AutoIdentification.model.BankEmployee;

/**
 * Servlet implementation class BankEmployeeServlet
 */
@WebServlet("/BankEmployeeServlet")
public class BankEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankEmployeeDao bankemployeedao = new BankEmployeeDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankEmployeeServlet() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/BankEmployeeRegistration.jsp");
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

		BankEmployee bankemployee = new BankEmployee();
		bankemployee.setFirst_name(First_name);
		bankemployee.setLast_name(Last_name);
		bankemployee.setAge(Age);
		bankemployee.setGender(Gender);
		bankemployee.setContact_number(Contact_number);
		bankemployee.setCity(City);
		bankemployee.setState(State);
		bankemployee.setUser_Id(User_Id);
		bankemployee.setPassword(Password);
		bankemployee.setAnswerOne(AnswerOne);
		bankemployee.setAnswerTwo(AnswerTwo);
		bankemployee.setAnswerThree(AnswerThree);
		System.out.println(bankemployee);
		try {
			BankEmployeeDao.register(bankemployee);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/BankEmployeeRegister.jsp");
		dispatcher.forward(request, response);

	}

}
