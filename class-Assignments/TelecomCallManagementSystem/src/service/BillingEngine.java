package service;



import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.CallLog;
import model.Customer;

public class BillingEngine {
    private static final BillingEngine instance = new BillingEngine();

    private final List<BillingObserver> observers = new CopyOnWriteArrayList<>();

    private BillingEngine() {}

    public static BillingEngine getInstance() {
        return instance;
    }

    public void addObserver(BillingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BillingObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Customer customer, double amount) {
        for (BillingObserver o : observers) {
            o.onBillGenerated(customer, amount);
        }
    }

    public double generateBill(Customer customer) {
        List<CallLog> logs = CallManager.getInstance().getCallLogs(customer);
        double total = 0.0;
        for (CallLog log : logs) {
            if (log.getCaller().equals(customer)) {
                double minutes = Math.ceil(log.getDurationSeconds() / 60.0);
                total += minutes * customer.getPlan().getRatePerMinute();
            }
        }
        notifyObservers(customer, total);
        return total;
    }
}
