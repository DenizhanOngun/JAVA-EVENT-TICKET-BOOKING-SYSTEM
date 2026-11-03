package ticketbooking.app;

import ticketbooking.io.FileIO;
import ticketbooking.service.BookingSystem;

public class TicketBookingApp {

	public static void main(String[] args) {
		BookingSystem bookingSystem = new BookingSystem();
		bookingSystem.addEvents(FileIO.loadEvents("events.csv"));
		bookingSystem.addCusomers(FileIO.loadCustomers("customers.csv"));
		bookingSystem.reservation(201, 101, 1);
		bookingSystem.reservation(202, 103, 1);
		bookingSystem.reservation(205, 104, 6);
		bookingSystem.reservation(203, 101, 1);
		bookingSystem.reservation(201, 102, 0);
		bookingSystem.reservation(205, 102, 2);
		
		bookingSystem.test();
		
		bookingSystem.cancellation(1);
		bookingSystem.cancellation(1);
	}
}
