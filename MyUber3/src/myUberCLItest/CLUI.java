package myUberCLItest;

import java.util.Scanner;

import myUberCar.BerlineCar;
import myUberCar.CarFactory;
import myUberCar.StandardCar;
import myUberCar.VanCar;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberTools.Coordinates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class CLUI {
	
	private static boolean quit = false;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to the MyUber user interface system");
		Scanner sc = new Scanner(System.in);
		
		String[] command = new String[2];
		command[0] = "runtest";
		command[1] = "my_uber.ini";
		nextcommand(command);
		
		do {
			
			String s = sc.nextLine();
			command = s.split(" ");
			try {
				nextcommand(command);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				    	
			} while (!quit);
			
				sc.close();
		
	}
		
	public static String nextcommand(String[] command) throws IOException {
		Random rn = new Random();
		
		try {	
			if(command[0].equalsIgnoreCase("setup")) {
				int nbrOfStandardCars = 0;
				int nbrOfBerlineCars = 0;
				int nbrOfVanCars = 0;
				int nbrOfCustomers = 0;
				try {
					nbrOfStandardCars = Integer.parseInt(command[1]);
					nbrOfBerlineCars = Integer.parseInt(command[2]);
					nbrOfVanCars = Integer.parseInt(command[3]);
					nbrOfCustomers = Integer.parseInt(command[4]);
				} catch (NumberFormatException e) {
					System.out.println("ERROR: Wrong format for integers.");
					return("ERROR: Wrong format for integers.");}
				Driver drivers[] = new Driver[nbrOfStandardCars+nbrOfBerlineCars+nbrOfVanCars];
				StandardCar standardCars[] = new StandardCar[nbrOfStandardCars];
				BerlineCar berlineCars[] = new BerlineCar[nbrOfBerlineCars];
				VanCar vanCars[] = new VanCar[nbrOfVanCars];
				Customer customers[] = new Customer[nbrOfCustomers];
				
				for (int i=0; i<nbrOfStandardCars; i++) {
					String name = "driverName"+i;
					String surname = "driverSurname"+i;
					drivers[i] = new Driver(name,surname);
					standardCars[i] = (StandardCar) CarFactory.getInstance().createCar("standard", drivers[i]);
					standardCars[i].setCarPosition(new Coordinates(rn.nextInt(101),rn.nextInt(101)));
				}
				
				for (int i=0; i<nbrOfBerlineCars; i++) {
					//index of the driver
					int j = nbrOfStandardCars+i;
					
					String name = "driverName"+j;
					String surname = "driverSurname"+j;
					drivers[j] = new Driver(name,surname);
					berlineCars[i] = (BerlineCar) CarFactory.getInstance().createCar("berline", drivers[j]);
					berlineCars[i].setCarPosition(new Coordinates(rn.nextInt(101),rn.nextInt(101)));
				}
				
				for (int i=0; i<nbrOfVanCars; i++) {
					//index of the driver
					int j = nbrOfStandardCars+nbrOfBerlineCars+i;
					
					String name = "driverName"+j;
					String surname = "driverSurname"+j;
					drivers[j] = new Driver(name,surname);
					vanCars[i] = (VanCar) CarFactory.getInstance().createCar("van", drivers[j]);
					vanCars[i].setCarPosition(new Coordinates(rn.nextInt(101),rn.nextInt(101)));
				}
				
				for (int i=0; i<nbrOfCustomers; i++) {
					String name = "customerName"+i;
					String surname = "customerSurname"+i;
					customers[i] = new Customer(name,surname);
					customers[i].setCoordinates(new Coordinates(rn.nextInt(101),rn.nextInt(101)));
				}
			}
		}
		
	}

}