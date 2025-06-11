package Day2;

public abstract class BankAccount implements AccountOperations {

	protected String accountHolderName;
	protected String accountNumber;
	protected String branch;
	protected String pancard;
	protected String aadharNumber;
	public BankAccount(String accountHolderName, String accountNumber, String branch, String pancard,
			String aadharNumber) {
		super();
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.pancard = pancard;
		this.aadharNumber = aadharNumber;
	}
	
	
}
