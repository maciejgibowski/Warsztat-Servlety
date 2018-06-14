package pl.coderslab.web;



import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pl.coderslab.Commission;
import pl.coderslab.dao.CommissionDAO;
import pl.coderslab.dao.StatusDAO;



@WebServlet("/Commission_Remove")

public class Commission_Web_Remove extends HttpServlet {

	private static final long serialVersionUID = 1L;



    public Commission_Web_Remove() {

        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		CommissionDAO commissionDAO = new CommissionDAO();		
		Commission commission = commissionDAO.getById(Integer.parseInt(request.getParameter("id")));
		StatusDAO statusDAO = new StatusDAO();
		try {
			statusDAO.remove(commission.getStatus_id());
			commissionDAO.remove(Integer.parseInt(request.getParameter("id")));
		} catch (MySQLIntegrityConstraintViolationException | NumberFormatException e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/Commission_Home").forward(request, response);	

	}

}
