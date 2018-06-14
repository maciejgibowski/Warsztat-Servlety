package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pl.coderslab.MySQLHelper;
import pl.coderslab.Status;

public class StatusDAO {

	private static void executeUpdate(Connection con, String sql, boolean isAccepted, double acceptedRepairCost,
			boolean isRepaired, boolean isReady, boolean resignation) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setBoolean(1, isAccepted);
		stm.setDouble(2, acceptedRepairCost);
		stm.setBoolean(3, isRepaired);
		stm.setBoolean(4, isReady);
		stm.setBoolean(5, resignation);
		stm.executeUpdate();
	}

	private static void executeUpdate(Connection con, String sql, boolean isAccepted, double acceptedRepairCost,
			boolean isRepaired, boolean isReady, boolean resignation, int id) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setBoolean(1, isAccepted);
		stm.setDouble(2, acceptedRepairCost);
		stm.setBoolean(3, isRepaired);
		stm.setBoolean(4, isReady);
		stm.setBoolean(5, resignation);
		stm.setInt(6, id);
		stm.executeUpdate();
	}
	
	public void edit(Status status) {

		String sql = "UPDATE status SET isAccepted = ?, acceptedRepairCost = ?, isRepaired = ?, " + "isReady = ?, "
				+ "resignation = ? WHERE id = ?";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			executeUpdate(conn, sql, status.getIsAccepted(), status.getAcceptedRepairCost(), status.getIsRepaired(),
					status.getIsReady(), status.getResignation(), status.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void add(Status status) { // obiekt Status wraz z wszystkimi atrybutami

		String sql = "INSERT INTO status (isAccepted, acceptedRepairCost, isRepaired, isReady,"
				+ " resignation) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			executeUpdate(conn, sql, status.getIsAccepted(), status.getAcceptedRepairCost(), status.getIsRepaired(),
					status.getIsReady(), status.getResignation());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Status getById(int id) {
		String sql = "SELECT * FROM status WHERE id=?";
		Status status = new Status();
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql, Integer.toString(id));
			while (rs.next()) {
				status = new Status(rs.getInt("id"), rs.getBoolean("isAccepted"), rs.getDouble("acceptedRepairCost"),
						rs.getBoolean("isRepaired"), rs.getBoolean("isReady"), rs.getBoolean("resignation"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}

	public Status getLast() {
		String sql = "SELECT * FROM status ORDER BY id DESC LIMIT 1;";
		Status status = new Status();
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql);
			while (rs.next()) {
				status = new Status(rs.getInt("id"), rs.getBoolean("isAccepted"), rs.getDouble("acceptedRepairCost"),
						rs.getBoolean("isRepaired"), rs.getBoolean("isReady"), rs.getBoolean("resignation"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}


	public void remove(int id) throws MySQLIntegrityConstraintViolationException {

		String sql = "DELETE FROM status WHERE id = ?";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			MySQLHelper.executeUpdate(conn, sql, Integer.toString(id));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Status> getList() { // Lista obiektów, które w sobie zawierają stringi, iny etc.

		List<Status> statusList = new ArrayList<>();
		String sql = "SELECT * FROM status";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			// QUERY to rekord, pętla sczytuje kolejno rekordy, więc potrzebna jest pętla,
			// żeby czytać kolejne linijki

			ResultSet rs = MySQLHelper.executeQuery(conn, sql);
			while (rs.next()) {
				Status status = new Status(rs.getInt("id"), rs.getBoolean("isAccepted"),
						rs.getDouble("acceptedRepairCost"), rs.getBoolean("isRepaired"), rs.getBoolean("isReady"),
						rs.getBoolean("resignation"));

				statusList.add(status);
			}
		} catch (SQLException e) {

		}
		return statusList;
	}
}
