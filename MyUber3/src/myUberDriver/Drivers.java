package myUberDriver;

import java.util.ArrayList;

public class Drivers {
	
	private ArrayList<Driver> driversList = new ArrayList<Driver>();
	
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

}
