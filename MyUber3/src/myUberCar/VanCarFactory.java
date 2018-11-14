package myUberCar;

import myUberDriver.Driver;

public class VanCarFactory extends CarFactory {
	
	private static int VanID;
	
	private static VanCarFactory instance = new VanCarFactory();
	
	public static VanCarFactory getinstance(){
		 return instance;
	}

	@Override
	public VanCar createCar(String type, Driver owner) {
		
		VanID++;
		return new VanCar(type, owner);
		
		
	}

}
