package myUberSystem;

import myUberRide.*;
import myUberCar.*;
import myUberDriver.*;

public class ClientApplication {

	public static void main(String[] args) {
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		Driver José = new Driver("José","Josétito");
		carFactory.createCar("standard", José);

	}

}
