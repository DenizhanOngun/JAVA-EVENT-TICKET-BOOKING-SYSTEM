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
		events = null;
		customers = null;
		bookings = null;
	}
	
	public void reservation() {
		System.out.println("Make Reservation");
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
