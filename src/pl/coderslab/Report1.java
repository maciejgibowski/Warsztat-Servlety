package pl.coderslab;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Report1 {
	private String name = "";
	private String surname = "";
	private int workhours = 0;

	public Report1() {

	}

	public Report1(String name, String surname, int workhours) {
		this.name = name;
		this.surname = surname;
		this.workhours = workhours;
	}

	public static ResultSet executeQuery(Connection con, String sql, Date fromDate, Date toDate) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setDate(1, fromDate);
		stm.setDate(2, toDate);
		ResultSet rs = stm.executeQuery();
		return rs;
	}

	public static List<Report1> getList(Date fromDate, Date toDate) {
		String sql = "SELECT E.name, E.surname, SUM(amountOfWorkhours) AS sum FROM employee E LEFT JOIN commission C ON E.id=C.assignedEmployee "
				+ "WHERE dateOfAcceptance > ? AND dateOfAcceptance < ? " + "GROUP BY E.id;";
		List<Report1> list = new ArrayList<>();
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			ResultSet rs = executeQuery(conn, sql, fromDate, toDate);
			while (rs.next()) {
				list.add(new Report1(rs.getString("name"), rs.getString("surname"), rs.getInt("sum")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getWorkhours() {
		return workhours;
	}

	public void setWorkhours(int workhours) {
		this.workhours = workhours;
	}

}
