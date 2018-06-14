package pl.coderslab;

import java.sql.Date;

public class Commission {

	private int id=0;
	private Date dateOfAcceptance;
	private Date plannedDateOfRepair;
	private Date dateOfRepair;
	private int assignedEmployee=0;
	private String problemDescription="";
	private String repairDescription="";
	private int status_id=0;
	private int vehicle_id=0;
	private double repairCost=0;
	private double customerCost=0;
	private double componentsCost=0;
	private double workhour_cost=0;
	private int amountOfWorkhours=0;
	
	
	public Commission (int id,Date dateOfAcceptance,Date plannedDateOfRepair, Date dateOfRepair,
			int assignedEmployee, String problemDescription, String repairDescription, 
			int status_id, int vehicle_id, double repairCost, double customerCost,
			double componentsCost, double workhour_cost,int amountOfWorkhours) {
		this.id=id;
		this.dateOfAcceptance=dateOfAcceptance;
		this.plannedDateOfRepair=plannedDateOfRepair;
		this.dateOfRepair=dateOfRepair;
		this.assignedEmployee=assignedEmployee;
		this.problemDescription=problemDescription;
		this.repairDescription=repairDescription;
		this.status_id=status_id;
		this.vehicle_id=vehicle_id;
		this.repairCost=repairCost;
		this.customerCost=customerCost;
		this.componentsCost=componentsCost;
		this.workhour_cost=workhour_cost;
		this.amountOfWorkhours=amountOfWorkhours;
		
		
	}
	
	
	
	
	public Commission (Date dateOfAcceptance,Date plannedDateOfRepair, Date dateOfRepair,
			int assignedEmployee, String problemDescription, String repairDescription, 
			int status_id, int vehicle_id, double repairCost, double customerCost,
			double componentsCost, double workhour_cost,int amountOfWorkhours) {
		
		this.dateOfAcceptance=dateOfAcceptance;
		this.plannedDateOfRepair=plannedDateOfRepair;
		this.dateOfRepair=dateOfRepair;
		this.assignedEmployee=assignedEmployee;
		this.problemDescription=problemDescription;
		this.repairDescription=repairDescription;
		this.status_id=status_id;
		this.vehicle_id=vehicle_id;
		this.repairCost=repairCost;
		this.customerCost=customerCost;
		this.componentsCost=componentsCost;
		this.workhour_cost=workhour_cost;
		this.amountOfWorkhours=amountOfWorkhours;
		
		
	}
	
	
	
	public Commission () {
	}




	public Date getDateOfAcceptance() {
		return dateOfAcceptance;
	}



	public void setDateOfAcceptance(Date dateOfAcceptance) {
		this.dateOfAcceptance = dateOfAcceptance;
	}



	public Date getPlannedDateOfRepair() {
		return plannedDateOfRepair;
	}



	public void setPlannedDateOfRepair(Date plannedDateOfRepair) {
		this.plannedDateOfRepair = plannedDateOfRepair;
	}



	public Date getDateOfRepair() {
		return dateOfRepair;
	}



	public void setDateOfRepair(Date dateOfRepair) {
		this.dateOfRepair = dateOfRepair;
	}



	public int getAssignedEmployee() {
		return assignedEmployee;
	}



	public void setAssignedEmployee(int assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}



	public String getProblemDescription() {
		return problemDescription;
	}



	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}



	public String getRepairDescription() {
		return repairDescription;
	}



	public void setRepairDescription(String repairDescription) {
		this.repairDescription = repairDescription;
	}



	public double getRepairCost() {
		return repairCost;
	}



	public void setRepairCost(double repairCost) {
		this.repairCost = repairCost;
	}



	public double getCustomerCost() {
		return customerCost;
	}



	public void setCustomerCost(double customerCost) {
		this.customerCost = customerCost;
	}



	public double getComponentsCost() {
		return componentsCost;
	}



	public void setComponentsCost(double componentsCost) {
		this.componentsCost = componentsCost;
	}



	public double getWorkhour_cost() {
		return workhour_cost;
	}



	public void setWorkhour_cost(double workhour_cost) {
		this.workhour_cost = workhour_cost;
	}



	public int getAmountOfWorkhours() {
		return amountOfWorkhours;
	}



	public void setAmountOfWorkhours(int amountOfWorkhours) {
		this.amountOfWorkhours = amountOfWorkhours;
	}



	public int getId() {
		return id;
	}



	public int getStatus_id() {
		return status_id;
	}



	public int getVehicle_id() {
		return vehicle_id;
	}
	
	
	
	
	
	
	
	
}
