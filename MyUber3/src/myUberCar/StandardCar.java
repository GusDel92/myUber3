package myUberCar;

import myUberDriver.Driver;
import myUberRide.Request;

public class StandardCar extends Car {

	private static int standardID = 0;
	
	public StandardCar(String type, Driver owner) {
		super(type, owner);
		standardID++;
		this.setCarID(standardID);
		setTotalSeats(4);
		
	}
	
	@Override
	public void accept(Request visitor) {
		visitor.visit(this);
	}

}
