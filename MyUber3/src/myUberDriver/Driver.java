package myUberDriver;

import myUberRide.Ride;

public class Driver {
	
	private int id;
	private String name;
	private String surname;
	private String state;
	private double rate;
	private int rideNbr;
	private double totalInCarTime;
	private double totalOnDutyTime;
	private double totalDrivingCustomersTime;
	private double totalOffDutyTime;
	
	public Driver(int id) {
		this.id=id;
		this.state="Offline";
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void acceptRide(Ride ride) {
		ride.driverId=this.id;
		this.state="On-a-ride";
	}
	
	public void computeNewRate(Ride ride) {
		this.rate=(this.rate+ride.rate)/(this.rideNbr);
	}

}
