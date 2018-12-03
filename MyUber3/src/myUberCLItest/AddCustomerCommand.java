package myUberCLItest;

import myUberCustomer.Customer;
import myUberCustomer.Customers;


/**
 * Cr�ation d'un nouveau customer. NB : le customer est directement ajout� � la liste de la classe Customers r�pertoriant tous les customers de myUber.
 * @author Cuignet & Thi�baud
 *
 *
 */
public class AddCustomerCommand {
	public static void main(String[] args) throws InterruptedException {
		Customer newCustomer = new Customer(args[0], args[1]);
		for (Customer customer : Customers.getInstance().getCustomersList()) {
			System.out.println("CustomerID, Name, Surname, Number of Rides, Total Cash Spent");
			System.out.println(customer.getCustomerID() + ", "+customer.getName()+", "+customer.getSurname()+", "+customer.getTotalNumberOfRides()+", "+customer.getTotalAmountOfCashSpent() + "\n");
		}
		
		MenuCommand.main(args);
	}

}
