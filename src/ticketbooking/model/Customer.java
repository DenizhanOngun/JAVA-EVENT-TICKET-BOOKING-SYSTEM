package ticketbooking.model;

public class Customer {
	private int customerID;
	private String customerName;
	private int customerBalance;
	public  static final String customerType = "REGULAR";
	public Customer(int customerID,
					String customerName,
					int customerBalance) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerBalance = customerBalance;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public int getCustomerBalance() {
		return customerBalance;
	}
	
	public void setCustomerBalance() {
		
	}
	
		
}
