package pl.coderslab;

import java.sql.Date;

public class Vehicle {

	private int id = 0;
	private String model = "";
	private String brand = "";
	private String yearOfProduction = "";
	private String registrationNumber = "";
	private Date dateOfNextCheckUp;
	private int customer_id = 0;

	public Vehicle() {

	}

	public Vehicle(int id, String model, String brand, 
			String yearOfProduction, String registrationNumber,
			Date dateOfNextCheckUp, int customer_id) {
		
		this.id=id;
		this.model=model;
		this.brand=brand;
		this.yearOfProduction=yearOfProduction;
		this.registrationNumber=registrationNumber;
		this.dateOfNextCheckUp=dateOfNextCheckUp;
		this.customer_id=customer_id;
		

	}

	public Vehicle(String model, String brand, 
			String yearOfProduction, String registrationNumber,
			Date dateOfNextCheckUp, int customer_id) {
		
		this.model=model;
		this.brand=brand;
		this.yearOfProduction=yearOfProduction;
		this.registrationNumber=registrationNumber;
		this.dateOfNextCheckUp=dateOfNextCheckUp;
		this.customer_id=customer_id;
		

	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(String yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getDateOfNextCheckUp() {
		return dateOfNextCheckUp;
	}

	public void setDateOfNextCheckUp(Date dateOfNextCheckUp) {
		this.dateOfNextCheckUp = dateOfNextCheckUp;
	}

	public int getId() {
		return id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

}
