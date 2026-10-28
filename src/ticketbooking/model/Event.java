package ticketbooking.model;


public class Event {
	
	enum Category{ CONCERT, CONFERENCE, SPORTS}
	
	private int eventID;
	private String eventName;
	private Category category;
	private int capacity;
	private int ticketPrice;
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
	
	public void reserveSeats(int amount) {
		if ( amount <= 0)
		throw new IllegalArgumentException("Amount cannot be"
				+ " negative number or zero");
		if (capacity-amount > 0)
			throw new IllegalArgumentException("Capacity can't be exceed " + MAX_CAPACITY );
		capacity -= amount;
	}
	public void releaseSeats(int amount) {
		if ( amount <= 0)
		throw new IllegalArgumentException("Amount cannot be"
				+ " negative number or zero");
		if (capacity+amount > MAX_CAPACITY)
			throw new IllegalArgumentException("Capacity can't be exceed " + MAX_CAPACITY );
		capacity += amount;
	}
}
