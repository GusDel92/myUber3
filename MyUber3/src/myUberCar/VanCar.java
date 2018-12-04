package myUberCar;

import myUberDriver.Driver;
import myUberRide.Request;

public class VanCar extends Car {

	private static int vanCarCounter = 0;
	
	public VanCar(String type, Driver owner) {
		super(type, owner);
		vanCarCounter++;
		this.setCarID("van"+vanCarCounter);
		setTotalSeats(6);
		this.possibleTypesOfRide.add("uberVan");
		this.possibleTypesOfRide.add("uberPool");
		this.possibleTypesOfRide.add("uberX");
	}
	
	@Override
	public void accept(Request visitor) {
		visitor.visit(this);
	}
}


