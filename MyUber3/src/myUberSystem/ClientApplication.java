package myUberSystem;

import myUberRide.*;
import myUberTools.*;
import myUberCar.*;
import myUberCustomer.*;
import myUberDriver.*;

public class ClientApplication {

	public static void main(String[] args) {
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		Driver Jos� = new Driver("Jos�","Jos�tito");
		carFactory.createCar("standard", Jos�);
		Customer Albert = new Customer("Albert","B�bert");
		Coordinates destination=Coordinates.destinationChoice();
		Albert.comparePrices(destination);
	}

}
