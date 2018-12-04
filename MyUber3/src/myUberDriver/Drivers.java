package myUberDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class' only instance stores all the created drivers. Whenever one wants to create a new driver, one must create it with this Drivers object as attribute, and this automatically adds this new driver to the driversList of this Drivers object. To make sure this class is only instantiated once, the singleton pattern is used here.
 * @author Cuignet & Thiébaud
 *
 */public class Drivers {
	
	private static ArrayList<Driver> driversList = new ArrayList<Driver>();
	private static ArrayList<Driver> onDutyDrivers = new ArrayList<Driver>();
	final static List<String> possibleStates = Arrays.asList("on-duty","off-duty","on-a-ride","offline");
	
	private static Drivers instance = new Drivers();
	
	public static Drivers getInstance(){
			
			return instance;
	}
	
	/**
	 * This method adds a driver to the list of created users
	 * @param driver
	 * @author Cuignet & Thiébaud
	 */
	public void addDriver(Driver driver) {
			driversList.add(driver);		
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
	
	public static void addOnDutyDriver(Driver driver) {
		Drivers.onDutyDrivers.add(driver);
	}

	public void removeOnDutyDriver(Driver driver) {
		Drivers.onDutyDrivers.remove(driver);
	}

}
