package myUberCar;

import myUberRide.Request;

public class StandardCar extends Car {

	public StandardCar(int StandardID) {
		super(StandardID);		
		setTotalSeats(4);
		
	}
	
	@Override
	public void accept(Request visitor) {
		visitor.visit(this);
	}

}
