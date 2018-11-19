package myUberTest;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberRide.RideFactory;
import myUberTools.Coordinates;

public class MultiDriversTest {

	public static void main(String[] args) {
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		Driver jos� = new Driver("Jos�","Jos�tito");
		Car car1 = carFactory.createCar("standard", jos�);
		jos�.connect(car1, "uberX");
		Driver pedro = new Driver("Pedro","Pedrotito");
		Car car2 = carFactory.createCar("standard", pedro);
		pedro.connect(car2, "uberX");
		Driver carlo = new Driver("Carlo","Carlito");
		Car car3 = carFactory.createCar("standard", carlo);
		carlo.connect(car3, "uberX");
		Customer albert = new Customer("Albert","B�bert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		albert.selectRide(albert.getPotentialRideOrder().get(0));


	}

}
