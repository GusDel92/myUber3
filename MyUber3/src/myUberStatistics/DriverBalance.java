package myUberStatistics;

import java.util.ArrayList;
import java.util.Collections;

import myUberCar.Car;
import myUberDriver.Driver;
import myUberDriver.Drivers;

/**
 * Driver balance is a class that provide a set of computing relevant statistic methods on drivers. 
 *@author Cuignet & Thiébaud
 */
public class DriverBalance {
	
	public static int totalRidesPerformed(Driver driver){return driver.getTotalNumberOfRides();};
	
	public static double totalAmoutCashed(Driver driver){return driver.getTotalAmountCashed();};
	
	public static double onDutyRateOfDriving(Driver driver){return driver.getTotalDrivingCustomersTime().getSeconds()/driver.getTotalOnDutyTime().getSeconds(); };
	
	public static double rateOfActivity(Driver driver){return 1 - driver.getTotalOffDutyTime().getSeconds()/driver.getTotalInCarTime().getSeconds();};
	
	public static double occupationRate(Driver driver){return driver.getTotalOnDutyTime().getSeconds()/driver.getTotalDrivingCustomersTime().plus(driver.getTotalOnDutyTime()).getSeconds(); };
	
	/**
	 * This sorting method uses the Collections class, and the comparators instantiated in the driver class.
	 */
	public static void leastOccupiedDriver(){
		Collections.sort(Drivers.getInstance().getDriversList(), Driver.OccupationComparator);
		System.out.println("\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed");
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed());
			}
		}
	
		
	/**
	 * This sorting method uses the Collections class, and the comparators instantiated in the driver class.
	 */
	public static void mostAppreciatedDriver(){
		Collections.sort(Drivers.getInstance().getDriversList(), Driver.AppreciationComparator);
		System.out.println("\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed");
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed());
		}
	}
		
	public static void totalAmountOfMoneyCashedByAllTheDrivers(Drivers drivers){
		double cash = 0.0;
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			cash = cash + driver.getTotalAmountCashed();
		}
		System.out.println(cash);
	}
	
	public static void totalNumberOfRidesPerformedByAllTheDrivers(Drivers drivers){
		int totalnumber = 0;
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			totalnumber = totalnumber + driver.getTotalNumberOfRides();
		}
		System.out.println(totalnumber);
	}
	
}
