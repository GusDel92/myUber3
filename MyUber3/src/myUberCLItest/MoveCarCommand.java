package myUberCLItest;

import myUberCar.Car;
import myUberCar.CarFactory;


/**
 * This method chages the position of a given car. Attributes : car, latitude, longitude.
 * @author Cuignet & Thiébaud
 *
 */

public class MoveCarCommand {
	
	public static void main(String[] args){
		Boolean done=false;
		for (Car car : CarFactory.getAllCars()) {
			synchronized(car){
				if (car.getCarID()==args[0]) {
				car.getCarPosition().setLongitude(Double.parseDouble(args[1]));
				car.getCarPosition().setLatitude(Double.parseDouble(args[2]));
				done=true;
				}
			}
		}
		if (done == true){
			for (Car car : CarFactory.getAllCars()) {
				synchronized(car){
					System.out.println("carID : "+car.getCarID()+" --> (Longitude : "+Double.toString(car.getCarPosition().getLongitude())+", Latitude : "+Double.toString(car.getCarPosition().getLongitude())+")");
					}
				}
			}
			
		
		else{
			System.out.print("Error: there is no car with such ID.");
		}
		
		
		
	}

}
