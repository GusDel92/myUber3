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
		Driver josé = new Driver("José","Josétito");
		Car car1 = carFactory.createCar("standard", josé);
		josé.connect(car1, "uberX");
		Driver pedro = new Driver("Pedro","Pedrotito");
		Car car2 = carFactory.createCar("standard", pedro);
		pedro.connect(car2, "uberX");
		Driver carlo = new Driver("Carlo","Carlito");
		Car car3 = carFactory.createCar("standard", carlo);
		carlo.connect(car3, "uberX");
		Customer albert = new Customer("Albert","Bébert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		albert.selectRide(albert.getPotentialRideOrder().get(0));
		Coordinates destination1=Coordinates.destinationChoice();
		albert.comparePrices(destination1);
		albert.selectRide(albert.getPotentialRideOrder().get(0));
		System.out.println(MyUberBookOfRides.myUberBookOfRides);


	}

}
