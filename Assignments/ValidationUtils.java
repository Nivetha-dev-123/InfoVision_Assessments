package Day2;

public class ValidationUtils {
	public static boolean isValidAadhaar(String aadhaar) {
        return aadhaar != null && aadhaar.matches("\\d{12}");
    }

    public static boolean isValidPAN(String pan) {
        return pan != null && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]");
    }


}
