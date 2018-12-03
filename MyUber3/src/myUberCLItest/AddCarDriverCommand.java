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
		
		for (Car car : CarFactory.getAllCars()) {
			System.out.println("CarID, Owners");
			System.out.println(car.getCarID()+", "+car.getOwnersList()+"\n");
		}
		
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			System.out.println("DriverID, Name, Surname, Number of Rides, Total Amount Cashed");
			System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed() + "\n");
		}
		
		MenuCommand.main(args);
	}

}
