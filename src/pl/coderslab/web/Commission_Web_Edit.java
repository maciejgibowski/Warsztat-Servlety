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

import pl.coderslab.*;
import pl.coderslab.dao.CommissionDAO;


/**
 * Servlet implementation class Employee_Web_Edit
 */
@WebServlet("/Commission_Edit")
public class Commission_Web_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commission_Web_Edit() {
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
		CommissionDAO commissionDAO = new CommissionDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Commission newCommission = new Commission(
					Integer.parseInt((String)sess.getAttribute("id")),
					new java.sql.Date(format.parse(request.getParameter("dateOfAcceptanceF")).getTime()),
					new java.sql.Date(format.parse(request.getParameter("plannedDateOfRepairF")).getTime()),
					new java.sql.Date(format.parse(request.getParameter("dateOfRepairF")).getTime()),
					Integer.parseInt(request.getParameter("assignedEmployeeF")),
					request.getParameter("problemNotesF"), request.getParameter("repairNotesF"),
					Integer.parseInt(request.getParameter("status_idF")),
					Integer.parseInt(request.getParameter("vehicle_idF")),
					Double.parseDouble(request.getParameter("repairCostF")),
					Double.parseDouble(request.getParameter("customerCostF")),
					Double.parseDouble(request.getParameter("componentsCostF")),
					Double.parseDouble(request.getParameter("workhour_costF")),
					Integer.parseInt(request.getParameter("amountOfWorkhoursF")));
					commissionDAO.edit(newCommission);
					/*System.out.println(String.format("%s, %s, %s, %d, %s, %s, %d, %d, %f, %f, %f, %f, %d", newCommission.getDateOfAcceptance(), 
							newCommission.getPlannedDateOfRepair(), newCommission.getDateOfRepair(), newCommission.getAssignedEmployee(), newCommission.getProblemDescription(),
							newCommission.getRepairDescription(), newCommission.getStatus_id(), newCommission.getVehicle_id(), newCommission.getRepairCost(), 
							newCommission.getCustomerCost(), newCommission.getComponentsCost(), newCommission.getWorkhour_cost(), newCommission.getAmountOfWorkhours()));*/
		} catch (ParseException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/Commission_Home").forward(request, response);
	}

}
