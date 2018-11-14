package myUberRide;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import myUberCar.BerlineCar;
import myUberCar.Car;
import myUberCar.StandardCar;
import myUberCar.VanCar;
import myUberDriver.Driver;
import myUberTools.Coordinates;

public class PoolRequest implements Request{
	
	ArrayList<Ride> ridesOfTheRequest=new ArrayList<Ride>();
	private int totalNbrOfPassengers;
	private String status;
	protected ArrayList<Car> potentialCars = new ArrayList<Car>();
	private Driver driver;
	private Car car;
	private Coordinates departure;
	private Coordinates destination;
	
	public boolean addRide(Ride ride) {
		if (this.ridesOfTheRequest.size()<3 & this.totalNbrOfPassengers+ride.getNbrOfPassengers()<=4) {  //On peut mettre 9 si on considère qu'un van peut faire uberPool. Pas hyper utile et ça complique pas mal.
			ridesOfTheRequest.add(ride);
			this.totalNbrOfPassengers=this.totalNbrOfPassengers+ride.getNbrOfPassengers();
			ride.status="unconfirmed";
			return true;
		}
		return false;
	}
	
	public void proposeRequestToDrivers(PoolRequest request){
		while (this.status=="unconfirmed") {	
			for (Car potentialCar : this.potentialCars) {
				if (potentialCar.getCurrentDriver().getState()=="on-duty") {
					Scanner sc = new Scanner(System.in);
					System.out.println(potentialCar.getCurrentDriver().getName()+" do you want to take a UberPool ride from"+this.departure.getLatitude()+", "+this.departure.getLongitude()+" to "+this.destination.getLatitude()+", "+this.destination.getLongitude()+" ?");
					String answer = sc.next();
					//Thread.sleep(10000);
					if (answer.equalsIgnoreCase("yes")){
						this.car=potentialCar;
						this.status="confirmed";
						this.driver=this.car.getCurrentDriver();
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

	@Override
	public void visit(StandardCar standardCar) {
		if (standardCar.getCurrentDriver().getState()=="on-duty" & standardCar.getActualTypeOfRideDesiredByDriver().equalsIgnoreCase("UBERPOOL")) {
			this.potentialCars.add(standardCar);
		}
		
	}

	@Override
	public void visit(BerlineCar berlineCar) {
		if (berlineCar.getCurrentDriver().getState()=="on-duty" & berlineCar.getActualTypeOfRideDesiredByDriver().equalsIgnoreCase("UBERPOOL")) {
			this.potentialCars.add(berlineCar);
		}
	}

	@Override
	public void visit(VanCar vanCar) {
		if (vanCar.getCurrentDriver().getState()=="on-duty" & vanCar.getActualTypeOfRideDesiredByDriver().equalsIgnoreCase("UBERPOOL")) {
			this.potentialCars.add(vanCar);
		}
	}
	
	
}
