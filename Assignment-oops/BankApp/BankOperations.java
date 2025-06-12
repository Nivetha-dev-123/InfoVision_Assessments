package BankApp;


public class BankOperations {

    public void withdraw(BankAccount account, double amount) throws InvalidWithdrawalException {
        account.withdraw(amount);
    }

    public void withdraw(BankAccount account, double amount, String mode) throws InvalidWithdrawalException {
        System.out.println("Withdraw via " + mode);
        account.withdraw(amount);
    }

    public void withdraw(BankAccount account) throws InvalidWithdrawalException {
        withdraw(account, 1000);
    }

    public double calculateInterest(SavingAccount account) {
        return account.calculateInterest();
    }

    public double calculateInterest(CurrentAccount account) {
        return account.calculateInterest();
    }
}

