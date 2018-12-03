package myUberCLItest;

import java.util.Random;

import myUberCar.BerlineCar;
import myUberCar.CarFactory;
import myUberCar.StandardCar;
import myUberCar.VanCar;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberTools.Coordinates;

public class SetUpCommand {

	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		Random rn = new Random();
		
		int nbrOfStandardCars = Integer.parseInt(args[0]);
		int nbrOfBerlineCars = Integer.parseInt(args[1]);
		int nbrOfVanCars = Integer.parseInt(args[2]);
		int nbrOfCustomers=Integer.parseInt(args[3]);
		
		Driver drivers[] = new Driver[nbrOfStandardCars+nbrOfBerlineCars+nbrOfVanCars];
		StandardCar standardCars[] = new StandardCar[nbrOfStandardCars];
		BerlineCar berlineCars[] = new BerlineCar[nbrOfBerlineCars];
		VanCar vanCars[] = new VanCar[nbrOfVanCars];
		Customer customers[] = new Customer[nbrOfCustomers];
		
		for (int i=0; i<nbrOfStandardCars; i++) {
			String name = "driverName"+i;
			String surname = "driverSurname"+i;
			drivers[i] = new Driver(name,surname);
			standardCars[i] = (StandardCar) carFactory.createCar("standard", drivers[i]);
			standardCars[i].setCarPosition(new Coordinates(rn.nextInt(101),rn.nextInt(101)));
		}
		
		for (int i=0; i<nbrOfBerlineCars; i++) {
			//index of the driver
			int j = nbrOfStandardCars+i;
			
			String name = "driverName"+j;
			String surname = "driverSurname"+j;
			drivers[j] = new Driver(name,surname);
			berlineCars[i] = (BerlineCar) carFactory.createCar("berline", drivers[j]);
			berlineCars[i].setCarPosition(new Coordinates(rn.nextInt(101),rn.nextInt(101)));
		}
		
		for (int i=0; i<nbrOfVanCars; i++) {
			//index of the driver
			int j = nbrOfStandardCars+nbrOfBerlineCars+i;
			
			String name = "driverName"+j;
			String surname = "driverSurname"+j;
			drivers[j] = new Driver(name,surname);
			vanCars[i] = (VanCar) carFactory.createCar("van", drivers[j]);
			vanCars[i].setCarPosition(new Coordinates(rn.nextInt(101),rn.nextInt(101)));
		}
		
		for (int i=0; i<nbrOfCustomers; i++) {
			String name = "customerName"+i;
			String surname = "customerSurname"+i;
			customers[i] = new Customer(name,surname);
			customers[i].setCoordinates(new Coordinates(rn.nextInt(101),rn.nextInt(101)));
		}
		
		System.out.println(customers[10].getCoordinates().getLatitude());
		
		MenuCommand.main(args);
	}

}
