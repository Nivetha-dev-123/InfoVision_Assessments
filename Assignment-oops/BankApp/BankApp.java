package BankApp;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) throws InvalidWithdrawalException {
        Scanner scanner = new Scanner(System.in);
        AdminLogin adminLogin = new AdminLogin();

        System.out.println("====== Bank Admin Login ======");
        System.out.print("Choose login method: 1 - Username & Password, 2 - Mobile Number: ");
        int loginChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean isLoggedIn = false;
        if (loginChoice == 1) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            isLoggedIn = adminLogin.login(username, password);
        } else if (loginChoice == 2) {
            System.out.print("Enter mobile number: ");
            String mobileNumber = scanner.nextLine();
            isLoggedIn = adminLogin.login(mobileNumber);
        } else {
            System.out.println("Invalid login option.");
        }

        if (!isLoggedIn) {
            System.out.println("Access denied. Exiting...");
            scanner.close();
            return;
        }

        BankOperations bankOps = new BankOperations();
        String continueChoice;

        System.out.println("====== Welcome to XYZ Bank ======");

        do {
            System.out.println("\nYou can open only ONE account per session: (1) Savings or (2) Current");

            int choice = 0;
            while (true) {
                System.out.print("Choose Account Type (1 or 2): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (choice == 1 || choice == 2) break;
                    else System.out.println("❌ Invalid input. Please enter 1 or 2.");
                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    scanner.nextLine(); // discard invalid input
                }
            }

            System.out.print("Enter Account Holder Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobile = scanner.nextLine();

            System.out.print("Enter Branch Code (e.g., BLR, MUM): ");
            String branchCode = scanner.nextLine();

            String pan;
            while (true) {
                System.out.print("Enter PAN Number: ");
                pan = scanner.nextLine();
                try {
                    ValidationUtils.validatePAN(pan);
                    break;
                } catch (InvalidPANException e) {
                    System.out.println("❌ " + e.getMessage());
                }
            }

            String aadhaar;
            while (true) {
                System.out.print("Enter Aadhaar Number: ");
                aadhaar = scanner.nextLine();
                try {
                    ValidationUtils.validateAadhaar(aadhaar);
                    break;
                } catch (InvalidAadhaarException e) {
                    System.out.println("❌ " + e.getMessage());
                }
            }

            double initialDeposit = 0;
            while (true) {
                System.out.print("Enter Initial Deposit Amount: ");
                if (scanner.hasNextDouble()) {
                    initialDeposit = scanner.nextDouble();
                    scanner.nextLine();
                    if (initialDeposit >= 0) break;
                    else System.out.println("❌ Deposit cannot be negative.");
                } else {
                    System.out.println("❌ Invalid amount. Please enter a number.");
                    scanner.nextLine();
                }
            }

            String accNo = AccountNumberGenerator.generateAccountNumber(branchCode);

            if (choice == 1) {
                if (initialDeposit < 1000) {
                    System.out.println("❌ Minimum deposit for Savings Account is ₹1000. Account creation failed.");
                } else {
                    SavingAccount savings = new SavingAccount(name, accNo, branchCode, pan, aadhaar, mobile, initialDeposit);
                    savings.openAccount();
                    savings.displayAccountDetails();

                    double interest = bankOps.calculateInterest(savings);
                    System.out.println("Interest earned: ₹" + interest);

                    System.out.print("Withdraw amount? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = scanner.nextDouble();
                        scanner.nextLine();
                        savings.withdraw(amt);
                    }
                }
            } else if (choice == 2) {
                System.out.print("Enter Business Name (or press Enter if individual): ");
                String business = scanner.nextLine();

                if (initialDeposit < 5000) {
                    System.out.println("❌ Minimum deposit for Current Account is ₹5000. Account creation failed.");
                } else {
                    CurrentAccount current = new CurrentAccount(name, accNo, branchCode, pan, aadhaar, mobile, initialDeposit, business);
                    current.openAccount();
                    current.displayAccountDetails();

                    double interest = bankOps.calculateInterest(current);
                    System.out.println("Interest earned: ₹" + interest);

                    System.out.print("Withdraw amount? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = scanner.nextDouble();
                        scanner.nextLine();
                        current.withdraw(amt);
                    }
                }
            }

            System.out.print("\nDo you want to create another account? (yes/no): ");
            continueChoice = scanner.nextLine().trim().toLowerCase();

        } while (continueChoice.equals("yes") || continueChoice.equals("y"));

        System.out.println("\n✅ Thank you for using XYZ Bank services!");
        scanner.close();
    }
}
