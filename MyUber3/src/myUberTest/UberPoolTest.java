package myUberTest;

import myUberRide.*;
import myUberTools.*;
import myUberCar.*;
import myUberCustomer.*;
import myUberDriver.*;

public class UberPoolTest {

	public static void main(String[] args) {
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		Driver jos� = new Driver("Jos�","Jos�tito");
		Car car1 = carFactory.createCar("standard", jos�);
		jos�.connect(car1, "uberPool");
		Customer albert = new Customer("Albert","B�bert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		Customer ren� = new Customer("Ren�","Ren�nichou");
		Coordinates destination2=Coordinates.destinationChoice();
		ren�.comparePrices(destination2);
		Customer bernard = new Customer("Bernard","Nanard");
		Coordinates destination3=Coordinates.destinationChoice();
		bernard.comparePrices(destination3);
		albert.selectRide(albert.getPotentialRideOrder().get(3));
		ren�.selectRide(ren�.getPotentialRideOrder().get(3));
		bernard.selectRide(bernard.getPotentialRideOrder().get(3)); 
	}

}
