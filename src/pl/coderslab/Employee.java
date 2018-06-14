package pl.coderslab;

public class Employee {

	private int id = 0;
	private String name = "";
	private String surname = "";
	private String address = "";
	private String phoneNumber = "";
	private String notes = "";
	private double workhourCost = 0;

	public Employee() {

	}

	public Employee(int id, String name, String surname, String address, 
			String phoneNumber, String notes,
			double workhourCost) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.notes = notes;
		this.workhourCost = workhourCost;

	}
	
	public Employee( String name, String surname, String address, 
			String phoneNumber, String notes,
			double workhourCost) {
		
	
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.notes = notes;
		this.workhourCost = workhourCost;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getWorkhourCost() {
		return workhourCost;
	}

	public void setWorkhourCost(double workhourCost) {
		this.workhourCost = workhourCost;
	}

	public int getId() {
		return id;
	}

}
