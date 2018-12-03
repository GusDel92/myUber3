package myUberCLItest;

import myUberDriver.Driver;
import myUberDriver.Drivers;

public class AddDriverCommand {

	public static void main(String[] args) {
		Driver newDriver = new Driver(args[0], args[1]);
		
		//il faut encore associer la voiture dont l'identifiant est args[2] au driver ! => Liste pour chaque driver des voitures dont il est proprio ?
		
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			System.out.println("DriverID, Name, Surname, Number of Rides, Total Amount Cashed");
			System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed() + "\n");
		}
		
		MenuCommand.main(args);
	}

}
