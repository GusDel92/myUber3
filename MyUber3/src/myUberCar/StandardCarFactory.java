package myUberCar;

public class StandardCarFactory extends CarFactory {
	
	private static int StandardID;
	
	private static StandardCarFactory instance = new StandardCarFactory();
	
	public static StandardCarFactory getinstance(){
		 return instance;
		 
	}

	@Override
	public StandardCar createCar() {
		
		StandardID++;
		return new StandardCar(StandardID);
		
	}

}


