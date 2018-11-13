package myUberCar;

import myUberRide.Request;

public class BerlineCar extends Car {

	public BerlineCar(int BerlineID) {
		super(BerlineID);		
		setTotalSeats(4);
	}
	
	@Override
	public void accept(Request visitor) {
		visitor.visit(this);
	}

}
