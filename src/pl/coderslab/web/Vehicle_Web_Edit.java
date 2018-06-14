package pl.coderslab.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.Vehicle;
import pl.coderslab.dao.VehicleDAO;

/**
 * Servlet implementation class Vehicle_Web_Edit
 */
@WebServlet("/Vehicle_Edit")
public class Vehicle_Web_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vehicle_Web_Edit() {
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
		VehicleDAO vehicleDAO = new VehicleDAO ();
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		try {
			vehicleDAO.edit(new Vehicle (Integer.parseInt((String) sess.getAttribute("id")), request.getParameter("model"), request.getParameter("brand"), 
					request.getParameter("yearOfProduction"), request.getParameter("registrationNumber"), new java.sql.Date (format.parse(request.getParameter("dateOfNextCheckUp")).getTime()), 
					Integer.parseInt(request.getParameter("customer_id"))));
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/Vehicle_Home").forward(request, response);
	}

}
