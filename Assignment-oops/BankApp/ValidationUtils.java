package BankApp;



public class ValidationUtils {

    public static void validateAadhaar(String aadhaar) throws InvalidAadhaarException {
        if (aadhaar == null || !aadhaar.matches("\\d{12}")) {
            throw new InvalidAadhaarException("Aadhaar must be 12 digits.");
        }
    }

    public static void validatePAN(String pan) throws InvalidPANException {
        if (pan == null || !pan.toUpperCase().matches("[A-Z]{5}[0-9]{4}[A-Z]")) {
            throw new InvalidPANException("PAN must match format: ABCDE1234F.");
        }
    }
}

