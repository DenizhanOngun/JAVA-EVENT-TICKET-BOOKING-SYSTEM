package ticketbooking.model;

import java.time.LocalDateTime;

public class Booking {
	
	enum Status {ACTIVE, CANCELLED}
	private int nextID = 1;
	private final int bookingID;
	private String customerName;
	private int customerID;
	private Event event;
	private int originalTotalPrice;
	private int  paidAmount;
	private Status status;
	private final LocalDateTime createdAt;
	private LocalDateTime cancellationAt;
	
	
	public Booking(String customerName,
			int customerID,
			Event event,
			int originalTotalPrice,
			int paidAmount,
			Status status) {
		this.bookingID = nextID++;
		this.customerName = customerName;
		this.event = event;
		this.originalTotalPrice = originalTotalPrice;
		this.paidAmount = paidAmount;
		this.status = status;
		this.createdAt = LocalDateTime.now();
	}
	public int getBookingID() {
		return bookingID;
	}
	
	public int getOriginalTotalPrice() {
		return originalTotalPrice;
	}
	public void setOriginalTotalPrice(int originalTotalPrice) {
		this.originalTotalPrice = originalTotalPrice;
	}
	public int getPaidAmount() {
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
	public Event getEvent() {
		Event temp = event;
		return temp;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
}
