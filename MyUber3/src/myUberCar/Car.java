package myUberCar;


import java.util.ArrayList;

import myUberSupplyClasses.Coordinates;
import myVelibUsers.User;




public abstract class Car {
	
	private int carID;
	private int totalSeats;
	private ArrayList<Drivers> ownersList;
	private Coordinates carPosition;
	private int currentDriver; 
	private int freeseats;
	
	public Car(int carID) {
		super();
		this.carID = carID;
	}
	
	
	public void addOwner(Driver newOwner){
		this.ownersList.add(newOwner);
	
		
	}

	public ArrayList<Drivers> getOwnersList() {
		return ownersList;
	}

	public void setOwnersList(ArrayList<Drivers> ownersList) {
		this.ownersList = ownersList;
	}

}
