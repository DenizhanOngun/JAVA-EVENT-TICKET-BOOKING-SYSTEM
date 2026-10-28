package ticketbooking.model;

public class Booking {
	
	enum Status {ACTIVE, CANCELLED}
	
	private int bookingID;
	private Customer customer;
	private Event event;
	private int originalTotalPrice;
	private int  paidAmount;
	private Status status;
	
	
	public Booking(int bookingID,
			Customer customer,
			Event event,
			int originalTotalPrice,
			int paidAmount,
			Status status) {
		this.bookingID = bookingID;
		this.customer = customer;
		this.event = event;
		this.originalTotalPrice = originalTotalPrice;
		this.paidAmount = paidAmount;
		this.status = status;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
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
	public Customer getCustomer() {
		Customer temp = customer;
		return temp;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Event getEvent() {
		Event temp = event;
		return temp;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
}
