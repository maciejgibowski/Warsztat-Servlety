package pl.coderslab.web;
import pl.coderslab.*;
import pl.coderslab.dao.CommissionDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//zeby przechowac w sesji aktywne naprawy
		HttpSession sess= request.getSession();//poberamy sesje do nowej zmiennej
		List <Commission> activeCommissionList = new ArrayList<>();//tworzymy liste do ktorej wsadzimy liste aktywnych naprawa
		CommissionDAO commissionDAO = new CommissionDAO();//tworzymy obiekt commissionDAO
		activeCommissionList= commissionDAO.getActiveRepairs();//przypisujemy liste oviektowi
		
		sess.setAttribute("activeCommissionList", activeCommissionList);//zapisujemy do sesji, nadpisujemy
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);//przekazujemy do strony index
		//sesja sie przenosi
		
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
