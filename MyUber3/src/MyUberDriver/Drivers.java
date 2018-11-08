package myUberDriver;

import java.util.Scanner;

public class Drivers {
	
	public void addDriver(int id) {
		//ajout d'un nouveau driver à la base de donnée, avec id unique; comment?
	}
	
	public void getDriverInfo(Driver driver) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your name?");
		driver.setName(scan.nextLine());
		System.out.println("What is your surname?");
		driver.setSurname(scan.nextLine());
		scan.close();
	}
}
