package pl.coderslab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.*;
import pl.coderslab.dao.EmployeeDAO;

/**
 * Servlet implementation class Employee_Web_Edit
 */
@WebServlet("/Employee_Edit")
public class Employee_Web_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Web_Edit() {
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
		HttpSession sess = request.getSession();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.edit(new Employee(Integer.parseInt((String) sess.getAttribute("id")), request.getParameter("name"),
				request.getParameter("surname"), request.getParameter("address"), request.getParameter("phoneNumber"), 
				request.getParameter("notes"), Double.parseDouble(request.getParameter("rate"))));
		getServletContext().getRequestDispatcher("/Employee_Home").forward(request, response);
	}

}
