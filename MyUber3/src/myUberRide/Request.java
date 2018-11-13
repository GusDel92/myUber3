package myUberRide;

import myUberCar.BerlineCar;
import myUberCar.StandardCar;
import myUberCar.VanCar;

public interface Request {
	void visit(StandardCar standardCar);
	void visit(BerlineCar berlineCar);
	void visit(VanCar vanCar);
}