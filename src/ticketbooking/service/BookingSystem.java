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
		this.G = 11; // Dön buraya 
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
		if (PolicyStatus.ENABLED.equals(status) && !(ticketAmount <= (2 + (G%3))))	
			throw new IllegalArgumentException("Denied by Booking Limit");
		else
		return true;
		
	}
	public boolean isBookingLegal(Customer customer, Event event, int ticketAmount, double paidAmount) {
		if (customer.canAfford(paidAmount) &&
			event.canReserveSeats(ticketAmount)&&
			this.canAfforBookingPolicy(ticketAmount)
			  ) return true;
		
		else
			return false;	
	}
	
	public boolean isCancellationLegal(int bookingID) {
		Booking booking = this.findBooking(bookingID);
		Event event = this.findEvent(booking.getEventID());
		if (booking.canCancell() && event.canReleaseSeats(booking.getTicketAmount()))
				return true;
		else
			return false;
	}
	public Booking findBooking(int bookingID) {
		for (Booking booking: bookings) {
			if (booking.getBookingID() == bookingID)
				return booking;
		}
		throw new IllegalArgumentException("Booking Not Found");
	}
	
	public Customer findCustomer(int customerID) {
		for(Customer customer : customers) {
			if (customer.getCustomerID() == customerID)
				return customer;
		}
		throw new IllegalArgumentException("Customer Not Found");
	}
	
	
	public Event findEvent(int eventID) {
		for(Event event : events) {
			if(event.getEventID()==eventID)
				return event;
		}
		throw new IllegalArgumentException("Event Not Found");
	}
	
	
	public void reservation(int customerID, int eventID, int ticketAmount) {
		
		
		try {
			Customer customer = findCustomer(customerID);
			Event event = findEvent(eventID);
			double paidAmount = Booking.calculatePaidAmount(event, customer);
			if (this.isBookingLegal(customer, event, ticketAmount, paidAmount))
				customer.pay(paidAmount);
				event.reserveSeats(ticketAmount);
				this.bookings.add(new Booking(customer.getCustomerName(), customer.getCustomerID(), event.getEventName(), event.getEventID(), ticketAmount,event.getTicketPrice(), paidAmount));
				System.out.println("SUCCESS | Paid: " + paidAmount);
		}
		catch(IllegalArgumentException e) {
			System.out.println("FAILED | " + e);
		}
		/*
		if (this.isBookingLegal(customer, event, ticketAmount, paidAmount)) {
			this.bookings.add(new Booking(customer.getCustomerName(), customer.getCustomerID(), event.getEventName(), event.getTicketPrice(), paidAmount));
		}
		*/
	}
	
	public void cancellation(int bookingID) {
		try {
			Booking booking = findBooking(bookingID);
			Customer customer = findCustomer(booking.getCustomerID());
			Event event = findEvent(booking.getEventID());
			booking.cancell();
			double refundAmount = booking.getPaidAmount();
			event.releaseSeats(booking.getTicketAmount());
			customer.refund(refundAmount);
			System.out.println("SUCCESS | Refund: " + refundAmount);
		}
		catch(IllegalArgumentException e){
			System.out.println("FAILED | " + e);
		}
	}
	
	public void test() {
		System.out.println(this.findEvent(101).getCapacity());
	}
}
