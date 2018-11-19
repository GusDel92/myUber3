package myUberStatistics;

import myUberCustomer.Customer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import myUberCustomer.Customers;
import myUberDriver.Driver;
import myUberDriver.Drivers;

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
	
	public static ArrayList<Customer> mostChargedCustomer(){
		ArrayList <Customer> customersList = Customers.getInstance().getCustomersList();
		int n = customersList.size();
		for (int i=0;i<=n;i++) {
			for (int j=1;j<=n-1;j++) {
				Customer customer1 = customersList.get(j);
				Customer customer2 = customersList.get(j+1);
				if (totalAmountOfCashSpent(customer1)<totalAmountOfCashSpent(customer2)){
					customersList.remove(j);
					customersList.add(j+1, customer1);
			}
		}
	}
	return customersList;
};
	
	public static ArrayList<Customer> mostFrequentCustomer(){
		ArrayList <Customer> customersList = Customers.getInstance().getCustomersList();
		int n = customersList.size();
		for (int i=0;i<=n;i++) {
			for (int j=1;j<=n-1;j++) {
				Customer customer1 = customersList.get(j);
				Customer customer2 = customersList.get(j+1);
				if (customer1.getTotalNumberOfRides()<customer2.getTotalNumberOfRides()){
					customersList.remove(j);
					customersList.add(j+1, customer1);
			}
		}
	}
	return customersList;};
	
	}
	
	

