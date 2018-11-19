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
		Driver josé = new Driver("José","Josétito");
		Car car1 = carFactory.createCar("standard", josé);
		josé.connect(car1, "uberPool");
		Customer albert = new Customer("Albert","Bébert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		Customer rené = new Customer("René","Renénichou");
		Coordinates destination2=Coordinates.destinationChoice();
		rené.comparePrices(destination2);
		Customer bernard = new Customer("Bernard","Nanard");
		Coordinates destination3=Coordinates.destinationChoice();
		bernard.comparePrices(destination3);
		albert.selectRide(albert.getPotentialRideOrder().get(3));
		rené.selectRide(rené.getPotentialRideOrder().get(3));
		bernard.selectRide(bernard.getPotentialRideOrder().get(3)); 
	}

}
