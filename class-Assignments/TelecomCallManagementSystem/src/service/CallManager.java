package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import model.CallLog;
import model.Customer;

public class CallManager {
	
	private static final CallManager instance = new CallManager();

    private final Map<Customer, List<CallLog>> callLogs = new ConcurrentHashMap<>();

    private CallManager() {}

    public static CallManager getInstance() {
        return instance;
    }

    public void addCallLog(CallLog log) {
        callLogs.computeIfAbsent(log.getCaller(), c -> new ArrayList<>()).add(log);
        callLogs.computeIfAbsent(log.getReceiver(), c -> new ArrayList<>()).add(log);
    }
    public List<CallLog> getCallLogs(Customer customer) {
        return callLogs.getOrDefault(customer, Collections.emptyList());
    }

}
