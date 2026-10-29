package ticketbooking.model;

public class Customer {
	private int customerID;
	private String customerName;
	private double customerBalance;
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
	
	public double getCustomerBalance() {
		return customerBalance;
	}
		
	public void pay(double paidAmount) {
		if (paidAmount<= 0)
			throw new IllegalArgumentException("Amount cannot be"
					+ " negative number or zero");					
		else if(this.canAfford(paidAmount))
			throw new IllegalArgumentException("Insufficent Balance");
		else
			customerBalance = customerBalance - paidAmount;
	}
	
	public boolean canAfford(double amount) {
		return customerBalance >= amount;
	}
	
	public void refund(int refundAmount) {
		if (refundAmount<= 0)
			throw new IllegalArgumentException("Amount cannot be"
					+ " negative number or zero");
		customerBalance = customerBalance + refundAmount;
	}
}
