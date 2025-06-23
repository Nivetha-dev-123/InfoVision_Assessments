package Model;

import java.util.Date;

public class Complaint {
	private String issue;
	private Date dateField;
	public Complaint(String issue) {
		super();
		this.issue = issue;
		this.dateField = new Date();
	}
	@Override
    public String toString() {
        return "Complaint: " + issue + 
        		" \n(Filed on: " + dateField + ")";
    }
	
	
	
	

}
