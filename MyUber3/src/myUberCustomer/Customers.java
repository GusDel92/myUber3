package myUberCustomer;

import java.util.ArrayList;

public class Customers {

	public Customers() {
		// TODO Auto-generated constructor stub
	}

private ArrayList<Customer> customersList = new ArrayList<Customer>();
	
	private static Customers instance = new Customers();
	
	public static Customers getInstance(){
			
			return instance;
	}
	
	/**
	 * This method adds a user to the list of created users
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
			
			this.customersList.add(customer);
			
	}

	public ArrayList<Customer> getCustomersList() {
		return customersList;
	}

	public void setUsersList(ArrayList<Customer> customersList) {
		this.customersList = customersList;
	}

	public static void setInstance(Customers instance) {
		Customers.instance = instance;
	}
}
