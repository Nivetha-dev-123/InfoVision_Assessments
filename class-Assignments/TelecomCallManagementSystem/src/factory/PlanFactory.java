package factory;

import model.Plan;
import model.PostpaidPlan;
import model.PrepaidPlan;

public class PlanFactory {
	
	public static Plan getPlan(String planType) {
        if ("PREPAID".equalsIgnoreCase(planType)) return new PrepaidPlan();
        if ("POSTPAID".equalsIgnoreCase(planType)) return new PostpaidPlan();
        throw new IllegalArgumentException("Unknown plan type: " + planType);
    }

}
