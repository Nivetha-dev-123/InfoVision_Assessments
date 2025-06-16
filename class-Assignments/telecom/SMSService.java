package Day3;

public class SMSService extends BaseService {
    public SMSService(double rate) {
        super("SMS Service", rate);
    }

    @Override
    protected void processPayment(int units, double amount) {
        System.out.printf("Billing SMS: %d msgs @ ₹%.2f = ₹%.2f%n", units, ratePerUnit, amount);
    }

    // Method Overloading: Accept fractional SMS units
    public void billCustomer(double units) {
        int rounded = (int) Math.ceil(units);
        System.out.printf("ℹ️ Fractional SMS input (%.2f) rounded to %d%n", units, rounded);
        billCustomer(rounded);
    }
}
