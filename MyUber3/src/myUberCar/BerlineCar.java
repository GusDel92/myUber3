package myUberCar;

import myUberDriver.Driver;
import myUberRide.Request;

public class BerlineCar extends Car {

	private static int berlineID = 0;
	
	public BerlineCar(String type, Driver owner) {
		super(type, owner);	
		berlineID++;
		this.setCarID(berlineID);
		setTotalSeats(4);
	}
	
	@Override
	public void accept(Request visitor) {
		visitor.visit(this);
	}

	
}
