package myUberRide;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import myUberCar.BerlineCar;
import myUberCar.Car;
import myUberCar.CarFactory;
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
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public ArrayList<Ride> getRidesOfTheRequest() {
		return ridesOfTheRequest;
	}


	public int getTotalNbrOfPassengers() {
		return totalNbrOfPassengers;
	}


	public boolean addRide(Ride ride) {
		if (this.ridesOfTheRequest.size()<3 & this.totalNbrOfPassengers+ride.getNbrOfPassengers()<=4) {  //On peut mettre 9 si on considère qu'un van peut faire uberPool. Pas hyper utile et ça complique pas mal.
			ridesOfTheRequest.add(ride);
			this.totalNbrOfPassengers=this.totalNbrOfPassengers+ride.getNbrOfPassengers();
			ride.status="unconfirmed";
			return true;
		}
		return false;
	}
	
	
	public void recoverPotentialCars(){
		for (Car car : CarFactory.getAllCars()){
			car.accept(this);
		}
	}
	
	private double minimalCost(Car car) {
		ArrayList<Coordinates> pickUpPoints = new ArrayList<Coordinates>();
		ArrayList<Coordinates> dropOffPoints = new ArrayList<Coordinates>();
		ArrayList<Coordinates> possibleNextStops = new ArrayList<Coordinates>();
		Coordinates currentPosition = car.getCarPosition();
		double minimalCost=0;
		
		for (Ride ride : ridesOfTheRequest) {
			pickUpPoints.add(ride.getDeparture());
			dropOffPoints.add(ride.getDestination());
			possibleNextStops.add(ride.getDeparture());
		}
		
		while (possibleNextStops.isEmpty()==false) {
			//on trie les prochains stop par ordre croissant de distance avec la position actuelle
			int k = possibleNextStops.size();
			for (int j=0;j<=k-1;j++) {
				Coordinates nextPossibleStop1 = possibleNextStops.get(j);
				Coordinates nextPossibleStop2 = possibleNextStops.get(j+1);
				double distToNextPossibleStop1 = currentPosition.distanceTo(nextPossibleStop1);
				double distToNextPossibleStop2 = currentPosition.distanceTo(nextPossibleStop2);
				if (distToNextPossibleStop1>distToNextPossibleStop2) {
					possibleNextStops.remove(j);
					possibleNextStops.add(j+1, nextPossibleStop1);
				}
				//quand c'est trié, on va au plus près, c'est à dire le premier de la liste
				Coordinates nextStop = possibleNextStops.get(0);
				minimalCost+=currentPosition.distanceTo(nextStop);
				currentPosition=nextStop; 
				if (pickUpPoints.contains(nextStop)){
					possibleNextStops.add(dropOffPoints.get(pickUpPoints.indexOf(nextStop)));
				}
				possibleNextStops.remove(0);
				
			}
			
			
		}

		return minimalCost;
	}
	
	
	public void sortPotentialCars() {
		int n = potentialCars.size();
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=n-1;j++) {
				Car car1 = potentialCars.get(j);
				Car car2 = potentialCars.get(j+1);
				double minimalCost1 = minimalCost(car1);
				double minimalCost2 = minimalCost(car2);
				if (minimalCost1>minimalCost2){
					potentialCars.remove(j);
					potentialCars.add(j+1, car1);
				}
			}
		}
	}

	public void proposeRequestToDrivers(){
		PoolRequests.currentRequests.remove(this);
		this.recoverPotentialCars();
		this.sortPotentialCars();
		while (this.status=="unconfirmed") {	
			for (Car potentialCar : this.potentialCars) {
				if (potentialCar.getCurrentDriver().getState()=="on-duty") {
					Scanner sc = new Scanner(System.in);
					System.out.println(potentialCar.getCurrentDriver().getName()+" do you want to take an UberPool ride ?");
					Boolean answer = sc.nextBoolean();
					//Thread.sleep(10000);
					if (answer==true){
						PoolRequests.deleteRequest(this);
						this.car=potentialCar;
						this.status="confirmed";
						this.driver=this.car.getCurrentDriver();
						this.driver.setState("on-a-ride");
						for (Ride ride : ridesOfTheRequest) {
							ride.setCar(potentialCar);
							ride.setStatus("confirmed");
							ride.setDriver(this.car.getCurrentDriver());
							ride.getDriver().setState("on-a-ride");
							ride.manageRide();}
						//potentialCars.removeAll(potentialCars);
						break;
					}
					
				}
			}
			//System.out.println("There is no available driver for your ride. Please try again.");
			//supprimer la ride.
		}	
		//sc.close();
	}

	@Override
	public void visit(StandardCar standardCar) {
		if (standardCar.getCurrentDriver().getState()=="on-duty" & standardCar.getActualTypeOfRideDesiredByDriver().equalsIgnoreCase("UBERPOOL")) {
			this.potentialCars.add(standardCar);
		}
		else {}
	}

	@Override
	public void visit(BerlineCar berlineCar) {
		if (berlineCar.getCurrentDriver().getState()=="on-duty" & berlineCar.getActualTypeOfRideDesiredByDriver().equalsIgnoreCase("UBERPOOL")) {
			this.potentialCars.add(berlineCar);
		}
		else {}
	}

	@Override
	public void visit(VanCar vanCar) {
		if (vanCar.getCurrentDriver().getState()=="on-duty" & vanCar.getActualTypeOfRideDesiredByDriver().equalsIgnoreCase("UBERPOOL")) {
			this.potentialCars.add(vanCar);
		}
		else {}
	}
	
}
