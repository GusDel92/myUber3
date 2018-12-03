package myUberCLItest;

import java.util.Scanner;

public class MenuCommand {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Exit (Press 0)\nCreate a new myUber universe (Press 1)\nAdd a new customer (Press 2)");
		int command = scan.nextInt();
		
		if (command==0) {System.out.println("Bye");}
		
		else if (command==1) {
			System.out.println("Number of standard cars : ");
			String a = scan.next();
			System.out.println("Number of berline cars : ");
			String b = scan.next();
			System.out.println("Number of van cars : ");
			String c = scan.next();
			System.out.println("Number of customers : ");
			String d = scan.next();
			String newArgs[]={a,b,c,d};
			SetUpCommand.main(newArgs);
		}
		else if (command==2) {
			System.out.println("Name of the new customer : ");
			String a = scan.next();
			System.out.println("Surname of the new customer : ");
			String b = scan.next();
			String newArgs[]={a,b};
			AddCustomerCommand.main(newArgs);
		}
		else {
			System.out.println("\nPlease enter a valid number.\n");
			MenuCommand.main(args);
		}
	}

}
