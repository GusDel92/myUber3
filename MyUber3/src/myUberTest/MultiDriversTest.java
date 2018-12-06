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
		MyUberBookOfRides myUberBookOfRides = MyUberBookOfRides.getInstance();
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		Driver josé = new Driver("José","Josétito");
		Car car1 = carFactory.createCar("standard", josé);
		josé.connect(car1, "uberX");
		Driver pedro = new Driver("Pedro","Pedrotito");
		Car car2 = carFactory.createCar("van", pedro);
		pedro.connect(car2, "uberVan");
		Driver carlo = new Driver("Carlo","Carlito");
		Car car3 = carFactory.createCar("berline", carlo);
		carlo.connect(car3, "uberBlack");
		Customer albert = new Customer("Albert","Bébert");
		Customer marc = new Customer("Marco","Thiebaud");
		Customer marie = new Customer("Marie","Lacoq");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination, 12);
		albert.selectRide("uberBlack");
		Coordinates destination1=Coordinates.destinationChoice();
		marie.comparePrices(destination1, 21);
		marie.selectRide("uberX");
		Coordinates destination2=Coordinates.destinationChoice();
		marc.comparePrices(destination2, 21);
		marc.selectRide("uberVan");
		Coordinates destination3=Coordinates.destinationChoice();
		albert.comparePrices(destination3, 21);
		albert.selectRide("UberPool");


	}

}
