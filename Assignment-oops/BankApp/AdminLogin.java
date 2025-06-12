package BankApp;

public class AdminLogin {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String ADMIN_MOBILE = "9123456789";

    // Login with username and password
    public boolean login(String username, String password) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            System.out.println("Admin login successful with username and password.");
            return true;
        }
        System.out.println("Admin login failed with username and password.");
        return false;
    }

    // Login with mobile number
    public boolean login(String mobileNumber) {
        if (ADMIN_MOBILE.equals(mobileNumber)) {
            System.out.println("Admin login successful with mobile number.");
            return true;
        }
        System.out.println("Admin login failed with mobile number.");
        return false;
    }
}
