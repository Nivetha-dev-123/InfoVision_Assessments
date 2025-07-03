package Auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginService {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, User> mobileUsers = new HashMap<>();  // mobile number -> User

    public LoginService() {
        // Username based users
        users.put("alice", new User("alice", "pass123"));
        users.put("bob", new User("bob", "bob123"));
        users.put("charlie", new User("charlie", "charlie123"));

        // Add mobile numbers for these users (example mobile numbers)
        mobileUsers.put("1234567890", users.get("alice"));
        mobileUsers.put("9876543210", users.get("bob"));
        mobileUsers.put("5556667777", users.get("charlie"));
    }

    // Login by username & password
    public String login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine().toLowerCase();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            System.out.println("✅ Login successful. Welcome, " + user.getUsername() + "!");
            return user.getUsername();
        } else {
            System.out.println("❌ Invalid username or password.");
            return null;
        }
    }

    // Overloaded login: login by mobile number & OTP
    public String loginByMobile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter mobile number: ");
        String mobile = scanner.nextLine();

        User user = mobileUsers.get(mobile);
        if (user == null) {
            System.out.println("❌ Mobile number not registered.");
            return null;
        }

        // For simplicity, simulate OTP = "0000"
        System.out.print("Enter OTP sent to your mobile: ");
        String otp = scanner.nextLine();

        if ("0000".equals(otp)) {
            System.out.println("✅ Login successful. Welcome, " + user.getUsername() + "!");
            return user.getUsername();
        } else {
            System.out.println("❌ Invalid OTP.");
            return null;
        }
    }
}
