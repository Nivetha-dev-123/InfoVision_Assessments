package service;

import model.Customer;

interface BillingObserver {

	
	void onBillGenerated(Customer customer, double amount);
}
