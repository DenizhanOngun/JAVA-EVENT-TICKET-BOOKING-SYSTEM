package ticketbooking.model;


public class Event {
	
	enum Category{ CONCERT, CONFERENCE, SPORTS}
	
	private int eventID;
	private String eventName;
	private Category category;
	private int capacity;
	private int ticketPrice;
	
	public Event(int eventID, 
				 String eventName,
				 String category, 
				 int capacity, 
				 int ticketPrice) {
		
		this.eventID = eventID;
		this.eventName = eventName;
		this.category = Category.valueOf(category);
		this.capacity = capacity;
		this.ticketPrice = ticketPrice;
	}

}
