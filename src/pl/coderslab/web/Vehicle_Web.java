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

import pl.coderslab.Vehicle;
import pl.coderslab.dao.VehicleDAO;

/**
 * Servlet implementation class Vehicle_Web
 */
@WebServlet("/Vehicle_Home")
public class Vehicle_Web extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vehicle_Web() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		List <Vehicle> vehicleList = new ArrayList<>();
		VehicleDAO vehicleDAO = new VehicleDAO();
		vehicleList = vehicleDAO.getList();
		
		sess.setAttribute("vehicleList", vehicleList);
		getServletContext().getRequestDispatcher("/vehicle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
