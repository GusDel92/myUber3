package myUberCustomer;

import java.util.ArrayList;

import myUberTools.Coordinates;
import myUberTools.Message;

public class Customer {

	public String name;
	public String surname;
	public Coordinates coordinates;
    ArrayList<Message> messageBox = new ArrayList<Message>();
	
	public Customer() {
		this.name="Robert";
		this.surname="Bebert";
		this.coordinates.longitude=0;
		this.coordinates.latitude=0;
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