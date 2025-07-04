package service;

import java.time.Duration;
import java.time.LocalDateTime;

import model.CallLog;
import model.Customer;

public class CallTask implements Runnable{

	
	private final Customer caller;
    private final Customer receiver;

    public CallTask(Customer caller, Customer receiver) {
        this.caller = caller;
        this.receiver = receiver;
    }

    @Override
    public void run() {
        LocalDateTime startTime = LocalDateTime.now();
        try {
            Thread.sleep(1000 + (long)(Math.random() * 4000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        LocalDateTime endTime = LocalDateTime.now();
        long durationSeconds = Duration.between(startTime, endTime).getSeconds();
	     
        CallLog callLog = new CallLog(caller, receiver, startTime, endTime, durationSeconds);
        CallManager.getInstance().addCallLog(callLog);

        System.out.println("Call ended: " + callLog);
    }

}
