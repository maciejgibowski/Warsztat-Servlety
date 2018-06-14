package pl.coderslab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.Commission;
import pl.coderslab.dao.CommissionDAO;

/**
 * Servlet implementation class Commission_Web_PreEdit
 */
@WebServlet("/Commission_PreEdit")
public class Commission_Web_PreEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commission_Web_PreEdit() {
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
		CommissionDAO commissionDAO = new CommissionDAO ();
		Commission changedCommission = commissionDAO.getById(Integer.parseInt(request.getParameter("id")));
		sess.setAttribute("changedCommission", changedCommission);
		getServletContext().getRequestDispatcher("/commission_form_edit_2.jsp").forward(request, response);
	}
	}


