package pl.coderslab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.*;
import pl.coderslab.*;

/**
 * Servlet implementation class Employee_Web_Add
 */
@WebServlet("/Employee_Web_Add")
public class Employee_Web_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Web_Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EmployeeDAO employeedao = new EmployeeDAO();
		 Employee newEmployee = new Employee (request.getParameter("name"), request.getParameter("surname"),
				 request.getParameter("address"), request.getParameter("phoneNumber"), request.getParameter("notes"),
				 Double.parseDouble(request.getParameter("rate")));
		 
		 employeedao.add(newEmployee);
		 getServletContext().getRequestDispatcher("/Employee_Home").forward(request, response);
		
		
	}

}
