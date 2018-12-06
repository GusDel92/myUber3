package myUberTest;

import org.junit.Test;
import myUberTools.*;
import myUberCar.*;
import myUberCustomer.*;
import myUberDriver.*;

public class UberPoolTest {

	@Test
	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		Driver jos� = new Driver("Jos�","Jos�tito");
		Car car1 = carFactory.createCar("standard", jos�);
		jos�.connect(car1, "uberPool");
		Customer albert = new Customer("Albert","B�bert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination, 10);
		Customer ren� = new Customer("Ren�","Ren�nichou");
		Coordinates destination2=Coordinates.destinationChoice();
		ren�.comparePrices(destination2, 4);
		Customer bernard = new Customer("Bernard","Nanard");
		Coordinates destination3=Coordinates.destinationChoice();
		bernard.comparePrices(destination3, 17);
		albert.selectRide("uberBlack");
		ren�.selectRide("uberX");
		bernard.selectRide("uberX"); 
	}

}

