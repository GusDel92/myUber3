package myUberCLItest;

import java.util.Scanner;

public class MenuCommand {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Create a new myUber universe (Press 1) \nDo nothing (Press 2)");
		int command = scan.nextInt();
		
		if (command==1) {
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
			MenuCommand.main(args);
		}
		else {System.out.println("There is an error.");}
	}

}
