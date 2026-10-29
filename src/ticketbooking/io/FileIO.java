package ticketbooking.io;

import java.util.ArrayList;
import java.util.Scanner;

import ticketbooking.model.Customer;
import ticketbooking.model.Event;
import ticketbooking.model.PremiumCustomer;

import java.io.File;
import java.io.FileNotFoundException;

public class FileIO {
	
	
	public static ArrayList<Event> loadEvents(String eventsPath){
		
		ArrayList<Event> events = new ArrayList<Event>();
		try {
			Scanner scanner = new Scanner(new File(eventsPath));
			if (scanner.hasNextLine()) scanner.nextLine(); // For passing headers.
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");
				int eventID  = Integer.parseInt(parts[0]);    // I first use one of constructor with valueOf but I learned Integer(String string) constructor deprecated.
				String eventName= parts[1];
				String category = parts[2];
				int capacity =  Integer.parseInt(parts[3]);
				int ticketPrice = Integer.parseInt(parts[4]);
				events.add(new Event(eventID,eventName,category,capacity,ticketPrice));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not read" + eventsPath + ": " + e.getMessage());
		}
		return events;
	}
	
	
	public static ArrayList<Customer> loadCustomers(String customersPath){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			Scanner scanner = new Scanner(new File(customersPath));
			if (scanner.hasNextLine()) scanner.nextLine(); // For passing headers.
			while(scanner.hasNextLine()) {
				String line =scanner.nextLine();
				String[] parts = line.split(",");
				int customerID = Integer.parseInt(parts[0]);
				String customerName = parts[1];
				int customerBalance = Integer.parseInt(parts[2]);
				if (parts[3].equals("PREMIUM")) {
					customers.add(new PremiumCustomer(customerID,customerName,customerBalance));
				}
				else customers.add(new Customer(customerID,customerName,customerBalance));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not read" + customersPath + ": " + e.getMessage());
		}
		return customers;
	}
	/*
	public static int countDataLines(String filePath) {
		int count = 0;
		
		try {
			Scanner scanner = new Scanner(new File(filePath));
			if(scanner.hasNextLine()) scanner.nextLine(); // For passing headers.
				
			while (scanner.hasNext()) {
				scanner.nextLine();
				count++;
			}
			scanner.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Could not read " + filePath + ": " + e.getMessage());
		}
		return count;
	}
	
	public static Event[] loadEvents(String eventsPath) {
		Event[] events = new Event[countDataLines(eventsPath)];
		int index = 0;
		try {
			Scanner scanner = new Scanner(new File(eventsPath));
			if (scanner.hasNextLine()) scanner.nextLine(); // for passing headers.
			while(scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				
				String[] parts = line.split(",");
				 int eventID  = Integer.parseInt(parts[0]);    // I first use one of constructor with valueOf but I learned Integer(String string) constructor deprecated.
				 String eventName= parts[1];
				 String category = parts[2];
				 int capacity =  Integer.parseInt(parts[3]);
				 int ticketPrice = Integer.parseInt(parts[4]);
				 events[index] = new Event(eventID,eventName,category,capacity,ticketPrice);
				index++;
			}
			scanner.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not read" + eventsPath + ": " + e.getMessage());
		}
		return events;
	}
	
	public static Customer[] loadCustomers(String customersPath) {
		Customer[] customers = new Customer[countDataLines(customersPath)];
		int index = 0;
		try {
			Scanner scanner = new Scanner(new File(customersPath) );
			if (scanner.hasNextLine()) scanner.nextLine(); // for skipping headers
			while (scanner.hasNextLine()) {
				String line =scanner.nextLine();
				String[] parts = line.split(",");
				int customerID = Integer.parseInt(parts[0]);
				String customerName = parts[1];
				int customerBalance = Integer.parseInt(parts[2]);
				String customerType = parts[3];
				if (customerType.equals(PREMIUM)) {
					customers[index] = new PremiumCustomer()
				}
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not read" + customersPath + ": " + e.getMessage());
		}
		return Customer[];
	}
	*/
}
