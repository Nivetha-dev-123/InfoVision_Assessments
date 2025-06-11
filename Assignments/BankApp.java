package Day2;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    if (choice == 1 || choice == 2) {
                        break;
                    } else {
                        System.out.println("❌ Invalid input. Please enter 1 or 2.");
                    }
                } else {
                    System.out.println("❌ Invalid input. Please enter a number (1 or 2).");
                    scanner.nextLine(); // discard invalid input
                }
            }

            // Common input
            System.out.print("Enter Account Holder Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Branch Code (e.g., BLR, MUM): ");
            String branchCode = scanner.nextLine();

            System.out.print("Enter PAN Number: ");
            String pan = scanner.nextLine();
            while (!ValidationUtils.isValidPAN(pan)) {
                System.out.print("❌ Invalid PAN. Re-enter (Format: ABCDE1234F): ");
                pan = scanner.nextLine();
            }

            System.out.print("Enter Aadhaar Number: ");
            String aadhaar = scanner.nextLine();
            while (!ValidationUtils.isValidAadhaar(aadhaar)) {
                System.out.print("❌ Invalid Aadhaar. Must be 12 digits: ");
                aadhaar = scanner.nextLine();
            }

            String accNo = AccountNumberGenerator.generateAccountNumber(branchCode);

            if (choice == 1) {
                double minBal = 0;
                while (true) {
                    System.out.print("Enter Minimum Balance to Maintain: ");
                    if (scanner.hasNextDouble()) {
                        minBal = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        if (minBal >= 0) break;
                        else System.out.println("❌ Balance cannot be negative.");
                    } else {
                        System.out.println("❌ Invalid amount. Please enter a valid number.");
                        scanner.nextLine(); // discard invalid input
                    }
                }

                SavingAccount savings = new SavingAccount(name, accNo, branchCode, pan, aadhaar, minBal);
                savings.openAccount();
                savings.displayAccountDetails();

            } else if (choice == 2) {
                System.out.print("Enter Business Name: ");
                String business = scanner.nextLine();

                CurrentAccount current = new CurrentAccount(name, accNo, branchCode, pan, aadhaar, business);
                current.openAccount();
                current.displayAccountDetails();
            }

            System.out.print("\nDo you want to create another account? (yes/no): ");
            continueChoice = scanner.nextLine().trim().toLowerCase();

        } while (continueChoice.equals("yes") || continueChoice.equals("y"));

        System.out.println("\nThank you for using XYZ Bank services!");
        scanner.close();
    }
}
