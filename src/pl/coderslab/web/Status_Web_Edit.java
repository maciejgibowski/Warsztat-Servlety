package pl.coderslab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.Status;
import pl.coderslab.dao.StatusDAO;

/**
 * Servlet implementation class Status_Web_Edit
 */
@WebServlet("/Status_Edit")
public class Status_Web_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Status_Web_Edit() {
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
		StatusDAO statusDAO = new StatusDAO ();
		Status status = new Status(Integer.parseInt((String) sess.getAttribute("id")), Boolean.parseBoolean(request.getParameter("isAcceptedF")), Double.parseDouble(request.getParameter("acceptedRepairCostF")), 
				Boolean.parseBoolean(request.getParameter("isRepairedF")), Boolean.parseBoolean(request.getParameter("isReadyF")), 
				Boolean.parseBoolean(request.getParameter("resignationF")));
		System.out.println(Boolean.parseBoolean(request.getParameter("isAcceptedF")));
		statusDAO.edit(status);
		getServletContext().getRequestDispatcher("/Commission_Home").forward(request, response);
	}

}
