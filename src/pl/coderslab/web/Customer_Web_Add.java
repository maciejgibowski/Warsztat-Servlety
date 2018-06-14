package pl.coderslab.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.Customer;
import pl.coderslab.dao.CustomerDAO;

/**
 * Servlet implementation class Customer_Web_Add
 */
@WebServlet("/Customer_Add")
public class Customer_Web_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_Web_Add() {
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
		CustomerDAO customerDAO = new CustomerDAO ();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Customer customer = new Customer(request.getParameter("name"), request.getParameter("surname"), 
					new java.sql.Date (format.parse(request.getParameter("dateOfBirth")).getTime()));
			customerDAO.add(customer);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/Customer_Home").forward(request, response);
	}

}
