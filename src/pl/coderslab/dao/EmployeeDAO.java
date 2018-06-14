package pl.coderslab.dao;

import java.sql.Connection;

import java.sql.Date;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pl.coderslab.Customer;

import pl.coderslab.Employee;

import pl.coderslab.MySQLHelper;

public class EmployeeDAO {

	private static void executeUpdate(Connection con, String sql, int id, String name, String surname, String address,
			String phoneNumber, String noteS, double workhourcost) throws SQLException {

		PreparedStatement stm = con.prepareStatement(sql);

		stm.setString(1, name);

		stm.setString(2, surname);

		stm.setString(3, address);

		stm.setString(4, phoneNumber);

		stm.setString(5, noteS);

		stm.setDouble(6, workhourcost);
		
		stm.setInt(7, id);

		stm.executeUpdate();

	}

	private static void executeUpdate(Connection con, String sql, String name, String surname,

			String address, String phoneNumber, String noteS, double workhourcost) throws SQLException {

		PreparedStatement stm = con.prepareStatement(sql);

		stm.setString(1, name);

		stm.setString(2, surname);

		stm.setString(3, address);

		stm.setString(4, phoneNumber);

		stm.setString(5, noteS);

		stm.setDouble(6, workhourcost);

		stm.executeUpdate();

	}
	

	public void add(Employee employee) {

		String sql = "INSERT INTO employee (name, surname, address, phoneNumber, notes, workhourcost)"

				+ " VALUES(?, ?, ?, ?, ?, ?)";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			executeUpdate(conn, sql, employee.getName(), employee.getSurname(), employee.getAddress(),

					employee.getPhoneNumber(), employee.getNotes(), employee.getWorkhourCost());

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void edit(Employee employee) {

		String sql = "UPDATE employee SET name= ?, surname= ?, address= ?, phoneNumber=?,"

				+ "notes= ?, workhourcost= ? WHERE id= ?";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			executeUpdate(conn, sql, employee.getId(), employee.getName(), employee.getSurname(), employee.getAddress(),

					employee.getPhoneNumber(), employee.getNotes(), employee.getWorkhourCost());

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void remove(int id) throws MySQLIntegrityConstraintViolationException {

		String sql = "DELETE FROM employee WHERE id=?";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			MySQLHelper.executeUpdate(conn, sql, Integer.toString(id));

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public Employee getById(int id) {
		String sql = "SELECT * FROM employee WHERE id=?";
		Employee employee = new Employee();
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql, Integer.toString(id));
			while (rs.next()) {
				employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
						rs.getString("address"), rs.getString("phoneNumber"), rs.getString("notes"),
						rs.getDouble("workhourcost"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return employee;
	}

	
	public double getWorkhourCost(int id) {
		String sql= "SELECT workhourCost FROM employee WHERE id=?";
		double result = 0;
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")){
			ResultSet rs = MySQLHelper.executeQuery(conn, sql, Integer.toString(id));
			result= Double.parseDouble(rs.getString("workhourCost"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	public List<Employee> getList() {

		List<Employee> employeeList = new ArrayList<>();

		String sql = "SELECT * FROM employee";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql);

			while (rs.next()) {

				Employee employee = new Employee(rs.getInt("id"), rs.getString("name"),

						rs.getString("surname"), rs.getString("address"), rs.getString("phoneNumber"),

						rs.getString("notes"), rs.getDouble("workhourcost"));

				employeeList.add(employee);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return employeeList;

	}

}
