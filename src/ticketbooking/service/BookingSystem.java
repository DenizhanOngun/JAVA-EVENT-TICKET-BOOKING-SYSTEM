package ticketbooking.service;

import java.util.ArrayList;

import ticketbooking.model.Booking;
import ticketbooking.model.Customer;
import ticketbooking.model.Event;

public class BookingSystem {
	enum Policy {
		BOOKING_LIMIT,
		GROUP_DISCOUNT,
		CATEGORY_RESTRICTION,
		CANCELLATION_FEE,
		RESERVED_CAPACITY
	}
	enum PolicyStatus{
		DISABLED,
		ENABLED
	}
	private Policy policy;
	private PolicyStatus status;
	private ArrayList<Event> events;
	private ArrayList<Customer> customers;
	private ArrayList<Booking> bookings;
	private int G;
	
	public BookingSystem() {
		this.events = new ArrayList<Event>();
		this.customers = new ArrayList<Customer>();
		this.bookings = new ArrayList<Booking>();
		this.status = PolicyStatus.DISABLED;
		this.G = 0; // Dön buraya 
	}
	
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	
	public void addEvents(ArrayList<Event> events) {
		for(Event event : events) {
			this.events.add(event); // I know this is shadow copy but File IO doesn't need and we never use again that
		}
	}
	
	
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	
	public void addCusomers(ArrayList<Customer> customers ) {
		for(Customer customer :customers ) {
			this.customers.add(customer);
		}
	}
	
	
		
	
	
	public void cancellation(Booking booking) {
		System.out.println("Make Cancellation");
	} 
	
	
	public int getSeats() {
		return  42;
	}
	
	
	public void getBookingPolicies() {
		System.out.println("Getting Booking Policies.");
	}
	public boolean canAfforBookingPolicy(int ticketAmount){
		return ticketAmount <= (2 + (G%3));
		
	}
	public boolean isBookingLegal(Customer customer, Event event, int ticketAmount, double paidAmount) {
		if (customer.canAfford(paidAmount) &&
			event.canReserveSeats(ticketAmount)&&
			this.canAfforBookingPolicy(ticketAmount)
			  ) return true;
		
		else return false;	
	}
	
	
	public void reservation(Customer customer, Event event, int ticketAmount) {
		
		double paidAmount = Booking.calculatePaidAmount(event, customer);
		try {
			customer.pay(paidAmount);
			this.bookings.add(new Booking(customer.getCustomerName(), customer.getCustomerID(), event.getEventName(), event.getTicketPrice(), paidAmount));
		}
		catch(IllegalArgumentException e) {
			
		}
		
		if (this.isBookingLegal(customer, event, ticketAmount, paidAmount)) {
			this.bookings.add(new Booking(customer.getCustomerName(), customer.getCustomerID(), event.getEventName(), event.getTicketPrice(), paidAmount));
		}
		
	}
}
