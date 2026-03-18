package model;

public class NormalCustomer extends Customer {
    public NormalCustomer(String name) {
        super(name);
    }

    @Override
    public String getCustomerType() {
        return "Normal";
    }

    @Override
    public double getDiscount() {
        return 0.0;
    }
}
