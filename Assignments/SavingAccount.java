package Day2;

public class SavingAccount extends BankAccount {
	private double minimumBalance;

	public SavingAccount(String accountHolderName, String accountNumber, String branch, String pancard,
			String aadharNumber, double minimumBalance) {
		super(accountHolderName, accountNumber, branch, pancard, aadharNumber);
		this.minimumBalance = minimumBalance;
	}

	@Override
	public void openAccount() {
		System.out.println("\n[Savings Account Created]");
        System.out.println("Documents Required: PAN, Aadhaar, Photo");
		
	}

	@Override
	public void displayAccountDetails() {
		 System.out.println("\n--- Savings Account Details ---");
	        System.out.println("Name: " + accountHolderName);
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Branch: " + branch);
	        System.out.println("PAN: " + pancard);
	        System.out.println("Aadhaar: " + aadharNumber);
	        System.out.println("Minimum Balance: ₹" + minimumBalance);
		
	}
	
	

}
