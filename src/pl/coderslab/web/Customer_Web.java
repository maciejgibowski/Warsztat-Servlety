package pl.coderslab.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.Customer;
import pl.coderslab.Employee;
import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.dao.EmployeeDAO;

/**
 * Servlet implementation class Customer_Web
 */
@WebServlet("/Customer_Home")
public class Customer_Web extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_Web() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess= request.getSession();
		List <Customer> customerList = new ArrayList<>();
		CustomerDAO customerDAO = new CustomerDAO();
		customerList= customerDAO.getList();
		
		sess.setAttribute("customerList", customerList);
		
		getServletContext().getRequestDispatcher("/customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
