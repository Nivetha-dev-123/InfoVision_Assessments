package model;



public abstract class Plan {
    protected double ratePerMinute;

    public double getRatePerMinute() {
        return ratePerMinute;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(ratePerMinute=" + ratePerMinute + ")";
    }
}

