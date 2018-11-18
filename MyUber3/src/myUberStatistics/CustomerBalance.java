package myUberStatistics;

import myUberCustomer.Customer;
import java.time.Duration;
import java.time.LocalDateTime;
import myUberCustomer.Customers;

public class CustomerBalance {
	
	public int totalNumberOfRide (Customer customer){
		int n = customer.getTotalNumberOfRides();
		System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has done "+n+" ride.");
		return(n);
	};
	
	public Duration totalTimeSpentOnCar (Customer customer){
		Duration t = customer.getTotalTimeSpentOnCar();
		System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has spent "+ t+" time on car.");
		return(t);
	};
	
	public double totalAmountOfCashSpent(Customer customer){
		double c = customer.getTotalAmountOfCashSpent();
		System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has spent "+ n+" euros in Uber.");
		return(c);
		};
	
	public Customers mostFrequentCustomer(Customers customers){};
	
	public Customers mostChargedCustomer(Customers customers){};
	
	}
	
	

