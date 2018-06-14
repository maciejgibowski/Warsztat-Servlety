package pl.coderslab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.Employee;
import pl.coderslab.dao.EmployeeDAO;

/**
 * Servlet implementation class Employee_Web_PreEdit
 */
@WebServlet("/Employee_PreEdit")
public class Employee_Web_PreEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Web_PreEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		sess.setAttribute("id", request.getParameter("id"));
		EmployeeDAO employeeDAO = new EmployeeDAO ();
		Employee changedEmployee = employeeDAO.getById(Integer.parseInt(request.getParameter("id")));
		sess.setAttribute("changedEmployee", changedEmployee);
		getServletContext().getRequestDispatcher("/employee_form_edit_2.jsp").forward(request, response);
	}

}
