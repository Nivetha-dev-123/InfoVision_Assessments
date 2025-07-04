package service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Customer;

public class Main {
	 public static void main(String[] args) throws InterruptedException {
	        CustomerService customerService = new CustomerService();

	        // Add customers
	        customerService.addCustomer("C1", "Nivetha");
	        customerService.addCustomer("C2", "Nagalingam");
	        customerService.addCustomer("C3", "Kishore");

	        // Activate plans
	        customerService.activatePlan("C1", "PREPAID");
	        customerService.activatePlan("C2", "POSTPAID");
	        customerService.activatePlan("C3", "PREPAID");

	        // Register billing observer
	        BillingEngine billingEngine = BillingEngine.getInstance();
	        billingEngine.addObserver(new BillingNotificationService());

	        // Simulate concurrent calls
	        ExecutorService executor = Executors.newFixedThreadPool(3);

	        executor.submit(new CallTask(customerService.getCustomer("C1"), customerService.getCustomer("C2")));
	        executor.submit(new CallTask(customerService.getCustomer("C2"), customerService.getCustomer("C3")));
	        executor.submit(new CallTask(customerService.getCustomer("C3"), customerService.getCustomer("C1")));

	        executor.shutdown();
	        while (!executor.isTerminated()) {
	            Thread.sleep(500);
	        }

	        // Generate bills for all customers
	        for (Customer customer : customerService.getAllCustomers()) {
	            double bill = billingEngine.generateBill(customer);
	            System.out.printf("Total bill for", customer.getName(), customer.getPlan(), bill);
	        }
	    }
	

}
