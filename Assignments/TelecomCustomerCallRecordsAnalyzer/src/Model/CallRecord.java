package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class CallRecord {
     private String caller;
     private String receiver;
     private LocalDateTime startTime;
     private LocalDateTime endTime;
     private String operator;
     private String location;
	public CallRecord(String caller, String receiver, LocalDateTime startTime, LocalDateTime endTime, String operator,
			String location) {
		super();
		this.caller = caller;
		this.receiver = receiver;
		this.startTime = startTime;
		this.endTime = endTime;
		this.operator = operator;
		this.location = location;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	 public long getDurationInSeconds() {
	        return Duration.between(startTime, endTime).getSeconds();
	    }
	@Override
	public String toString() {
		return "CallRecord [caller=" + caller + ", receiver=" + receiver + ", startTime=" + startTime + ", endTime="
				+ endTime + ", operator=" + operator + ", location=" + location + "]";
	}
     
     
     
     
}
