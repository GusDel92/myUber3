package myUberTest;

import myUberCustomer.Customer;
import myUberCustomer.Customers;

import org.junit.Test;

public class CustomerTest {
	
	@Test
	public void customerTest(){
		Customer jean = new Customer("Jean", "Dujardin");
		Customers.getInstance().addCustomer(jean);
		System.out.println("Liste des customers : ");
		System.out.println(Customers.getInstance().getCustomersList());
		System.out.println("ID : " + jean.getCustomerID());
		System.out.println("tot number of rides : " + jean.getTotalNumberOfRides());
		
		
	}
	

}
