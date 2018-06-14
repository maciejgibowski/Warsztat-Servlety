package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pl.coderslab.*;

public class CustomerDAO {

	private static void executeUpdate(Connection con, String sql, String name, String surname, Date dateOfBirth)
			throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, name);
		stm.setString(2, surname);
		stm.setDate(3, dateOfBirth);
		stm.executeUpdate();
	}

	private static void executeUpdate(Connection con, String sql, String name, String surname, Date dateOfBirth, int id)
			throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, name);
		stm.setString(2, surname);
		stm.setDate(3, dateOfBirth);
		stm.setInt(4, id);
		stm.executeUpdate();
	}

	public void add(Customer customer) {
		String sql = "INSERT INTO customer(name, surname, dateOfBirth) VALUES(?,?,?)";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			executeUpdate(conn, sql, customer.getName(), customer.getSurname(), customer.getDateOfBirth());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void edit(Customer customer) {
		String sql = "UPDATE customer SET name = ?, surname = ?, dateOfBirth = ? WHERE id = ?";
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			executeUpdate(conn, sql, customer.getName(), customer.getSurname(), customer.getDateOfBirth(),
					customer.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(int id) throws MySQLIntegrityConstraintViolationException {
		String sql = "DELETE FROM customer WHERE id=?";
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			MySQLHelper.executeUpdate(conn, sql, Integer.toString(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Customer getById(int id) {
		String sql = "SELECT * FROM customer WHERE id=?";
		Customer customer = new Customer();
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql, Integer.toString(id));
			while (rs.next()) {
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
						rs.getDate("dateOfBirth"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return customer;
	}

	public List<Customer> getList() {
		List<Customer> customerList = new ArrayList<>();
		String sql = "SELECT * FROM customer";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql);
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
						rs.getDate("dateOfBirth"));

				customerList.add(customer);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

}
