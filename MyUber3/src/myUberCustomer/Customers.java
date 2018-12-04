package myUberCustomer;

import java.util.ArrayList;

/**
 * This class' only instance stores all the created customers. Whenever one wants to create a new customer, one must create it with this Users object as attribute, and this automatically adds this new user to the usersList of this Users object. To make sure this class is only instantiated once, the singleton pattern is used here.
 * @author Cuignet & Thiébaud
 *
 */
public class Customers {

	private ArrayList<Customer> customersList = new ArrayList<Customer>();
	
	private static Customers instance = new Customers();
	
	public static Customers getInstance(){
			
			return instance;
	}
	
	/**
	 * This method adds a customer to the list of created customers
	 * @param customer
	 * @author Cuignet & Thiébaud
	 */
	public void addCustomer(Customer customer) {
			
			Customers.getInstance().customersList.add(customer);
			
	}

	public ArrayList<Customer> getCustomersList() {
		return customersList;
	}

	public void setUsersList(ArrayList<Customer> customersList) {
		Customers.getInstance().customersList = customersList;
	}

	public static void setInstance(Customers instance) {
		Customers.instance = instance;
	}
}
