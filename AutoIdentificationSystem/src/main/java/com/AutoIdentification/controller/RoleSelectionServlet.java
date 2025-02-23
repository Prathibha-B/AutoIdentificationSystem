package com.AutoIdentification.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoIdentification.dao.AIPAdminDao;

/**
 * Servlet implementation class RoleSelectionServlet
 */
@WebServlet("/RoleSelectionServlet")
public class RoleSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleSelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/RoleSelection.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String role=request.getParameter("role");
		if(role.equals("AIP Admin")){
			RequestDispatcher dispatcher=request.getRequestDispatcher("/views/AIPAdminRegistration.jsp");
			dispatcher.forward(request, response);
		}
		else if(role.equals("Bank Employee")) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/views/BankEmployeeRegistration.jsp");
			dispatcher.forward(request, response);
		}
			
	}

}
