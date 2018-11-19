package myUberTest;

import java.util.ArrayList;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberRide.RideFactory;
import myUberStatistics.CustomerBalance;
import myUberStatistics.DriverBalance;
import myUberStatistics.MyUberBookOfRides;
import myUberTools.Coordinates;

public class StatisticsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> l = new ArrayList<String>();
		MyUberBookOfRides myUberBookOfRides = new MyUberBookOfRides(l);
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
		Customer augustin = new Customer("Augustin","Cuignet");
		Customer marie = new Customer("Marie","Lacoquinette");
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
		System.out.println(CustomerBalance.totalNumberOfRides(marie));
		System.out.println(CustomerBalance.totalAmountOfCashSpent(marc));
		System.out.println(CustomerBalance.totalTimeSpentOnCar(albert));
		System.out.println(CustomerBalance.mostChargedCustomer());
		System.out.println(CustomerBalance.mostFrequentCustomer());
		System.out.println(DriverBalance.onDutyRateOfDriving(josé));
		System.out.println(DriverBalance.leastOccupiedDriver());
		System.out.println(MyUberBookOfRides.myUberBookOfRides);


	}

}
