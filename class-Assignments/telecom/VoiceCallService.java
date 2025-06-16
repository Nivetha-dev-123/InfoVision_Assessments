package Day3;

public class VoiceCallService extends BaseService {
    
    // Standard constructor
    public VoiceCallService(double rate) {
        super("Voice Call Service", rate);
    }

    // 🔁 Shallow copy constructor
    public VoiceCallService(VoiceCallService other) {
        super(other.serviceName, other.ratePerUnit);  // strings are immutable, so this is safe
    }

    // 🧬 Deep copy constructor (same as shallow here due to no mutable object fields)
    public VoiceCallService deepCopy() {
        // If you had mutable fields, you would copy them explicitly here
        return new VoiceCallService(this);  // still returns a new object
    }

    @Override
    protected void processPayment(int units, double amount) {
        System.out.printf("Billing Calls: %d mins @ ₹%.2f = ₹%.2f%n", units, ratePerUnit, amount);
    }

    public void billCustomer(double units) {
        if (units <= 0) {
            System.out.println("❌ Invalid call duration.");
            return;
        }
        int rounded = (int) Math.ceil(units);
        System.out.printf("ℹ️ Fractional call time (%.2f mins) rounded to %d mins%n", units, rounded);
        billCustomer(rounded);
    }
}
