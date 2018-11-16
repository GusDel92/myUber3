package myUberRide;

import java.util.Scanner;

import myUberCar.BerlineCar;
import myUberCar.StandardCar;
import myUberCar.VanCar;
import myUberDriver.Driver;
import myUberTools.Coordinates;
import myUberTools.Traffic;

public class UberPool extends Ride {

	PoolRequest request;
	
	public UberPool(Coordinates departure, Coordinates destination, Traffic traffic) {
		super(departure, destination, traffic);
		// TODO Auto-generated constructor stub
		this.type="uberpool";
		this.rateLengthInf5km=2.4;
		this.rateLength5To10km=3;
		this.rateLength10To20km=1.3;
		this.rateLengthSup20km=1.1;
		this.rateLowTraffic=1;
		this.rateMediumTraffic=1.1;
		this.rateHeavyTraffic=1.2;
	}

	
	@Override
	public void proposeRideToDrivers() {
		PoolRequests.manageNewRide(this);
		//request.proposeRequestToDrivers(request);
		//System.out.println("There is no available driver for your ride. Please try again.");
			//supprimer la ride
			
	}

	@Override
	public void manageRide() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Client récupéré ?");
		String answer = sc.next();
		if (answer=="yes") {
			this.setStatus("ongoing");
			System.out.println("Course terminée ?");
			String answer2 = sc.next();
			if (answer2=="yes") {this.setStatus("completed");}
			}
		
		sc.close();
	}

	@Override
	public void visit(StandardCar standardCar) {
	}

	@Override
	public void visit(BerlineCar berlineCar) {		
	}

	@Override
	public void visit(VanCar vanCar) {
	}

	public void setRequest(PoolRequest request) {
		this.request = request;
	}
}
