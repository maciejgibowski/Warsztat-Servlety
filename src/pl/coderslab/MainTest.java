package pl.coderslab;
import java.util.List;

import pl.coderslab.*;
import pl.coderslab.dao.*;
public class MainTest {

	public static void main(String[] args) {
		
		java.util.Date date1 = new java.util.Date (1999, 9, 16);
		java.sql.Date dateSQL1 = new java.sql.Date (date1.getTime());
		Customer customer1=new Customer ("Jan","Kowalski", dateSQL1);
		
		java.util.Date date2 = new java.util.Date (2000, 1, 22);
		java.sql.Date dateSQL2 = new java.sql.Date (date2.getTime());
		Customer customer2=new Customer ("Andrzej","Nowak", dateSQL2);
		
		java.util.Date date3 = new java.util.Date (2009, 11, 30);
		java.sql.Date dateSQL3 = new java.sql.Date (date3.getTime());
		Customer customer3=new Customer ("Anna","Malinowska", dateSQL3);
		
		CustomerDAO customerDAO = new CustomerDAO ();
		
		customerDAO.add(customer1);
		customerDAO.add(customer2);
		customerDAO.add(customer3);
		
		List <Customer> customerList = customerDAO.getList();
		
		for (Customer customer : customerList) {
			System.out.println(String.format("%s, %s %s, %s", customer.getId(), customer.getName(), customer.getSurname(), customer.getDateOfBirth()));
		}
		System.out.println();
		
		java.util.Date date4 = new java.util.Date (1979, 12, 19);
		java.sql.Date dateSQL4 = new java.sql.Date (date4.getTime());
		customerDAO.edit(new Customer (2, "Andrzej", "Karolak", dateSQL4));
		
		customerList = customerDAO.getList();
		
		for (Customer customer : customerList) {
			System.out.println(String.format("%s, %s %s, %s", customer.getId(), customer.getName(), customer.getSurname(), customer.getDateOfBirth()));
		}
		System.out.println();
				
		customerList = customerDAO.getList();
		
		for (Customer customer : customerList) {
			System.out.println(String.format("%s, %s %s, %s", customer.getId(), customer.getName(), customer.getSurname(), customer.getDateOfBirth()));
		}
		System.out.println();
		
	}

}
