package myUberCLItest;


import myUberCustomer.Customer;
import myUberCustomer.Customers;

public class MoveCustomerCommand {
	
	public static void main(String[] args){
		
	Boolean done=false;
	for (Customer customer : Customers.getInstance().getCustomersList()) {
		synchronized(customer){
			if (customer.getCustomerID()==Integer.parseInt(args[0])) {
			customer.getCoordinates().setLongitude(Double.parseDouble(args[1]));
			customer.getCoordinates().setLatitude(Double.parseDouble(args[2]));
			done=true;
			}
		}
	} 
	if (done == true){
		for (Customer customer : Customers.getInstance().getCustomersList()) {
			synchronized(customer){
				System.out.println("customerID : "+Integer.toString(customer.getCustomerID())+" --> (Longitude : "+Double.toString(customer.getCoordinates().getLongitude())+", Latitude : "+Double.toString(customer.getCoordinates().getLongitude())+")");
				}
			}
		}
		
	
	else{
		System.out.print("Error: there is no customer with such ID.");
	}
	
	
	
}

}

