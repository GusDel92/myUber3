package myUberCar;

import java.util.ArrayList;

import myUberDriver.Driver;
import myUberDriver.Drivers;

public class CarFactory {

	private ArrayList<Car> allCars = new ArrayList<Car>();
	
	private static CarFactory instance = new CarFactory();
	
	public static CarFactory getInstance(){
			
			return instance;
	}
	
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
	
	public ArrayList<Car> getAllCars() {
		return allCars;
	}	
}
