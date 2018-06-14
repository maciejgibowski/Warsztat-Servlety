package pl.coderslab.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.Commission;
import pl.coderslab.Employee;
import pl.coderslab.Status;
import pl.coderslab.dao.CommissionDAO;
import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.dao.StatusDAO;

/**
 * Servlet implementation class Commission_Web_Add
 */
@WebServlet("/Commission_Add")
public class Commission_Web_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Commission_Web_Add() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommissionDAO commissiondao = new CommissionDAO();
		StatusDAO statusdao = new StatusDAO ();
		// zbieramy z formularza
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeDAO employeedao =new EmployeeDAO();
		Employee currentEmployee = employeedao.getById(Integer.parseInt(request.getParameter("assignedEmployee")));
		
		
		try {
			Status newStatus = new Status (false, Double.parseDouble(request.getParameter("repairCost")), false, false, false);
			statusdao.add(newStatus);
			newStatus = statusdao.getLast();
			Commission newCommission = new Commission(
	new java.sql.Date(format.parse(request.getParameter("dateOfAcceptance")).getTime()),
	new java.sql.Date(format.parse(request.getParameter("plannedDateOfRepair")).getTime()),
	new java.sql.Date(format.parse(request.getParameter("dateOfRepair")).getTime()),
	Integer.parseInt(request.getParameter("assignedEmployee")),
	request.getParameter("problemDescription"), 
	request.getParameter("repairDescription"),
	newStatus.getId(),
	Integer.parseInt(request.getParameter("vehicle_id")),
	Double.parseDouble(request.getParameter("repairCost")),
	Double.parseDouble(request.getParameter("customerCost")),
	Double.parseDouble(request.getParameter("componentsCost")),
	currentEmployee.getWorkhourCost(),
	Integer.parseInt(request.getParameter("amountOfWorkhours")));
	commissiondao.add(newCommission);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// dodajemy do SQL

		getServletContext().getRequestDispatcher("/Commission_Home").forward(request, response);

	}

}
