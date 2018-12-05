package myUberTest;

import org.junit.Test;

import myUberDriver.Driver;
import myUberDriver.Drivers;

public class DriverTest {
	
	@Test
	public void driverTest(){
		Driver driver = new Driver("Fabrice", "Dubeaujolais");
		System.out.println(driver.getState()+driver.getDriverID()+driver.getRate());
	}
	
	@Test
	public void driversTest(){
		Drivers drivers = Drivers.getInstance();
		Drivers.addDriver(new Driver("Fabrice", "Dubeaujolais"));
		System.out.println(drivers.getDriversList());
		
	}

}
