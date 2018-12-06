package myUberCLItest;

import java.util.Scanner;

import myUberCar.BerlineCar;
import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCar.StandardCar;
import myUberCar.VanCar;
import myUberCustomer.Customer;
import myUberCustomer.Customers;
import myUberDriver.Driver;
import myUberDriver.Drivers;
import myUberRide.Ride;
import myUberStatistics.CustomerBalance;
import myUberStatistics.DriverBalance;
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
		command[0] = "init";
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
					System.out.println("ERROR: Wrong format for a number. Please enter integers.");
					return("ERROR: Wrong format for a number. Please enter integers.");}
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
				
				System.out.println("setup done");
				return("Setup done with "+nbrOfStandardCars+" standard cars, "+nbrOfBerlineCars+" berlines, "+nbrOfVanCars+" vans, "+nbrOfCustomers+" customers.");
			}
			
			else if(command[0].equalsIgnoreCase( "addCustomer" ) ) {
				String name = command[1];
				String surname = command[2];
				Customer newCustomer = new Customer(command[1], command[2]);
				System.out.println(name +" "+ surname +" has been added to the customers.");
				
				System.out.println("\nCustomerID, Name, Surname, Number of Rides, Total Cash Spent");
				for (Customer customer : Customers.getInstance().getCustomersList()) {
					System.out.println(customer.getCustomerID() + ", "+customer.getName()+", "+customer.getSurname()+", "+customer.getTotalNumberOfRides()+", "+customer.getTotalAmountOfCashSpent());
				}
				return(name +" "+ surname +" has been added.");
			}
			
			else if(command[0].equalsIgnoreCase( "addCarDriver" ) ) {
				String name = command[1]; String surname = command[2]; String type = command[3];
				if (!CarFactory.getInstance().getPossibleCarTypes().contains(type)) {
					System.out.println("The type of car "+type+" doesn't exist.\nExisting types are: ");
					for (String existingType : CarFactory.getInstance().getPossibleCarTypes()) {System.out.print(existingType+", ");};
					return("The type of car "+type+" doesn't exist.\nExisting types are: ");
				}
				else{
					Driver newDriver = new Driver(name, surname);
					CarFactory.getInstance().createCar(type, newDriver);
					System.out.println(name+" "+surname+" has been added and associated to the new "+type+" car.");
					
					System.out.println("\nCarID, Owners");
					for (Car car : CarFactory.getInstance().getAllCars()) {
						System.out.println(car.getCarID()+", "+car.getOwnersList().get(0).getName());
					}
					
					System.out.println("\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed");
					for (Driver driver : Drivers.getInstance().getDriversList()) {
						System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed());
					}
				
					return(name+" "+surname+" has been added and associated to the new "+type+" car.");
				}
			}
			
			else if(command[0].equalsIgnoreCase( "addDriver" ) ) {
				String name = command[1]; String surname = command[2]; String carID = command[3];
				for (Car existingCar : CarFactory.getInstance().getAllCars()) {
					if (existingCar.getCarID().equals(carID)) {
						Driver newDriver = new Driver(name, surname);
						existingCar.addOwner(newDriver);
						System.out.println(name+" "+surname+" has been added and associated to car "+carID+".");
						System.out.println("\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed");
						for (Driver driver : Drivers.getInstance().getDriversList()) {
							System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed());}
					return(name+" "+surname+" has been added and associated to car "+carID+".");
					}
				}
				System.out.println("The ID "+carID+" does not belong to any car.");
				return("The ID "+carID+" does not belong to any car.");
				}
				
			else if(command[0].equalsIgnoreCase( "setDriverStatus" ) ) {
				try {

					int driverID = Integer.parseInt(command[1]); String newState = command[2];
					for (Driver driver : Drivers.getInstance().getDriversList()) {
						synchronized(driver.getState()){
							if (driver.getDriverID()==driverID) {
								if(driver.setState(newState)) {
									System.out.println(driver.getName()+" "+driver.getSurname()+" is "+driver.getState()+".");
									return(driver.getName()+" "+driver.getSurname()+" is "+driver.getState()+".");
								}
							}
						}
					}
					System.out.print("Error: there is no driver with such ID.");
					return("Error: there is no driver with such ID.");
				} 
				catch (NumberFormatException e) {
					System.out.println("ERROR: Wrong format of the driverID. Please enter integers.");
					return("ERROR: Wrong format of the driverID. Please enter integers.");
				}
			}
			
			else if(command[0].equalsIgnoreCase( "moveCar" )) {
				
				try {
					String carID  = command[1]; int newX = Integer.parseInt(command[2]) ; int newY = Integer.parseInt(command[3]);
					boolean done=false;
					for (Car car : CarFactory.getInstance().getAllCars()) {
						synchronized(car){
							if (car.getCarID()==carID) {
							car.getCarPosition().setLongitude(newX);
							car.getCarPosition().setLatitude(newY);
							done=true;
							}
						}
						System.out.println("carID : "+car.getCarID()+" --> (Longitude : "+car.getCarPosition().getLongitude()+", Latitude : "+car.getCarPosition().getLongitude()+")");			
					}
						
					
					if (done==false){
						System.out.print("Error: there is no car with such ID.");
						return("Error: there is no car with such ID.");
					}
					else {System.out.println("The car "+carID+" has been moved to "+newX+", "+newY);
						return("The car "+carID+" has been moved to "+newX+", "+newY);}
				} 
				catch (NumberFormatException e) {
					System.out.println("ERROR: Wrong format of a parameter. Please enter integers.");
					return("ERROR: Wrong format of a parameter. Please enter integers.");
				}
			}
			
			else if(command[0].equalsIgnoreCase( "moveCustomer" )) {
				try {
					int customerID  = Integer.parseInt(command[1]); int newX = Integer.parseInt(command[2]) ; int newY = Integer.parseInt(command[3]);
					boolean done=false;
					for (Customer customer : Customers.getInstance().getCustomersList()) {
						synchronized(customer){
							if (customer.getCustomerID()==customerID) {
							customer.getCoordinates().setLongitude(newX);
							customer.getCoordinates().setLatitude(newY);
							done=true;
							}
						}
						System.out.print("\ncustomerID : "+customer.getCustomerID()+" --> (Longitude : "+customer.getCoordinates().getLongitude()+", Latitude : "+customer.getCoordinates().getLatitude()+")");			
					}
						
					
					if (done==false){
						System.out.print("Error: there is no customer with such ID.");
						return("Error: there is no customer with such ID.");
					}
					else {System.out.println("\nThe customer "+customerID+" has been moved to "+newX+", "+newY);
						return("\nThe customer "+customerID+" has been moved to "+newX+", "+newY);}
				} catch (NumberFormatException e) {
					System.out.println("ERROR: Wrong format of a parameter. Please enter integers.");
					return("ERROR: Wrong format of a parameter. Please enter integers.");
				}
			}
		
			else if(command[0].equalsIgnoreCase( "displayState" )) {
				//General Information
				System.out.println("\nInfo of the system:\nNumber of Customers: "+Customers.getInstance().getCustomersList().size()+"\nNumber of Drivers: "+Drivers.getInstance().getDriversList().size()+"\nNumber of Cars: "+CarFactory.getInstance().getAllCars().size());
				//Customers Information
				System.out.println("\nCustomerID, Name, Surname, Number of Rides, Total Cash Spent");
				for (Customer customer : Customers.getInstance().getCustomersList()) {
					System.out.println(customer.getCustomerID() + ", "+customer.getName()+", "+customer.getSurname()+", "+customer.getTotalNumberOfRides()+", "+customer.getTotalAmountOfCashSpent());
				}
				//Drivers Information
				System.out.println("\nDriverID, Name, Surname, Number of Rides, Total Amount Cashed");
				for (Driver driver : Drivers.getInstance().getDriversList()) {
					System.out.println(driver.getDriverID() + ", "+driver.getName()+", "+driver.getSurname()+", "+driver.getTotalNumberOfRides()+", "+driver.getTotalAmountCashed());
				}
				//Cars Information
				System.out.println("\nCarID, Owners");
				for (Car car : CarFactory.getInstance().getAllCars()) {
					String owners = "";
					for(Driver owner : car.getOwnersList()) {
						owners=owners+owner.getName()+" "+owner.getSurname()+". ";
					}	
					System.out.println(car.getCarID()+": "+owners);	
				}
				return("The information of the system has been printed.");
			}
			
			else if(command[0].equalsIgnoreCase( "ask4price" )) {
				try {
					int customerID  = Integer.parseInt(command[1]);
					Customer customerOfTheRide = null;
					String[] destination=command[2].split(";");
					Coordinates dest = new Coordinates(Integer.parseInt(destination[0]),Integer.parseInt(destination[1]));
					int time=Integer.parseInt(command[3]);
					
					boolean done = false;
					for (Customer customer : Customers.getInstance().getCustomersList()) {
						synchronized(customer){
							if (customer.getCustomerID()==customerID) {	
								customerOfTheRide=customer;
								String prices = customerOfTheRide.comparePrices(dest,time);
								done = true;
								return prices;
							}
						}
					}
					System.out.println("ERROR: There is no customer with such ID: "+customerID+".");
					return("ERROR: There is no customer with such ID: "+customerID+".");
					
				} catch (NumberFormatException e) {
					System.out.println("ERROR: Wrong format for a parameter. Please enter integers for ID and time, and X;Y where X and Y are integers for destination.");
					return("ERROR: Wrong format for a parameter. Please enter integers for ID and time, and X;Y where X and Y are integers for destination.");
				}
			}
			
			else if (command[0].equalsIgnoreCase("simRide")) {
				try {
					int customerID=Integer.parseInt(command[1]);
					
					String[] destination=command[2].split(";");
					Coordinates dest = new Coordinates(Integer.parseInt(destination[0]),Integer.parseInt(destination[1]));
					int time=Integer.parseInt(command[3]);
					String typeOfTheRide=command[4];
					int mark=Integer.parseInt(command[5]);
					
					boolean done=false;
					for (Customer customer : Customers.getInstance().getCustomersList()) {
						synchronized(customer){
							if (customer.getCustomerID()==customerID) {	
								customer.comparePrices(dest,time);
								//Selecting the ride
								Ride selectedRide = customer.selectRide(typeOfTheRide);
								if(selectedRide.getStatus()=="confirmed") {
									//Giving the mark
									selectedRide.setRate(mark);
									selectedRide.getDriver().computeNewRate(selectedRide);
									done=true;
									System.out.println("The ride has been run.");
									return("The ride has been run.");
								}
							System.out.println("There is no available driver for your ride. Please try again.");
							return("There is no available driver for your ride.");
							}
						}
					}
					if (done==false){
						System.out.print("Error: there is no customer with such ID.");
						return("Error: there is no customer with such ID.");
					}
				} catch (NumberFormatException e) {
					System.out.println("ERROR: Wrong format for a parameter. Please enter integers for ID, time and mark, and X;Y where X and Y are integers for destination.");
					return("ERROR: Wrong format for a parameter.");
				}
			}
			
			else if (command[0].equalsIgnoreCase("simRide_i")) {
				try {
					int customerID=Integer.parseInt(command[1]);
					
					String[] destination=command[2].split(";");
					Coordinates dest = new Coordinates(Integer.parseInt(destination[0]),Integer.parseInt(destination[1]));
					int time=Integer.parseInt(command[3]);
					
					boolean done=false;
					for (Customer customer : Customers.getInstance().getCustomersList()) {
						synchronized(customer){
							if (customer.getCustomerID()==customerID) {	
								customer.comparePrices(dest,time);
								//Selecting the ride
								Scanner scan = new Scanner(System.in);
								System.out.println("What type of ride do you want?");
								String typeOfTheRide = scan.next();
								Ride selectedRide = customer.selectRide(typeOfTheRide);
								//Giving the mark
								selectedRide.setRate(customer.giveARate(selectedRide));
								selectedRide.getDriver().computeNewRate(selectedRide);
								done=true;
								return("The ride has been run.");
							}
						}
					}
					
					if (done==false){
						System.out.print("Error: there is no customer with such ID.");
						return("Error: there is no customer with such ID.");
					}
				} catch (NumberFormatException e) {
					System.out.println("ERROR: Wrong format for a parameter. Please enter integers for ID, time and mark, and X;Y where X and Y are integers for destination.");
					return("ERROR: Wrong format for a parameter.");
				}
			}
			
			else if (command[0].equalsIgnoreCase("displayDrivers")) {
				try {
					String sortPolicy = command[1];
					if (sortPolicy.equals("mostappreciated")){
						System.out.println(DriverBalance.mostAppreciatedDriver());
						return(DriverBalance.mostAppreciatedDriver());}
					else if (sortPolicy.equals("mostoccupied")){
						System.out.println(DriverBalance.leastOccupiedDriver());
						return(DriverBalance.leastOccupiedDriver());}
					else {System.out.println("Wrong parameter. Try 'mostappreciated' or 'mostoccupied'");}} 
				catch (Exception e) {
					System.out.println("Failed to display driver command.");
				}
			}
			
			else if (command[0].equalsIgnoreCase("displayCustomers")) {
				try {
					String sortPolicy = command[1];
					if (sortPolicy == "mostfrequent"){
						System.out.println(CustomerBalance.mostFrequentCustomer());
						return(CustomerBalance.mostFrequentCustomer());}
					else if (sortPolicy == "mostcharged"){
						System.out.println(CustomerBalance.mostChargedCustomer());
						return(CustomerBalance.mostChargedCustomer());}
					else {System.out.println("Wrong parameter. Try 'mostfrequent' or 'mostchargeded'");}
				} catch (Exception e) {
					System.out.println("There has been a problem. Please try again.");
				}
			}
			
			else if (command[0].equalsIgnoreCase("setActualDriver")) {
				int driverID = Integer.parseInt(command[1]); String carID = command[2] ; String desiredTypeOfRide = command[3];
				for(Car existingCar : CarFactory.getInstance().getAllCars()) {
					if(existingCar.getCarID().equals(carID)) {
						for(Driver owner : existingCar.getOwnersList()) {
							if(owner.getDriverID()==driverID) {
								if (existingCar.setCurrentDriver(owner) & existingCar.setActualTypeOfRideDesiredByDriver(desiredTypeOfRide)) {
									System.out.println(owner.getName()+" "+owner.getSurname()+" is "+owner.getState()+", riding the car "+existingCar.getCarID()+" with rides of type "+existingCar.getActualTypeOfRideDesiredByDriver()+".");
									return(owner.getName()+" "+owner.getSurname()+" is riding the car "+existingCar.getCarID()+" with rides of type "+existingCar.getActualTypeOfRideDesiredByDriver()+".");
								}
								else {System.out.println("That car cannot perform "+desiredTypeOfRide+ " rides."); return("That car cannot perform "+desiredTypeOfRide+ " rides.");} 
							}
						}
						System.out.println("The driver "+driverID+" does not own the car "+carID+", or the car is already being driven.");
						return("The driver "+driverID+" does not own the car "+carID+".");
					}
				}
				System.out.print("ERROR: There is no car with ID "+carID+".");
				return("ERROR: There is no car with ID "+carID+".");
			}
			
	    	else if (command[0].equalsIgnoreCase("exit")){
	    		
	    		quit = true;
	    		System.out.println("See you next time!");
	    		return("See you next time");
	    		
	    	}
	    	
	    	else if (command[0].equalsIgnoreCase("init")) { 
	    		try {
					String file = command[1];
					ArrayList<String[]> commands = new ArrayList<String[]>();
					ArrayList<String> answers = new ArrayList<String>();
					InputStream fis = new FileInputStream("eval/"+file);
					@SuppressWarnings("resource")
					Scanner sc = new Scanner(fis);
					String s = sc.nextLine();
					String r;
					String[] commandline;
					while(!s.equals("") & sc.hasNextLine()){
						
						commandline = s.split(" ");
						commands.add(commandline);
						s = sc.nextLine();
						
						}

					for (String[] command1 : commands) {
						
						r = nextcommand(command1);
						answers.add(r);
					}
					
					if (!file.equalsIgnoreCase("my_uber.ini")) {	
						PrintWriter writer = new PrintWriter("eval/" + file + "output.txt", "UTF-8");
						
						for (String answer : answers) {
							
							writer.println(answer);
							
						}
						
						writer.close();
						}	
					
					System.out.println("Completed");
					return("Completed");
				} catch (FileNotFoundException e) {
					System.out.print("The init file has not been found.");
				}
	    		
	    		
	    	}
	    	
	    	else {
	    		
	    		System.out.println("Error in the last command, please try again.");
	    		return("Error in the last command, please try again.");
	    		
	    	}
    	
		}	//fin du try
		
	    catch( Exception e ) {
		    System.out.println( "Unknown error in your command's parameters." );
		    e.printStackTrace();
		    return( "Unknown error in your command's parameters." );
		}
		return null;
	}

}

