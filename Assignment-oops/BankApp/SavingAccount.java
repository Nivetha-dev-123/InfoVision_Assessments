package BankApp;


public class SavingAccount extends BankAccount {
    private static final double MINIMUM_DEPOSIT = 1000;
    private static final double INTEREST_RATE = 0.04;
    private int withdrawalCount = 0;
    private static final int MAX_WITHDRAWALS = 3;

    public SavingAccount(String accountHolderName, String accountNumber, String branch, String pancard,
                         String aadharNumber, String mobileNumber, double initialDeposit) {
        super(accountHolderName, accountNumber, branch, pancard, aadharNumber, mobileNumber, initialDeposit);
    }

    @Override
    public void openAccount() {
        System.out.println("\n[Savings Account Created]");
        System.out.println("Documents Required: PAN, Aadhaar, Photo");
        System.out.println("Account opened with initial deposit ₹" + balance);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("\n--- Savings Account Details ---");
        System.out.println("Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Branch: " + branch);
        System.out.println("PAN: " + pancard);
        System.out.println("Aadhaar: " + aadharNumber);
        System.out.println("Mobile: " + mobileNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Max Withdrawals allowed per month: " + MAX_WITHDRAWALS);
    }

    @Override
    public double calculateInterest() {
        double interest = balance * INTEREST_RATE;
        System.out.println("💰 Interest Earned: ₹" + interest);
        return interest;
    }

    @Override
    public void withdraw(double amount) throws InvalidWithdrawalException {
        if (withdrawalCount >= MAX_WITHDRAWALS) {
            throw new InvalidWithdrawalException("Monthly withdrawal limit reached.");
        }
        if (amount > balance) {
            throw new InvalidWithdrawalException("Insufficient balance to withdraw ₹" + amount);
        }
        balance -= amount;
        withdrawalCount++;
        System.out.println("✅ Withdrawn ₹" + amount + ". Remaining: ₹" + balance);
    }

    public void resetWithdrawalCount() {
        withdrawalCount = 0;
        System.out.println("🔄 Withdrawal count reset.");
    }
}
