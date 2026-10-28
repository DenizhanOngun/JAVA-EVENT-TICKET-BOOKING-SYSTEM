package ticketbooking.service;

import java.util.ArrayList;

import ticketbooking.model.Booking;
import ticketbooking.model.Customer;
import ticketbooking.model.Event;

public class BookingSystem {
	
	private ArrayList<Event> events;
	private ArrayList<Customer> customers;
	private ArrayList<Booking> bookings;
	
	public BookingSystem() {
		events = new ArrayList<Event>();
		customers = new ArrayList<Customer>();
		bookings = new ArrayList<Booking>();
	}
	
	public void addEvent(Event event) {
		this.events.add(event);
		
	}
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public void reservation(Booking booking) {
		this.bookings.add(booking);
	}	
	
	public void cancellation() {
		System.out.println("Make Cancellation");
	} 
	
	public int getSeats() {
		return  42;
	}
	public void getBookingPolicies() {
		System.out.println("Getting Booking Policies.");
	}
}
