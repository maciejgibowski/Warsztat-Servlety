package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pl.coderslab.Vehicle;
import pl.coderslab.Employee;
import pl.coderslab.MySQLHelper;

public class VehicleDAO {

	private static void executeUpdate(Connection con, String sql, String model, String brand, String yearOfProduction,
			String registrationNumber, Date dateOfNextCheckUp, int customer_id) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, model);
		stm.setString(2, brand);
		stm.setString(3, yearOfProduction);
		stm.setString(4, registrationNumber);
		stm.setDate(5, dateOfNextCheckUp);
		stm.setInt(6, customer_id);
		stm.executeUpdate();
	}

	private static void executeUpdate(Connection con, String sql, String model, String brand, String yearOfProduction,
			String registrationNumber, Date dateOfNextCheckUp, int customer_id, int id) throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, model);
		stm.setString(2, brand);
		stm.setString(3, yearOfProduction);
		stm.setString(4, registrationNumber);
		stm.setDate(5, dateOfNextCheckUp);
		stm.setInt(6, customer_id);
		stm.setInt(7, id);
		stm.executeUpdate();
	}

	public Vehicle getById(int id) {
		String sql = "SELECT * FROM vehicle WHERE id=?";
		Vehicle vehicle = new Vehicle();
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql, Integer.toString(id));
			while (rs.next()) {
				vehicle = new Vehicle(rs.getInt("id"), rs.getString("model"), rs.getString("brand"),
						rs.getString("yearOfProduction"), rs.getString("registrationNumber"),
						rs.getDate("dateOfNextCheckUp"), rs.getInt("customer_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return vehicle;
	}

	public void add(Vehicle vehicle) {
		String sql = "INSERT INTO vehicle(model, brand, yearOfProduction, registrationNumber,"
				+ "dateOfNextCheckUp,customer_id) VALUES(?,?,?,?,?,?)";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			executeUpdate(conn, sql, vehicle.getModel(), vehicle.getBrand(), vehicle.getYearOfProduction(),
					vehicle.getRegistrationNumber(), vehicle.getDateOfNextCheckUp(), vehicle.getCustomer_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void edit(Vehicle vehicle) {
		String sql = "UPDATE vehicle SET model = ?, brand = ?, yearOfProduction = ?,"
				+ "registrationNumber=?, dateOfNextCheckUp=?, customer_id=? WHERE id = ?";
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			executeUpdate(conn, sql, vehicle.getModel(), vehicle.getBrand(), vehicle.getYearOfProduction(),
					vehicle.getRegistrationNumber(), vehicle.getDateOfNextCheckUp(), vehicle.getCustomer_id(),
					vehicle.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(int id) throws MySQLIntegrityConstraintViolationException {
		String sql = "DELETE FROM vehicle WHERE id=?";
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			MySQLHelper.executeUpdate(conn, sql, Integer.toString(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Vehicle> getList() {
		List<Vehicle> vehicleList = new ArrayList<>();
		String sql = "SELECT * FROM vehicle";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql);
			while (rs.next()) {
				Vehicle vehicle = new Vehicle(rs.getInt("id"), rs.getString("model"), rs.getString("brand"),
						rs.getString("yearOfProduction"), rs.getString("registrationNumber"),
						rs.getDate("dateOfNextCheckUp"), rs.getInt("customer_id"));

				vehicleList.add(vehicle);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

}
