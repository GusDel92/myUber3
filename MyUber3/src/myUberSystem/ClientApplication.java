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
		Driver José = new Driver("José","Josétito");
		carFactory.createCar("standard", José);
		Customer Albert = new Customer("Albert","Bébert");
		Coordinates destination=Coordinates.destinationChoice();
		Albert.comparePrices(destination);
	}

}
