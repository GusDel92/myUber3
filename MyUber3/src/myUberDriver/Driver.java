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
	
	public Driver() {
		counter++;
		this.driverID=counter;
		this.state="Offline";
		this.name=null;
		this.rate=0;
		this.rideNbr=0;
		this.totalInCarTime=0;
		this.totalOnDutyTime=0;
		this.totalDrivingCustomersTime=0;
		this.totalOffDutyTime=0;
	}

	public void getDriverInfo(Driver driver) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name: ");
		driver.setName(scan.nextLine());
		System.out.println("Enter your surname: ");
		driver.setSurname(scan.nextLine());
		scan.close();
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
		ride.driverId=this.driverID;
		this.state="On-a-ride";
	}
	
	public void computeNewRate(Ride ride) {
		this.rate=(this.rate+ride.rate)/(this.rideNbr);
	}

}
