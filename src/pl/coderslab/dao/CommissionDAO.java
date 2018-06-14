package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pl.coderslab.MySQLHelper;

import pl.coderslab.Commission;


public class CommissionDAO {

	private static void executeUpdate(Connection con, String sql, Date dateOfAcceptance, Date plannedDateOfRepair,
			Date dateOfRepair, int assignedEmployee, String problemDescription, String repairDescription, int status_id,
			int vehicle_id, double repairCost, double customerCost, double componentsCost, double workhour_cost,
			int amountOfWorkhours)

			throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setDate(1, dateOfAcceptance);
		stm.setDate(2, plannedDateOfRepair);
		stm.setDate(3, dateOfRepair);
		stm.setInt(4, assignedEmployee);
		stm.setString(5, problemDescription);
		stm.setString(6, repairDescription);
		stm.setInt(7, status_id);
		stm.setInt(8, vehicle_id);
		stm.setDouble(9, repairCost);
		stm.setDouble(10, customerCost);
		stm.setDouble(11, componentsCost);
		stm.setDouble(12, workhour_cost);
		stm.setInt(13, amountOfWorkhours);
		stm.executeUpdate();

	}

	private static void executeUpdate(Connection con, String sql, Date dateOfAcceptance, Date plannedDateOfRepair,
			Date dateOfRepair, int assignedEmployee, String problemDescription, String repairDescription, int status_id,
			int vehicle_id, double repairCost, double customerCost, double componentsCost, double workhour_cost,
			int amountOfWorkhours, int id)

			throws SQLException {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setDate(1, dateOfAcceptance);
		stm.setDate(2, plannedDateOfRepair);
		stm.setDate(3, dateOfRepair);
		stm.setInt(4, assignedEmployee);
		stm.setString(5, problemDescription);
		stm.setString(6, repairDescription);
		stm.setInt(7, status_id);
		stm.setInt(8, vehicle_id);
		stm.setDouble(9, repairCost);
		stm.setDouble(10, customerCost);
		stm.setDouble(11, componentsCost);
		stm.setDouble(12, workhour_cost);
		stm.setInt(13, amountOfWorkhours);
		stm.setInt(14, id);
		stm.executeUpdate();

	}

	public void add(Commission commission) {
		String sql = "INSERT INTO commission(dateOfAcceptance, plannedDateOfRepair, dateOfRepair, "
				+ "assignedEmployee,problemDescription,repairDescription,status_id,vehicle_id,repairCost,"
				+ "customerCost,componentsCost,workhour_cost,amountOfWorkhours) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			executeUpdate(conn, sql, commission.getDateOfAcceptance(), commission.getPlannedDateOfRepair(),
					commission.getDateOfRepair(), commission.getAssignedEmployee(), commission.getProblemDescription(),
					commission.getRepairDescription(), commission.getStatus_id(), commission.getVehicle_id(),
					commission.getRepairCost(), commission.getCustomerCost(), commission.getComponentsCost(),
					commission.getWorkhour_cost(), commission.getAmountOfWorkhours());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void edit(Commission commission) {
		String sql = "UPDATE commission SET dateOfAcceptance = ?, plannedDateOfRepair = ?, dateOfRepair = ?, " + 
				"assignedEmployee=?, problemDescription=?, repairDescription=?, " + 
				"status_id=?,vehicle_id=?,repairCost=?,customerCost=?,componentsCost=?,workhour_cost=?, " + 
				"amountOfWorkhours=? WHERE id = ?;";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			executeUpdate(conn, sql, commission.getDateOfAcceptance(), commission.getPlannedDateOfRepair(),
					commission.getDateOfRepair(), commission.getAssignedEmployee(), commission.getProblemDescription(),
					commission.getRepairDescription(), commission.getStatus_id(), commission.getVehicle_id(),
					commission.getRepairCost(), commission.getCustomerCost(), commission.getComponentsCost(),
					commission.getWorkhour_cost(), commission.getAmountOfWorkhours(), commission.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

 
	public List<Commission> getActiveRepairs(){
		List<Commission> commissionList = new ArrayList<>();
		String sql = "SELECT C.id, C.dateOfAcceptance, C.plannedDateOfRepair, C.dateOfRepair, C.assignedEmployee,\n" + 
				"C.problemDescription, C.repairDescription, C.status_id, C.vehicle_id, C.repairCost,\n" + 
				"C.customerCost, C.componentsCost, C.workhour_cost, C.amountOfWorkhours\n" + 
				"FROM status S JOIN commission C ON S.id=C.status_id WHERE S.isReady=false AND S.resignation=false AND S.isAccepted=true;";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			ResultSet rs = MySQLHelper.executeQuery(conn, sql);
			while (rs.next()) {
				Commission commission = new Commission(rs.getInt("id"), rs.getDate("dateOfAcceptance"),
						rs.getDate("plannedDateOfRepair"), rs.getDate("dateOfRepair"), rs.getInt("assignedEmployee"),
						rs.getString("problemDescription"), rs.getString("repairDescription"), rs.getInt("status_id"),
						rs.getInt("vehicle_id"), rs.getDouble("repairCost"), rs.getDouble("customerCost"),
						rs.getDouble("componentsCost"), rs.getDouble("workhour_cost"), rs.getInt("amountOfWorkhours"));

				commissionList.add(commission);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commissionList;
		
		
	}
	
	public Commission getById(int id) {
		String sql = "SELECT * FROM commission WHERE id=?";
		Commission commission = new Commission();
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {

			ResultSet rs = MySQLHelper.executeQuery(conn, sql, Integer.toString(id));
			while (rs.next()) {
				commission = new Commission(rs.getInt("id"), rs.getDate("dateOfAcceptance"),
						rs.getDate("plannedDateOfRepair"), rs.getDate("dateOfRepair"), rs.getInt("assignedEmployee"),
						rs.getString("problemDescription"), rs.getString("repairDescription"), rs.getInt("status_id"),
						rs.getInt("vehicle_id"), rs.getDouble("repairCost"), rs.getDouble("customerCost"),
						rs.getDouble("componentsCost"), rs.getDouble("workhour_cost"), rs.getInt("amountOfWorkhours"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return commission;
	}
	
	
	
	
	public void remove(int id) throws MySQLIntegrityConstraintViolationException {
		String sql = "DELETE FROM commission WHERE id=?";
		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			MySQLHelper.executeUpdate(conn, sql, Integer.toString(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Commission> getList() {
		List<Commission> commissionList = new ArrayList<>();
		String sql = "SELECT * FROM commission";

		try (Connection conn = MySQLHelper.getConnection("JEE04_Warsztaty4")) {
			ResultSet rs = MySQLHelper.executeQuery(conn, sql);
			while (rs.next()) {
				Commission commission = new Commission(rs.getInt("id"), rs.getDate("dateOfAcceptance"),
						rs.getDate("plannedDateOfRepair"), rs.getDate("dateOfRepair"), rs.getInt("assignedEmployee"),
						rs.getString("problemDescription"), rs.getString("repairDescription"), rs.getInt("status_id"),
						rs.getInt("vehicle_id"), rs.getDouble("repairCost"), rs.getDouble("customerCost"),
						rs.getDouble("componentsCost"), rs.getDouble("workhour_cost"), rs.getInt("amountOfWorkhours"));

				commissionList.add(commission);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commissionList;
	}

}
