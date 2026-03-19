package model;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private Customer customer;
    private ArrayList<Pizza> pizzas;

    public Order(int orderNumber, Customer customer) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.pizzas = new ArrayList<>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public double calculateTotalPrice() {
        double total = 0;

        for (Pizza pizza : pizzas) {
            total += customer.applyDiscount(pizza.getPrice());
        }
        return total;
    }

    //Laver append her
    @Override
    public String toString() { //Når vi skriver System.out.println(order); bliver den her metode automatisk kaldt
        String text = "";

        text += "Order number: " + orderNumber + "\n";
        text += "Kunde: " + customer.getName() + "\n";
        text += "Kundetype: " + customer.getCustomerType() + "\n";
        text += "Bestilt:\n";

        for (Pizza pizza : pizzas) {
            text += "- " + pizza.getPizzaType() + " - " + pizza.getPrice() + " kr.\n";
        }

        text += "Total: " + calculateTotalPrice() + " kr.\n";

        return text;
    }

}
