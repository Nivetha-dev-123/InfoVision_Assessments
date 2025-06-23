package Main;

import Model.Customer;
import service.TelecomService;

public class Main {
	public static void main(String args[]) {
		TelecomService telecom=new TelecomService();
		//add customer
		Customer c1=telecom.addCustomer("Nivetha", "9123501984");
		Customer c2=telecom.addCustomer("Nagalingam", "1234567890");
		
		//record some calls.
		telecom.recordCall(c1.getCustomerId(), "7777789000", 5);
		telecom.recordCall(c1.getCustomerId(), "97101015645", 3);
		
		//subscribe Vas..
		
		telecom.subscribeVas(c1.getCustomerId(), "caller Tune");
		telecom.subscribeVas(c1.getCustomerId(), "Missed call Alert");
		
		//File Complaint
		telecom.fileComplaint(c1.getCustomerId(), "No network in basement");
		
		//view complaint..
		telecom.fileComplaint(c1.getCustomerId(), "No network in basement");
		
		//display all customers..
		telecom.displayAllCustomers();
		
		
	}

}
