package pl.coderslab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.Vehicle;
import pl.coderslab.dao.VehicleDAO;

/**
 * Servlet implementation class Vehicle_Web_PreEdit
 */
@WebServlet("/Vehicle_PreEdit")
public class Vehicle_Web_PreEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vehicle_Web_PreEdit() {
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
		sess.setAttribute("id", request.getParameter("id"));
		VehicleDAO vehicleDAO = new VehicleDAO ();
		Vehicle changedVehicle = vehicleDAO.getById(Integer.parseInt(request.getParameter("id")));
		sess.setAttribute("changedVehicle", changedVehicle);
		getServletContext().getRequestDispatcher("/vehicle_form_edit_2.jsp").forward(request, response);
	}

}
