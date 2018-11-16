package myUberDriver;

import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;

import myUberCar.Car;
import myUberRide.Ride;

public class Driver {
	
	private static int driverCounter = 0;
	private int driverID;
	private String name;
	private String surname;
	private String state;
	private Car actualCar;
	private double rate;
	private int totalNumberOfRides;
	private Duration totalInCarTime;
	private Duration totalOnDutyTime;
	private Duration totalDrivingCustomersTime;
	private Duration totalOffDutyTime;
	
	public Driver(String name, String surname) {
		driverCounter++;
		this.driverID=driverCounter;
		this.state="offline";
		this.name=name;
		this.surname=surname;
		this.rate=0;
		this.totalNumberOfRides=0;
		this.totalInCarTime=0;
		this.totalOnDutyTime=0;
		this.totalDrivingCustomersTime=0;
		this.totalOffDutyTime=0;
		Drivers.getInstance().addDriver(this);
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

	public int getTotalNumberOfRides() {
		return totalNumberOfRides;
	}


	public void setTotalNumberOfRides(int totalNumberOfRides) {
		this.totalNumberOfRides = totalNumberOfRides;
	}


	public void acceptRide(Ride ride) {
		ride.driver=this;
		this.state="on-a-ride";
		ride.status="confirmed";
		
	}
	
	public void computeNewRate(Ride ride) {
		this.rate=(this.rate+ride.rate)/(this.totalNumberOfRides);
	}

	public void connect(Car car, String desiredTypeOfRide) {
		if (car.getOwnersList().contains(this)){
			if (car.getCurrentDriver()==null) {
				if (car.getPossibleTypesOfRide().contains(desiredTypeOfRide)) {
				car.setCurrentDriver(this);
				car.setActualTypeOfRideDesiredByDriver(desiredTypeOfRide);
				this.setActualCar(car);
				this.setState("on-duty");
				Drivers.addOnDutyDriver(this);
				}
				else {System.out.println("Imposible d'effectuer ce type de ride avec votre voiture.");}
			}
			else {System.out.println("Cette voiture est déjà occupée.");}
		}
		else {System.out.println("Vous n'êtes pas propriétaire de cette voiture.");}
	}

	public void disconnect() {
		this.getActualCar().setActualTypeOfRideDesiredByDriver(null);
		this.getActualCar().setCurrentDriver(null);
		this.setActualCar(null);
		this.setState("offline");	
	}
	
	public void takeABreak() {
		if (this.getState()=="on-duty") {this.setState("off-duty");}
	}
	public void endOfTheBreak() {
		if (this.getState()=="off-duty") {this.setState("on-duty");}
	}
}
