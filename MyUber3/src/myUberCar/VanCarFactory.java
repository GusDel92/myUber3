package myUberCar;

import myVelibBicycles.MechanicalBicycle;
import myVelibBicycles.MechanicalBicycleFactory;

public class VanCarFactory extends CarFactory {
	
	private static int VanID;
	
	private static VanCarFactory instance = new VanCarFactory();
	
	public static VanCarFactory getinstance(){
		 return instance;
	}

	@Override
	public VanCar createCar() {
		
		VanID++;
		return new VanCar(VanID);
		
		
	}

}
