package pl.coderslab;

import java.sql.Date;

public class Customer {

	private int id = 0;
	private String name = "";
	private String surname = "";
	private Date dateOfBirth;

	public Customer() {
	}

	public Customer(int id, String name, String surname, Date dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.id=id;
	}
	
	public Customer(String name, String surname, Date dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

}
