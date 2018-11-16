package myUberStatistics;

import myUberCustomer.Customer;
import java.time.Duration;
import java.time.LocalDateTime;
import myUberCustomer.Customers;

public class CustomerBalance {
	
	public int totalNumberOfRide (Customer customer){
		int n = customer.getTotalNumberOfRides();
		System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has done "+ n+" ride.");
		return(n);
	};
	
	public double totalTimeSpentOnCar (Customer customer){double n = customer.getTotalTimeSpentOnCar();
	System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has spent "+ n+" time on car.");
	return(n);
	};
	
	public int totalAmountOfCashSpent(Customer customer){double n = customer.getTotalAmountOfCashSpent();
	System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has spent "+ n+" time on car.");
	return(n);};
	
	public Customers mostFrequentCustomer(Customers customers){};
	
	public Customers mostChargedCustomer(Customers customers){};
	
	}
	
	

