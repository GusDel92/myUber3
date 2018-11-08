package myUberCustomer;

import java.util.ArrayList;

import myUberTools.Coordinates;
import myUberTools.Message;

public class Customer {

	private static int counter = 0;
	private int id;
	public String name;
	public String surname;
	public Coordinates coordinates;
    ArrayList<Message> messageBox = new ArrayList<Message>();
	
	
	public Customer() {
		counter++;
		this.id=counter;
		this.name=null;
		this.surname=null;
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

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

}