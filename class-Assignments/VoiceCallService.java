package Day3;

public class VoiceCallService extends BaseService {
    public VoiceCallService(double rate) {
        super("Voice Call Service", rate);
    }

    @Override
    protected void processPayment(int units, double amount) {
        System.out.printf("Billing Calls: %d mins @ ₹%.2f = ₹%.2f%n", units, ratePerUnit, amount);
    }

    // Method Overloading: Accept fractional call duration
    public void billCustomer(double units) {
        int rounded = (int) Math.ceil(units);
        System.out.printf("ℹ️ Fractional call time (%.2f mins) rounded to %d mins%n", units, rounded);
        billCustomer(rounded);
    }
}
