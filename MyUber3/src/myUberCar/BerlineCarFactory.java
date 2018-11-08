package myUberCar;

public class BerlineCarFactory extends CarFactory{
	
	private static int BerlineID;
	
	private static BerlineCarFactory instance = new BerlineCarFactory();
	
	public static BerlineCarFactory getinstance(){
		 return instance;
	}
	

	@Override
	public BerlineCar createCar() {
		
		BerlineID++;
		return new BerlineCar(BerlineID);
		
	}

}

}
