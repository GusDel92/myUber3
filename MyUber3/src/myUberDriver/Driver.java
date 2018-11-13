package myUberDriver;

import java.util.Scanner;

import myUberCar.Car;
import myUberRide.Ride;

public class Driver {
	
	private static int counter = 0;
	private int driverID;
	private String name;
	private String surname;
	private String state;
	private Car actualCar;
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
	
	public Car getActualCar() {
		return actualCar;
	}

	public void setActualCar(Car actualCar) {
		this.actualCar = actualCar;
	}

	//ça marche de mettre this ici? ou bien public void acceptRide(Driver driver, Ride ride) {, puis changer this par driver?
	public void acceptRide(Ride ride) {
		ride.driver=this;
		this.state="On-a-ride";
		ride.status="confirmed";
		
	}
	
	//même question que pcdmt
	public void computeNewRate(Ride ride) {
		this.rate=(this.rate+ride.rate)/(this.rideNbr);
	}


	
}
