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
		Driver josé = new Driver("José","Josétito");
		Car car1 = carFactory.createCar("standard", josé);
		josé.connect(car1, "uberPool");
		//System.out.println(CarFactory.getAllCars().get(0).getActualTypeOfRideDesiredByDriver());
		Customer albert = new Customer("Albert","Bébert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		albert.selectRide(albert.getPotentialRideOrder().get(3));
	}

}
