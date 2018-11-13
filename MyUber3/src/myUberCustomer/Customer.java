package myUberCustomer;

import java.util.ArrayList;
import java.util.Scanner;

import myUberTools.Coordinates;
import myUberTools.Message;

public class Customer {

	private static int counter = 0;
	private int customerID;
	private int creditCardNbr;
	public String name;
	public String surname;
	public Coordinates coordinates;
    ArrayList<Message> messageBox = new ArrayList<Message>();
	
	
	public Customer(String name, String surname) {
		counter++;
		this.customerID=counter;
		this.name=name;
		this.surname=surname;
		this.coordinates.longitude=0;
		this.coordinates.latitude=0;
		
		
		Customers.getInstance().addCustomer(this);
	}

	public Customer(String name, String surname, int creditCardNbr) {
		counter++;
		this.customerID=counter;
		this.name=name;
		this.surname=surname;
		this.creditCardNbr=creditCardNbr;
		this.coordinates.longitude=0;
		this.coordinates.latitude=0;
		
		
		Customers.getInstance().addCustomer(this);
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

	public void setCreditCardNbr(int creditCardNbr) {
		this.creditCardNbr = creditCardNbr;
	}

	public int getCustomerID() {
		return customerID;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	
	
	

}