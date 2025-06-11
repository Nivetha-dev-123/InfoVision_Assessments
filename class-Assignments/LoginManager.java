package Day3;

import java.util.Scanner;

public class LoginManager {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";
    private static final long MOBILE_NUMBER = 9876543210L;  // Example mobile number

    // Interactive login (choose mode)
    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== LOGIN =====");
        System.out.print("Login using (1) Username & Password or (2) Mobile Number only? Enter 1 or 2: ");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            return login(username, password);

        } else if ("2".equals(choice)) {
            System.out.print("Mobile Number: ");
            long mobile = Long.parseLong(scanner.nextLine());

            return login(mobile);

        } else {
            System.out.println("❌ Invalid choice.");
            return false;
        }
    }

    // Login with username and password
    public static boolean login(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("✅ Login successful with username and password!");
            return true;
        } else {
            System.out.println("❌ Invalid username or password.");
            return false;
        }
    }

    // Login with mobile number only
    public static boolean login(long mobileNumber) {
        if (mobileNumber == MOBILE_NUMBER) {
            System.out.println("✅ Login successful with mobile number!");
            return true;
        } else {
            System.out.println("❌ Invalid mobile number.");
            return false;
        }
    }
}
