package model;

import java.util.Objects;

public class Customer {
    private final String id;
    private String name;
    private Plan plan;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer c = (Customer) o;
        return id.equals(c.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
