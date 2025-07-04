package service;

import model.Customer;

public class BillingNotificationService  implements BillingObserver{

	  @Override
	    public void onBillGenerated(Customer customer, double amount) {
	        System.out.printf("Notification: Bill generated for %s. Amount: $%.2f%n", customer.getName(), amount);
	    }
	
	

}
