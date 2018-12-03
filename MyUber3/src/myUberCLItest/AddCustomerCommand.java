package myUberCLItest;

import myUberCustomer.Customer;


/**
 * Création d'un nouveau customer. NB : le customer est directement ajouté à la liste de la classe Customers répertoriant tous les customers de myUber.
 * @author Cuignet & Thiébaud
 *
 *
 */
public class AddCustomer {
	public static void main(String[] args) {
		Customer customer = new Customer(args[0], args[1]);
		MenuCommand.main();
	}

}
