package ticketbooking.service;

public class Query {
	private String mostPopulerEvent; //  event name and number of active reserved tickets. 
	private String highestRevenueEvent; //event name and total revenue from active bookings.
	private String topCustomer; // customer name, membership type, and total number of active reserved tickets across all events.
	private String ticketsByCategory; // total active reserved tickets for CONCERT, CONFERENCE, and SPORTS,  in that order.
}
