package myUberDriver;

import java.util.ArrayList;

public class Drivers {
	
	private ArrayList<Driver> driversList = new ArrayList<Driver>();
	private static ArrayList<Driver> onDutyDrivers = new ArrayList<Driver>();
	
	private static Drivers instance = new Drivers();
	
	public static Drivers getInstance(){
			
			return instance;
	}
	
	/**
	 * This method adds a driver to the list of created users
	 * @param driver
	 */
	public void addDriver(Driver driver) {
			this.driversList.add(driver);		
	}

	public ArrayList<Driver> getDriversList() {
		return driversList;
	}

	public void setDriversList(ArrayList<Driver> driversList) {
		this.driversList = driversList;
	}

	public static void setInstance(Drivers instance) {
		Drivers.instance = instance;
	}

	public static ArrayList<Driver> getOnDutyDrivers() {
		return onDutyDrivers;
	}

	public ArrayList<Driver> getOnDutyDrivers(Driver driver) {
		return onDutyDrivers;
	}
	
	public void addOnDutyDriver(Driver driver) {
		Drivers.onDutyDrivers.add(driver);
	}

	public void removeOnDutyDriver(Driver driver) {
		Drivers.onDutyDrivers.remove(driver);
	}
}
