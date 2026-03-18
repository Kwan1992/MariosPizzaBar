package model;

public abstract class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getCustomerType();

    public abstract double getDiscount();

    public double applyDiscount(double amount) {
        return amount - (amount * getDiscount());
    }

    @Override
    public String toString() {
        return name + " (" + getCustomerType() + ")";
    }
}
