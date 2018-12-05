package myUberCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import myUberDriver.Driver;
import myUberDriver.Drivers;

public class CarFactory {
	private final List<String> possibleCarTypes = Arrays.asList("van","berline","standard");
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
		else if (type.equalsIgnoreCase("berline")){
			BerlineCar newCar = new BerlineCar(type, owner);
			allCars.add(newCar);
			return newCar;
		}
		else if (type.equalsIgnoreCase("standard")){
			StandardCar newCar = new StandardCar(type, owner);
			allCars.add(newCar);
			return newCar;
		}
		
		return null;
	}
	
	public ArrayList<Car> getAllCars() {
		return allCars;
	}

	public List<String> getPossibleCarTypes() {
		return possibleCarTypes;
	}	
}
