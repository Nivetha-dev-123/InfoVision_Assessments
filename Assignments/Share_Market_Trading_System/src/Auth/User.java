package Auth;

public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputPassword) {
        return password.equals(inputPassword);
    }

    public String getUsername() {
        return username;
    }
}
