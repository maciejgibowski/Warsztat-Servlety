package pl.coderslab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pl.coderslab.dao.VehicleDAO;

/**
 * Servlet implementation class Vehicle_Web_Remove
 */
@WebServlet("/Vehicle_Remove")
public class Vehicle_Web_Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vehicle_Web_Remove() {
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
		VehicleDAO vehicleDAO = new VehicleDAO ();
		try {
			vehicleDAO.remove(Integer.parseInt(request.getParameter("id")));
		} catch (MySQLIntegrityConstraintViolationException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/Vehicle_Home").forward(request, response);
	}

}
