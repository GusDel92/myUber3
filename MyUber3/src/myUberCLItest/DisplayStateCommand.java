package myUberCLItest;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberCustomer.Customers;
import myUberDriver.Driver;
import myUberDriver.Drivers;

public class DisplayStateCommand {

	public static void main(String[] args) {
		//General Information
		System.out.println("\nInfo of the system:\nNumber of Customers: "+Customers.getInstance().getCustomersList().size()+"\nNumber of Drivers: "+Drivers.getInstance().getDriversList().size()+"\nNumber of Cars: "+CarFactory.getAllCars().size());
		//Customers Information
		System.out.println("\nCustomerID, Name, Surname, Number of Rides, Total Cash Spent");
		for (Customer customer : Customers.getInstance().getCustomersList()) {
			System.out.println(customer.getCustomerID() + ", "+customer.getName()+", "+customer.getSurname()+", "+customer.getTotalNumberOfRides()+", "+customer.getTotalAmountOfCashSpent());
		}
		//Drivers Information
		System.out.println("\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed");
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed());
		}
		//Cars Information
		System.out.println("\nCarID, Owners");
		for (Car car : CarFactory.getAllCars()) {
			System.out.println(car.getCarID()+", "+car.getOwnersList().toString());
		}
		MenuCommand.main(args);
	}

}
