package myUberStatistics;

import myUberCustomer.Customer;
import java.time.Duration;
import java.util.Collections;
import myUberCustomer.Customers;



/**
 * Customer balance is a class that provides a set of computing relevant statistic methods on customers. 
 *@author Cuignet & Thiébaud
 */
public class CustomerBalance {
	
	public static int totalNumberOfRides (Customer customer){
		int n = customer.getTotalNumberOfRides();
		System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has done "+n+" ride.");
		return(n);
	};
	
	public static Duration totalTimeSpentOnCar (Customer customer){
		Duration t = customer.getTotalTimeSpentOnCar();
		System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has spent "+ t+" time on car.");
		return(t);
	};
	
	public static double totalAmountOfCashSpent(Customer customer){
		double c = customer.getTotalAmountOfCashSpent();
		System.out.println("The customer "+ customer.getName()+" "+customer.getSurname()+" whoes ID is "+customer.getCustomerID()+" has spent "+ c+" euros in Uber.");
		return(c);
		};
	
	

	/**
	 * This sorting method uses the Collections class, and the comparators instantiated in the driver class.
	 */
	public static void mostChargedCustomer(){
		Collections.sort(Customers.getInstance().getCustomersList(), Customer.TotalAmountOfCashComparator);
		System.out.println("\nCustomerID, Name, Surname, Number of Rides, Total Cash Spent");
		for (Customer customer : Customers.getInstance().getCustomersList()) {
					System.out.println(customer.getCustomerID() + ", "+customer.getName()+", "+customer.getSurname()+", "+customer.getTotalNumberOfRides()+", "+customer.getTotalAmountOfCashSpent());
	}

}



	/**
	 * This sorting method uses the Collections class, and the comparators instantiated in the driver class.
	 */
	public static void mostFrequentCustomer(){
		Collections.sort(Customers.getInstance().getCustomersList(), Customer.TotalNumberOfRidesComparator);
		System.out.println("\nCustomerID, Name, Surname, Number of Rides, Total Cash Spent");
		for (Customer customer : Customers.getInstance().getCustomersList()) {
			System.out.println(customer.getCustomerID() + ", "+customer.getName()+", "+customer.getSurname()+", "+customer.getTotalNumberOfRides()+", "+customer.getTotalAmountOfCashSpent());
		}
	
	}
	
}
	
	

