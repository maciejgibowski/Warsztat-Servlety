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
 * Servlet implementation class Status_Web_PreEdit
 */
@WebServlet("/Status_PreEdit")
public class Status_Web_PreEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Status_Web_PreEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		sess.setAttribute("id", request.getParameter("id"));
		StatusDAO statusDAO = new StatusDAO ();
		Status changedStatus = statusDAO.getById(Integer.parseInt(request.getParameter("id")));
		sess.setAttribute("changedStatus", changedStatus);
		getServletContext().getRequestDispatcher("/status_form_edit.jsp").forward(request, response);
	}

}
