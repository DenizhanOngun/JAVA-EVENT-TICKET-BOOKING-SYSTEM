package ticketbooking.model;

import java.time.LocalDateTime;

public class Booking {
	
	enum Status {ACTIVE, CANCELLED}
	private int nextID = 1;
	private final int bookingID;
	private String customerName;
	private int customerID;
	private String eventName;
	private double originalTotalPrice;
	private double  paidAmount;
	private Status status;
	private final LocalDateTime createdAt;
	private LocalDateTime cancellationAt;
	
	
	public Booking(String customerName,
			int customerID,
			String eventName,
			double originalTotalPrice,
			double paidAmount) {
		this.bookingID = nextID++;
		this.customerName = customerName;
		this.eventName = eventName;
		this.originalTotalPrice = originalTotalPrice;
		this.paidAmount = paidAmount;
		this.status = Status.ACTIVE;
		this.createdAt = LocalDateTime.now();
	}
	public int getBookingID() {
		return bookingID;
	}
	
	public double getOriginalTotalPrice() {
		return originalTotalPrice;
	}
	public void setOriginalTotalPrice(int originalTotalPrice) {
		this.originalTotalPrice = originalTotalPrice;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getCustomerName() {
		return customerName;
	}
	public int getCustomerID() {
		return customerID;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt; // LocalDateTime immutable obje olduğu için böyle returnluyorum.
	}
	public String getEventName() {
		return eventName;
	}

	
	
	public static double calculatePaidAmount(Event event, Customer customer) {
		double amount = 0;
		if(customer.getClass() == PremiumCustomer.class) 
			 amount = event.getTicketPrice()*(1-PremiumCustomer.PREMIUM_DISCOUNT);
		return amount;
		
	}
	

	
	
}
