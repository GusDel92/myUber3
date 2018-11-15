package myUberStatistics;

import myUberCustomer.Customer;
import myUberCustomer.Customers;

public class CustomerBalance {
	
	public int totalNumberOfRide (Customer customer){
		int n = customer.getTotalNumberOfRides();
		System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has done "+ n+" ride.");
		return(n);
	};
	
	public int totalTimeSpentOnCar (Customer customer){};
	
	public int totalAmountOfCashSpent(Customer customer){};
	
	public Customers mostFrequentCustomer(Customers customers){};
	
	public Customers mostChargedCustomer(Customers customers){};
	
	}
	
	

