package pl.coderslab.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.MySQLHelper;

/**
 * Servlet implementation class Report_2
 */
@WebServlet("/Report2")
public class Report_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report_2() {
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
		double value = 0;
		String sql = "SELECT SUM(customerCost) AS sum FROM commission WHERE dateOfRepair > ? AND dateOfRepair < ?;";
		try (Connection con = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			PreparedStatement stm = con.prepareStatement(sql);
			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
			stm.setDate(1, new java.sql.Date (format.parse(request.getParameter("fromDate")).getTime()));
			stm.setDate(2, new java.sql.Date (format.parse(request.getParameter("toDate")).getTime()));
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				value = rs.getDouble("sum");
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		sess.setAttribute("value", value);
		getServletContext().getRequestDispatcher("/report_2_post.jsp").forward(request, response);
	}

}
