package myUberCar;

import myUberDriver.Driver;
import myUberRide.Request;

public class VanCar extends Car {

	private static int vanCarCounter = 0;
	
	public VanCar(String type, Driver owner) {
		super(type, owner);
		vanCarCounter++;
		this.setCarID(vanCarCounter);
		setTotalSeats(6);
	}
	
	@Override
	public void accept(Request visitor) {
		visitor.visit(this);
	}
}
