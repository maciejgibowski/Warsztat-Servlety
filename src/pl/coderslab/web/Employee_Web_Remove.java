package pl.coderslab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.dao.StatusDAO;

/**
 * Servlet implementation class Employee_Web_Remove
 */
@WebServlet("/Employee_Remove")
public class Employee_Web_Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Web_Remove() {
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
		 EmployeeDAO employeedao = new EmployeeDAO();
		 try {
			employeedao.remove(Integer.parseInt(request.getParameter("id")));
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Pododawać strony dla błędów
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} //Dodać stronę jsp dla każdego typu błędu która, ma link do strony employee_home
		 getServletContext().getRequestDispatcher("/Employee_Home").forward(request, response);
		
		 
	}

}
