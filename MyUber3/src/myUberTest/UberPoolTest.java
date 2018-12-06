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
		Driver josé = new Driver("José","Josétito");
		Car car1 = carFactory.createCar("standard", josé);
		josé.connect(car1, "uberPool");
		Customer albert = new Customer("Albert","Bébert");
		Coordinates destination=Coordinates.destinationChoice();
		albert.comparePrices(destination, 10);
		Customer rené = new Customer("René","Renénichou");
		Coordinates destination2=Coordinates.destinationChoice();
		rené.comparePrices(destination2, 4);
		Customer bernard = new Customer("Bernard","Nanard");
		Coordinates destination3=Coordinates.destinationChoice();
		bernard.comparePrices(destination3, 17);
		albert.selectRide("uberBlack");
		rené.selectRide("uberX");
		bernard.selectRide("uberX"); 
	}

}

