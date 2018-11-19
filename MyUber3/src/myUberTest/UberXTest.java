package myUberTest;

import java.io.File;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberRide.RideFactory;
import myUberTools.Coordinates;

public class UberXTest {

	public static void main(String[] args) {
		File myUberBookOfRides = new File("myUberBookOfRides.txt");
		CarFactory carFactory = new CarFactory();
		Driver josé = new Driver("José","Josétito");
		Car car1 = carFactory.createCar("standard", josé);
		josé.connect(car1, "uberX");
		Customer albert = new Customer("Albert","Bébert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		albert.selectRide(albert.getPotentialRideOrder().get(0));
		System.out.println(josé.getRate());
		
	}

}
