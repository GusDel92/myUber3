package myUberTest;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberRide.RideFactory;
import myUberTools.Coordinates;

public class UberXTest {

	public static void main(String[] args) {
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		Driver jos� = new Driver("Jos�","Jos�tito");
		Car car1 = carFactory.createCar("standard", jos�);
		jos�.connect(car1, "uberX");
		Customer albert = new Customer("Albert","B�bert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		albert.selectRide(albert.getPotentialRideOrder().get(0));

	}

}
