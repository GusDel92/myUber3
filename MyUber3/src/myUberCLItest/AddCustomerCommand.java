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
	public static void main(String[] args) {
		Customer customer = new Customer(args[0], args[1]);
		for ()
		System.out.println(Customers.getInstance().getCustomersList().get(0).getName());
		MenuCommand.main(args);
	}

}
