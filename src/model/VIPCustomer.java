package model;

public class VIPCustomer extends Customer{
    public VIPCustomer(String name){
        super(name);
    }
    @Override
    public String getCustomerType(){
        return "VIP";
    }
    @Override
    public double getDiscount(){
        return 0.10;
    }

}
