package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import factory.PlanFactory;
import model.Customer;
import model.Plan;

public class CustomerService {
	
	 private final Map<String, Customer> customers = new HashMap<>();

	    public void addCustomer(String id, String name) {
	        if (customers.containsKey(id))
	            throw new IllegalArgumentException("Customer already exists");
	        customers.put(id, new Customer(id, name));
	    }

	    public void updateCustomerName(String id, String newName) {
	        Customer c = customers.get(id);
	        if (c == null) throw new NoSuchElementException("Customer not found");
	        c.setName(newName);
	    }

	    public void deleteCustomer(String id) {
	        customers.remove(id);
	    }
	    public void activatePlan(String id, String planType) {
	        Customer c = customers.get(id);
	        if (c == null) throw new NoSuchElementException("Customer not found");
	        Plan plan = PlanFactory.getPlan(planType);
	        c.setPlan(plan);
	    }

	    public Customer getCustomer(String id) {
	        return customers.get(id);
	    }

	    public Collection<Customer> getAllCustomers() {
	        return customers.values();
	    }
}



