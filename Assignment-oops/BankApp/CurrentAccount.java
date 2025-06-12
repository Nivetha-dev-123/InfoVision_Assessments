package BankApp;

package Day2;

public class CurrentAccount extends BankAccount {
    private static final double MINIMUM_DEPOSIT = 5000;
    private static final double MINIMUM_BALANCE = 2000;
    private static final double PENALTY = 500;
    private String businessName;

    public CurrentAccount(String accountHolderName, String accountNumber, String branch, String pancard,
                          String aadharNumber, String mobileNumber, double initialDeposit, String businessName) {
        super(accountHolderName, accountNumber, branch, pancard, aadharNumber, mobileNumber, initialDeposit);
        this.businessName = businessName;
    }

    @Override
    public void openAccount() {
        System.out.println("\n[Current Account Created]");
        System.out.println("Documents Required: PAN, Aadhaar, Business Proof");
        System.out.println("Account opened with initial deposit ₹" + balance);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("\n--- Current Account Details ---");
        System.out.println("Name: " + accountHolderName);
        System.out.println("Business: " + businessName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Branch: " + branch);
        System.out.println("PAN: " + pancard);
        System.out.println("Aadhaar: " + aadharNumber);
        System.out.println("Mobile: " + mobileNumber);
        System.out.println("Balance: ₹" + balance);
    }

    @Override
    public double calculateInterest() {
        System.out.println("No interest for current accounts.");
        return 0;
    }

    @Override
    public void withdraw(double amount) throws InvalidWithdrawalException {
        if (amount > balance) {
            throw new InvalidWithdrawalException("Insufficient balance to withdraw ₹" + amount);
        }
        balance -= amount;
        System.out.println("✅ Withdrawn ₹" + amount + ". Remaining: ₹" + balance);
        if (balance < MINIMUM_BALANCE) {
            System.out.println("⚠️ Balance below ₹" + MINIMUM_BALANCE + ". Penalty ₹" + PENALTY + " applied.");
            balance -= PENALTY;
            System.out.println("New balance: ₹" + balance);
        }
    }
}


