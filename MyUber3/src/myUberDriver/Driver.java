package myUberDriver;

import java.util.Scanner;

import myUberRide.Ride;

public class Driver {
	
	private static int counter = 0;
	private int driverID;
	private String name;
	private String surname;
	private String state;
	private double rate;
	private int rideNbr;
	private double totalInCarTime;
	private double totalOnDutyTime;
	private double totalDrivingCustomersTime;
	private double totalOffDutyTime;
	
	public Driver(String name, String surname) {
		counter++;
		this.driverID=counter;
		this.state="Offline";
		this.name=name;
		this.surname=surname;
		this.rate=0;
		this.rideNbr=0;
		this.totalInCarTime=0;
		this.totalOnDutyTime=0;
		this.totalDrivingCustomersTime=0;
		this.totalOffDutyTime=0;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	//�a marche de mettre this ici? ou bien public void acceptRide(Driver driver, Ride ride) {, puis changer this par driver?
	public void acceptRide(Ride ride) {
		ride.driverId=this.driverID;
		this.state="On-a-ride";
		ride.status="confirmed";
	}
	
	//m�me question que pcdmt
	public void computeNewRate(Ride ride) {
		this.rate=(this.rate+ride.rate)/(this.rideNbr);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + driverID;
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
		Driver other = (Driver) obj;
		if (driverID != other.driverID)
			return false;
		return true;
	}
	

}
