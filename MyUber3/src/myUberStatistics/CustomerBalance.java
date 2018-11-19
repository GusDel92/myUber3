package myUberStatistics;

import myUberCustomer.Customer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import myUberCustomer.Customers;
import myUberDriver.Driver;
import myUberDriver.Drivers;

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
	
	public ArrayList<Customer> mostChargedCustomer(){
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
	
	public ArrayList<Customer> mostFrequentCustomer(){
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
	
	

