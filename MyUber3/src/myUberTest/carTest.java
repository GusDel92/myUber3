package myUberTest;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberDriver.Driver;

import org.junit.Test;

public class carTest {
	
	@Test
	public void carAndFactoryTest(){
		
		CarFactory factory = CarFactory.getInstance();
		Car car0 = factory.createCar("berline", new Driver("josé", "bové"));
		Car car1 = factory.createCar("van", new Driver("josé", "bové"));
		Car car2 = factory.createCar("standard", new Driver("josé", "bové"));
		System.out.println("car0 : " + car0.getCarID()+" ; car1 : "+ car1.getType()+" ; car2 : "+ car2.getCurrentDriver().getName());
		
	}

}
