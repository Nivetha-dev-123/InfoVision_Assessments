package model;

import java.time.LocalDateTime;

public class CallLog {
    private final Customer caller;
    private final Customer receiver;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final long durationSeconds;

    public CallLog(Customer caller, Customer receiver, LocalDateTime startTime, LocalDateTime endTime, long durationSeconds) {
        this.caller = caller;
        this.receiver = receiver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durationSeconds = durationSeconds;
    }

    public Customer getCaller() { return caller; }
    public Customer getReceiver() { return receiver; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public long getDurationSeconds() { return durationSeconds; }

    @Override
    public String toString() {
        return String.format("CallLog{caller=%s, receiver=%s, duration=%ds}", caller.getName(), receiver.getName(), durationSeconds);
    }
}

