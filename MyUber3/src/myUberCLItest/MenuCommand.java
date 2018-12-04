package myUberCLItest;

import java.util.Scanner;

public class MenuCommand {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("\nMENU\n\nExit (Press 0)\nCreate a new myUber universe (Press 1)\nAdd a new customer (Press 2)\nAdd a new car and associate it with a new driver (Press 3)\nAdd a new driver (Press 4)\nSet the status of a driver (Press 5)\nMove a car (Press 6)\nMove a customer (Press 7)\nDisplay the information of the system (Press 8)\nAsk for the price of a ride (Press 9)\nSimulate totally a ride (Press 10)\nSimulate a ride interactively (Press 11)\nDisplay drivers information (Press 12)\nDisplay customers information (Press 13)");
		int command = scan.nextInt();
		
		if (command==0) {System.out.println("Bye");System.exit(0);}
		
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
			System.out.println("Name of the new customer: ");
			String a = scan.next();
			System.out.println("Surname of the new customer: ");
			String b = scan.next();
			String newArgs[]={a,b};
			AddCustomerCommand.main(newArgs);
		}
		else if (command==3) {
			System.out.println("Name of the new driver: ");
			String a = scan.next();
			System.out.println("Surname of the new driver: ");
			String b = scan.next();
			System.out.println("Type of the new car (standard, berline, van): ");
			String c = scan.next();
			String newArgs[]={a,b,c};
			AddCarDriverCommand.main(newArgs);
		}
		else if (command==4) {
			System.out.println("Name of the new driver: ");
			String a = scan.next();
			System.out.println("Surname of the new driver: ");
			String b = scan.next();
			System.out.println("Car ID: ");
			String c = scan.next();
			String newArgs[]={a,b,c};
			AddDriverCommand.main(newArgs);
		}
		else if (command==5) {
			System.out.println("ID of the driver: ");
			String a = scan.next();
			System.out.println("New state of the driver: ");
			String b = scan.next();
			String newArgs[]={a,b};
			SetDriverStatusCommand.main(newArgs);
		}
		
		else if (command==6) {
			System.out.println("ID of the car: ");
			String a = scan.next();
			System.out.println("New latitude: ");
			String b = scan.next();
			System.out.println("New longitude: ");
			String c = scan.next();
			String newArgs[]={a,b};
			MoveCarCommand.main(newArgs);
		}
		else if (command==7) {
			System.out.println("ID of the customer: ");
			String a = scan.next();
			System.out.println("New latitude: ");
			String b = scan.next();
			System.out.println("New longitude: ");
			String c = scan.next();
			String newArgs[]={a,b};
			MoveCarCommand.main(newArgs);
		}
		
		else if (command==8) {
			DisplayStateCommand.main(args);
		}
		
		else if (command==9) {
			String[] newArgs = {"1","1;3","25","uberX","3"};
			SimRideCommand.main(newArgs);
		}
		else {
			System.out.println("\nPlease enter a valid number.\n");
			MenuCommand.main(args);
		}
	}
}
