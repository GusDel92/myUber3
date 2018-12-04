package myUberCLItest;

import myUberCustomer.Customer;
import myUberCustomer.Customers;
import myUberTools.Coordinates;

public class SimRideCommand {

	public static void main(String[] args) {
		
		int customerID=Integer.parseInt(args[0]);
		Customer customerOfTheRide = null;
		
		String[] destination=args[1].split(",");

		Coordinates dest = new Coordinates(Integer.parseInt(destination[0]),Integer.parseInt(destination[1]));
		
		int time=Integer.parseInt(args[2]);
		
		String typeOfTheRide=args[3];
		
		int mark=Integer.parseInt(args[4]);
		
		boolean done=false;
		for (Customer customer : Customers.getInstance().getCustomersList()) {
			synchronized(customer){
				if (customer.getCustomerID()==customerID) {	
					customerOfTheRide=customer;
					customerOfTheRide.comparePrices(dest,time);
					done=true;
					//Selecting the ride
					customerOfTheRide.selectRide(typeOfTheRide);
					//Giving the mark
					
				}
			}
		}
		
		if (done==false){
			System.out.print("Error: there is no customer with such ID.");
		}
		
		
		
	}

}
