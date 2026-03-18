package model;

public class EmployeeCustomer extends Customer {
    public EmployeeCustomer(String name){
        super(name);
    }
    @Override
    public String getCustomerType(){
        return "Employee";
    }
    @Override
    public double getDiscount(){
        return 0.20;
    }

}
