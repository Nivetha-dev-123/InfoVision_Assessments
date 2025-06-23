package service;

import java.util.HashMap;
import java.util.Map;

import Model.Complaint;
import Model.Customer;

public class TelecomService {
	private Map<Integer,Customer> customerMap;
	private int customerIdCounter;
	public TelecomService() {
		
		this.customerMap = new HashMap<>();
		this.customerIdCounter = 1000;
	}
	
	public Customer addCustomer(String name,String phoneNumber) {
		int id=customerIdCounter++;
		Customer customer=new Customer(id,name,phoneNumber);
		customerMap.put(id, customer);
		return customer;
		
	}
	
	public Customer getCustomer(int customerId) {
		return customerMap.get(customerId);
	}
	
	public void recordCall(int customerId,String toNumber,int duration) {
		Customer customer=getCustomer(customerId);
		if(customer!=null) {
			customer.addCall(toNumber, duration);
		}
		else {
			System.out.println("Customer not found");
		}
	}
	
	public void subscribeVas(int customerId,String service) {
		Customer customer=getCustomer(customerId);
		if(customer!=null) {
			customer.subscribeVAS(service);
		}
		else {
			System.out.println("Customer not found");
		}
	}
	
	public void unsubscribeVas(int customerId,String service) {
		Customer customer=getCustomer(customerId);
		if(customer!=null) {
			customer.unsubscribeVAS(service);
		}
		else {
			System.out.println("Customer not found");
		}
	}
	
	public void fileComplaint(int customerId, String issue) {
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            customer.fileComplaint(issue);
        } else {
            System.out.println("Customer not found.");
        }
    }
	
	public void viewComplaints(int customerId) {
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            System.out.println("Complaints for Customer ID " + customerId + ":");
            for (Complaint c : customer.getComplaint()) {
                System.out.println(c);
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void displayAllCustomers() {
        for (Customer customer : customerMap.values()) {
            System.out.println(customer);
        }
    }
	
    
	

	
}
