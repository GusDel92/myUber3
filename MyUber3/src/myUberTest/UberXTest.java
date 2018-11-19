package myUberTest;

import java.io.File;
import java.util.ArrayList;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberRide.Ride;
import myUberRide.RideFactory;
import myUberStatistics.MyUberBookOfRides;
import myUberTools.Coordinates;

public class UberXTest {

	public static void main(String[] args) {
		
		ArrayList<String> l = new ArrayList<String>();
		MyUberBookOfRides myUberBookOfRides = new MyUberBookOfRides(l);
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		
		//creation of driver jos�
		Driver jos� = new Driver("Jos�","Jos�tito");
		
		//creation of car standard
		Car car1 = carFactory.createCar("standard", jos�);
		
		//connexion between car1 and jos�
		jos�.connect(car1, "uberX");
		
		//creation of customer albert
		Customer albert = new Customer("Albert","B�bert");
		
		//asking the coordinates of the destination
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination);
		
		//albert chooses an uberX ride among the potential ones
		Ride selectedRide = albert.getPotentialRideOrder().get(0);
		albert.selectRide(selectedRide);
		
		//good beahviour of the  book  of rides
		System.out.println(MyUberBookOfRides.myUberBookOfRides);
	}

}
