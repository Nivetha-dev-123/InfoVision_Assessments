package BankApp;



public abstract class BankAccount implements AccountOperations {
    protected String accountHolderName;
    protected String accountNumber;
    protected String branch;
    protected String pancard;
    protected String aadharNumber;
    protected String mobileNumber;
    protected double balance;

    public BankAccount(String accountHolderName, String accountNumber, String branch, String pancard,
                       String aadharNumber, String mobileNumber, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.branch = branch;
        this.pancard = pancard;
        this.aadharNumber = aadharNumber;
        this.mobileNumber = mobileNumber;
        this.balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0) {
            throw new InvalidDepositException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("✅ Deposited ₹" + amount);
    }

    public abstract double calculateInterest();

    public abstract void withdraw(double amount) throws InvalidWithdrawalException;
}
