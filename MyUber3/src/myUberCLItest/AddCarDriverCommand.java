package myUberCLItest;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberCustomer.Customers;
import myUberDriver.Driver;
import myUberDriver.Drivers;

public class AddCarDriverCommand {

	public static void main(String[] args) {
		Driver newDriver = new Driver(args[0], args[1]);
		SetUpCommand.carFactory.createCar(args[2], newDriver);
		
		System.out.println("\nCarID, Owners");
		for (Car car : CarFactory.getAllCars()) {
			System.out.println(car.getCarID()+", "+car.getOwnersList().toString());
		}
		
		System.out.println("\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed");
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed());
		}
		
		MenuCommand.main(args);
	}

}
