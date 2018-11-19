package myUberTest;

import java.util.ArrayList;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberRide.RideFactory;
import myUberStatistics.MyUberBookOfRides;
import myUberTools.Coordinates;

public class MultiDriversTest {

	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		MyUberBookOfRides myUberBookOfRides = new MyUberBookOfRides(l);
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		Driver jos� = new Driver("Jos�","Jos�tito");
		Car car1 = carFactory.createCar("standard", jos�);
		jos�.connect(car1, "uberX");
		Driver pedro = new Driver("Pedro","Pedrotito");
		Car car2 = carFactory.createCar("van", pedro);
		pedro.connect(car2, "uberVan");
		Driver carlo = new Driver("Carlo","Carlito");
		Car car3 = carFactory.createCar("berline", carlo);
		carlo.connect(car3, "uberBlack");
		Customer albert = new Customer("Albert","B�bert");
		Customer marc = new Customer("Marco","Thiebaud");
		Customer augustin = new Customer("Augustin","Cuignet");
		Customer marie = new Customer("Marie","Lacoq");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		albert.selectRide(albert.getPotentialRideOrder().get(0));
		Coordinates destination1=Coordinates.destinationChoice();
		marie.comparePrices(destination1);
		marie.selectRide(marie.getPotentialRideOrder().get(1));
		Coordinates destination2=Coordinates.destinationChoice();
		marc.comparePrices(destination2);
		marc.selectRide(marc.getPotentialRideOrder().get(2));
		Coordinates destination3=Coordinates.destinationChoice();
		albert.comparePrices(destination3);
		albert.selectRide(albert.getPotentialRideOrder().get(0));


	}

}
