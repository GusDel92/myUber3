package myUberStatistics;

import java.util.ArrayList;

import myUberCar.Car;
import myUberDriver.Driver;
import myUberDriver.Drivers;

public class DriverBalance {
	
	public int totalRidesPerformed(Driver driver){return driver.getTotalNumberOfRides();};
	
	public double totalAmoutCashed(Driver driver){return driver.getTotalAmountCashed();};
	
	public double onDutyRateOfDriving(Driver driver){return driver.getTotalDrivingCustomersTime().getSeconds()/driver.getTotalOnDutyTime().getSeconds(); };
	
	public double rateOfActivity(Driver driver){return 1 - driver.getTotalOffDutyTime().getSeconds()/driver.getTotalInCarTime().getSeconds();};
	
	public double occupationRate(Driver driver){return driver.getTotalOnDutyTime().getSeconds()/driver.getTotalDrivingCustomersTime().plus(driver.getTotalOnDutyTime()).getSeconds(); };
	
	public ArrayList<Driver> leastOccupiedDriver(){
		ArrayList <Driver> driversList = Drivers.getInstance().getDriversList();
		int n = driversList.size();
		for (int i=0;i<=n;i++) {
			for (int j=1;j<=n-1;j++) {
				Driver driver1 = driversList.get(j);
				Driver driver2 = driversList.get(j+1);
				double occupationRate1 = occupationRate(driver1);
				double occupationRate2 = occupationRate(driver2);
				if (occupationRate1<occupationRate2){
					driversList.remove(j);
					driversList.add(j+1, driver1);
				}
			}
		}
		return driversList;
	};
	
	public ArrayList<Driver> mostAppreciatedDriver(){
		ArrayList <Driver> driversList = Drivers.getInstance().getDriversList();
		int n = driversList.size();
		for (int i=0;i<=n;i++) {
			for (int j=1;j<=n-1;j++) {
				Driver driver1 = driversList.get(j);
				Driver driver2 = driversList.get(j+1);
				if (driver1.getRate()<driver2.getRate()){
					driversList.remove(j);
					driversList.add(j+1, driver1);
			}
		}
	}
	return driversList;
};
	
	public double totalAmountOfMoneyCashedByAllTheDrivers(Drivers drivers);
	
	public int totalNumberOfRidesPerformedByAllTheDrivers(Drivers drivers);
}
