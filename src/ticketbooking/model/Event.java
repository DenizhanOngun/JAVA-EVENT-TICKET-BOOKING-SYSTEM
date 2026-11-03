package ticketbooking.model;


public class Event {
	
	enum Category{ CONCERT, CONFERENCE, SPORTS}
	
	private int eventID;
	private String eventName;
	private Category category;
	private int capacity;
	private double ticketPrice;
	private int MAX_CAPACITY;
	public Event(int eventID, 
				 String eventName,
				 String category, 
				 int capacity, 
				 int ticketPrice) {
		
		this.eventID = eventID;
		this.eventName = eventName;
		this.category = Category.valueOf(category);
		this.capacity = capacity;
		this.MAX_CAPACITY = capacity;
		this.ticketPrice = ticketPrice;
		
	}
	
	public boolean canReserveSeats(int amount) {
		if (!(capacity >=amount))
			throw new IllegalArgumentException("Insufficent Capacity");
		else
			return capacity >= amount;
	}
	
	
	public boolean canReleaseSeats(int amount) {
		return MAX_CAPACITY >= capacity + amount;
	}
	public void reserveSeats(int amount) {
		if ( amount <= 0)
		throw new IllegalArgumentException("Invalid Quantity");
		if (!canReserveSeats(amount))
			throw new IllegalArgumentException(" Insufficient Capacity" );
		capacity -= amount;
	}
	public void releaseSeats(int amount) {
		if ( amount <= 0)
			throw new IllegalArgumentException("Invalid Quantity");
		if (!canReleaseSeats(amount))
			throw new IllegalArgumentException("Capacity can't be exceed " + MAX_CAPACITY );
		capacity += amount;
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}
	public String getEventName() {
		return eventName;
	}
	public int getEventID() {
		return eventID;
	}
	public int getCapacity() {
		return capacity;
	}
}
