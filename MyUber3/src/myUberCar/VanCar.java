package myUberCar;

import myUberRide.Request;

public class VanCar extends Car {

	public VanCar(int VanID) {
		super(VanID);
		// TODO Auto-generated constructor stub
		
		setTotalSeats(6);
	}
	
	@Override
	public void accept(Request visitor) {
		visitor.visit(this);
	}
}
