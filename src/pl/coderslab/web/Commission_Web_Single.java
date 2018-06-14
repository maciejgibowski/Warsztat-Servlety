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

import pl.coderslab.Commission;
import pl.coderslab.dao.CommissionDAO;

/**
 * Servlet implementation class Commission_Web_Single
 */
@WebServlet("/Commission_Single")
public class Commission_Web_Single extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commission_Web_Single() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess= request.getSession();//poberamy sesje do nowej zmiennej
		CommissionDAO commissionDAO = new CommissionDAO();//tworzymy obiekt commissionDAO
		Commission commission = commissionDAO.getById(Integer.parseInt(request.getParameter("id")));
		sess.setAttribute("commission", commission);
		
		getServletContext().getRequestDispatcher("/commission_single.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
