package myUberCLItest;

import myUberCustomer.Customer;


/**
 * Cr�ation d'un nouveau customer. NB : le customer est directement ajout� � la liste de la classe Customers r�pertoriant tous les customers de myUber.
 * @author Cuignet & Thi�baud
 *
 *
 */
public class AddCustomer {
	public static void main(String[] args) {
		Customer customer = new Customer(args[0], args[1]);
		MenuCommand.main();
	}

}
