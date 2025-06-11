package Day2;

public class CurrentAccount extends BankAccount{
	private String businessName;

	public CurrentAccount(String accountHolderName, String accountNumber, String branch, String pancard,
			String aadharNumber, String businessName) {
		super(accountHolderName, accountNumber, branch, pancard, aadharNumber);
		this.businessName = businessName;
	}

	@Override
	public void openAccount() {
		 System.out.println("\n[Current Account Created]");
	     System.out.println("Documents Required: PAN, Aadhaar, Business Proof");

		
	}

	@Override
	public void displayAccountDetails() {
		 System.out.println("\n--- Current Account Details ---");
	        System.out.println("Name: " + accountHolderName);
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Branch: " + branch);
	        System.out.println("PAN: " + pancard);
	        System.out.println("Aadhaar: " + aadharNumber);
	        System.out.println("Business Name: " + businessName);
		
	}
    
	
	
}
