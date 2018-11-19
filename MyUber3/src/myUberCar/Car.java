package myUberCar;


import java.util.ArrayList;

import myUberTools.Coordinates;
import myUberDriver.Driver;
import myUberRide.Request;

public abstract class Car {
	
	private int carID;
	private int totalSeats;
	private ArrayList<Driver> ownersList = new ArrayList<Driver>();
	private Coordinates carPosition;
	private Driver currentDriver; 
	private int freeseats;
	private String type;
	private String actualTypeOfRideDesiredByDriver;
	protected ArrayList<String> possibleTypesOfRide = new ArrayList<String>();
	
	
	public Car(String type, Driver owner) {
		this.type=type;
		this.ownersList.add(owner);
		this.carPosition = new Coordinates();
	}
	
	
	
	public void addOwner(Driver newOwner){
		this.ownersList.add(newOwner);
	
		
	}
	
	public void accept(Request visitor) {
		
	}
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getCarID() {
		return carID;
	}


	public void setCarID(int carID) {
		this.carID = carID;
	}


	public int getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	public Coordinates getCarPosition() {
		return carPosition;
	}


	public void setCarPosition(Coordinates carPosition) {
		this.carPosition = carPosition;
	}


	public Driver getCurrentDriver() {
		return currentDriver;
	}


	public void setCurrentDriver(Driver currentDriver) {
		this.currentDriver = currentDriver;
	}


	public int getFreeseats() {
		return freeseats;
	}


	public void setFreeseats(int freeseats) {
		this.freeseats = freeseats;
	}


	public ArrayList<Driver> getOwnersList() {
		return ownersList;
	}

	public void setOwnersList(ArrayList<Driver> ownersList) {
		this.ownersList = ownersList;
	}


	public ArrayList<String> getPossibleTypesOfRide() {
		return possibleTypesOfRide;
	}


	public void setPossibleTypesOfRide(ArrayList<String> possibleTypesOfRide) {
		this.possibleTypesOfRide = possibleTypesOfRide;
	}


	public String getActualTypeOfRideDesiredByDriver() {
		return actualTypeOfRideDesiredByDriver;
	}


	public void setActualTypeOfRideDesiredByDriver(String actualTypeOfRideDesiredByDriver) {
		this.actualTypeOfRideDesiredByDriver = actualTypeOfRideDesiredByDriver;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carID;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Car other = (Car) obj;
		if (carID != other.carID)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	
	

}
