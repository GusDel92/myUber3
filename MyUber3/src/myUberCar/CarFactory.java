package myUberCar;

import java.util.ArrayList;

import myUberDriver.Driver;

public class CarFactory {

	private static ArrayList<Car> allCars = new ArrayList<Car>();
	
	public CarFactory() {
	}

	public Car createCar(String type, Driver owner) {
		if (type.equalsIgnoreCase("van")){
			VanCar newCar = new VanCar(type, owner);
			allCars.add(newCar);
			return newCar;
		}
		if (type.equalsIgnoreCase("berline")){
			BerlineCar newCar = new BerlineCar(type, owner);
			allCars.add(newCar);
			return newCar;
		}
		if (type.equalsIgnoreCase("standard")){
			StandardCar newCar = new StandardCar(type, owner);
			allCars.add(newCar);
			return newCar;
		}
		
		return null;
	}
	
	public static ArrayList<Car> getAllCars() {
		return allCars;
	}	
}
