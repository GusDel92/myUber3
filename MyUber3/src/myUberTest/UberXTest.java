package myUberTest;


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
		MyUberBookOfRides myUberBookOfRides = MyUberBookOfRides.getInstance();
		RideFactory rideFactory = new RideFactory();
		CarFactory carFactory = new CarFactory();
		
		//creation of driver josé
		Driver josé = new Driver("José","Josétito");
		
		//creation of car standard
		Car car1 = carFactory.createCar("standard", josé);
		
		//connexion between car1 and josé
		josé.connect(car1, "uberX");
		
		//creation of customer albert
		Customer albert = new Customer("Albert","Bébert");
		
		//asking the coordinates of the destination
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination, 6);
		
		//albert chooses an uberX ride among the potential ones
		albert.selectRide("uberX");
		
		//good beahviour of the  book  of rides
		System.out.println(MyUberBookOfRides.getInstance().myUberBookOfRides);
	}

}
