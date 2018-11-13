package myUberRide;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import myUberCar.Car;
import myUberDriver.Driver;
import myUberTools.Coordinates;

public class PoolRequest {
	
	ArrayList<Ride> ridesOfTheRequest=new ArrayList<Ride>();
	private int totalNbrOfPassengers;
	private String status;
	protected ArrayList<Driver> potentialDrivers = new ArrayList<Driver>();
	public Driver driver;
	private Car car;
	private Coordinates departure;
	private Coordinates destination;
	
	public void addRide(Ride ride) {
		if (this.ridesOfTheRequest.size()<3 & this.totalNbrOfPassengers+ride.getNbrOfPassengers()<=4) {  //On peut mettre 9 si on considère qu'un van peut faire uberPool. Pas hyper utile et ça complique pas mal.
			ridesOfTheRequest.add(ride);
			this.totalNbrOfPassengers=this.totalNbrOfPassengers+ride.getNbrOfPassengers();
			ride.status="unconfirmed";
		}
		else {return;}
	}
	
	public void proposeRequestToDrivers(PoolRequest request) {
		while (this.status=="unconfirmed") {	
			for (Driver potentialDriver : this.potentialDrivers) {
				if (potentialDriver.getState()=="on-duty") {
					Scanner sc = new Scanner(System.in);
					System.out.println(potentialDriver.getName()+" do you want to take a ride from"+this.departure.getLatitude()+", "+this.departure.getLongitude()+" to "+this.destination.getLatitude()+", "+this.destination.getLongitude()+" ?");
					String answer = sc.next();
					//Thread.sleep(10000);
					if (answer.equalsIgnoreCase("yes")){
						this.driver=potentialDriver;
						this.status="confirmed";
						this.car=this.driver.getActualCar();
						this.driver.setState("on-a-ride");
						for (Ride ride : ridesOfTheRequest) {
							ride.manageRide();}
					sc.close();
					}
					
				}
			}
			System.out.println("There is no available driver for your ride. Please try again.");
			//supprimer la ride
		}	
	}
	
}
