package Day2;

public class AccountNumberGenerator {
	private static int counter = 1001;

    public static String generateAccountNumber(String branchCode) {
        return branchCode.toUpperCase() + "-" + (counter++);
    }


}
