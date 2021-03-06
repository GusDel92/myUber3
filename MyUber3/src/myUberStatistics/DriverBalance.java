package myUberStatistics;

import java.util.ArrayList;
import java.util.Collections;

import myUberCar.Car;
import myUberDriver.Driver;
import myUberDriver.Drivers;

/**
 * Driver balance is a class that provide a set of computing relevant statistic methods on drivers. 
 *@author Cuignet & Thi�baud
 */
public class DriverBalance {
	
	public static int totalRidesPerformed(Driver driver){return driver.getTotalNumberOfRides();};
	
	public static double totalAmoutCashed(Driver driver){return driver.getTotalAmountCashed();};
	
	public static double onDutyRateOfDriving(Driver driver){return driver.getTotalDrivingCustomersTime().getSeconds()/driver.getTotalOnDutyTime().getSeconds(); };
	
	public static double rateOfActivity(Driver driver){return 1 - driver.getTotalOffDutyTime().getSeconds()/driver.getTotalInCarTime().getSeconds();};
	
	public static double occupationRate(Driver driver){
		if(driver.getTotalDrivingCustomersTime().plus(driver.getTotalOnDutyTime()).getSeconds()==0) {return(0);}
		else {return driver.getTotalOnDutyTime().getSeconds()/driver.getTotalDrivingCustomersTime().plus(driver.getTotalOnDutyTime()).getSeconds();}
		}
	
	/**
	 * This sorting method uses the Collections class, and the comparators instantiated in the driver class.
	 * @return 
	 */
	public static String leastOccupiedDriver(){
		Collections.sort(Drivers.getInstance().getDriversList(), Driver.OccupationComparator);
		String sort = "\nDrivers sorted by occupation:";
		sort=sort+"\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed";
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			sort=sort+"\n"+driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed();
			}
		return(sort);
		}
	
		
	/**
	 * This sorting method uses the Collections class, and the comparators instantiated in the driver class.
	 * @return 
	 */
	public static String mostAppreciatedDriver(){
		Collections.sort(Drivers.getInstance().getDriversList(), Driver.AppreciationComparator);
		String sort = "\nDrivers sorted by appreciation:";
		sort=sort+"\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed";
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			sort=sort+"\n"+driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed();
			}
		return(sort);
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
