package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer {
	private int customerId;
	private String name;
	private String phoneNumber;
	
	private List<Call> callHistory;
	private Set<String> subscribedVas;
	private List<Complaint> complaints;
	public Customer(int customerId, String name, String phoneNumber) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.callHistory = new ArrayList<>();
		this.subscribedVas = new HashSet<>();
		this.complaints = new ArrayList<>();
	}
	public int getCustomerId() {
		return customerId;
	}
	
	public void addCall(String toNumber,int duration) {
		callHistory.add(new Call(toNumber,duration));
	}
	
	public void subscribeVAS(String service) {
		subscribedVas.add(service);
	}
	
	public void unsubscribeVAS(String service) {
		subscribedVas.remove(service);
	}
	
	public void fileComplaint(String issue) {
		complaints.add(new Complaint(issue));
	}
	
	public List<Call> getCallHistory(){
		return callHistory;
	}
	
	public Set<String> getsubscribedVas(){
		return subscribedVas;
	}
	
	public List<Complaint> getComplaint(){
		return complaints;
	}
	@Override
    public String toString() {
        return "Customer ID: " + customerId +
               "\nName: " + name +
               "\nPhone: " + phoneNumber +
               "\nVAS Subscribed: " + subscribedVas +
               "\nCall History: " + callHistory +
               "\nComplaints: " + complaints + "\n";
    }
	
	
	
	
	
	
	
	
	
	

}
