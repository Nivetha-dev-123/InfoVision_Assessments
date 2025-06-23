package Model;

public class Call {
	private String phoneNumber;
	private int durationInMinutes;
	
	public Call(String phoneNumber, int durationInMinutes) {
		super();
		this.phoneNumber = phoneNumber;
		this.durationInMinutes = durationInMinutes;
	}

	@Override
    public String toString() {
        return "Called: " + phoneNumber + ", Duration: " + durationInMinutes + " mins";
    }
	
	
	
	

}
