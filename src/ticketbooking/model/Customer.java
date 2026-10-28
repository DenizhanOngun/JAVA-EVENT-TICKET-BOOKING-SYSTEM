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
	
	public Customer(Customer customer) { //Copy Constructor
		this.customerID = customer.customerID;
		this.customerName = customer.customerName;
		this.customerBalance = customer.customerBalance;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public int getCustomerBalance() {
		return customerBalance;
	}
		
	public void pay(int paidAmount) {
		if (paidAmount<= 0)
			throw new IllegalArgumentException("Amount cannot be"
					+ " negative number or zero");					
		
		customerBalance = customerBalance - paidAmount;
	}
	
	public void refund(int refundAmount) {
		if (refundAmount<= 0)
			throw new IllegalArgumentException("Amount cannot be"
					+ " negative number or zero");
		customerBalance = customerBalance + refundAmount;
	}
}
