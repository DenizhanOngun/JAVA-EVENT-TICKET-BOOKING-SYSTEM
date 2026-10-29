package ticketbooking.model;

public class PremiumCustomer extends Customer {
	public static final double PREMIUM_DISCOUNT = 0.05;

	    public PremiumCustomer(int customerID,
	    						String customerName,
	    						int customerBalance) {
	        super(customerID, customerName, customerBalance);
	    }
}
