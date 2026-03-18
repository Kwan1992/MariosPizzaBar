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
        //Det er nødvendigt med det her StringBuilder
        //Den bruges til at bygge tekst fordi vi tilføjer meget tekst i toString
        StringBuilder sb = new StringBuilder();
//Append til at tilføje til fil
        sb.append("Order Nr: " + orderNumber + "\n");
        sb.append("Kunde: " + customer.getName() + "\n");
        sb.append("Kundetype: " + customer.getCustomerType() + "\n");
        sb.append("Pizaer: \n");

        //Loop gennem pizzaer så hvis de bliver bestilt vælges de.
        for (Pizza pizza : pizzas) {
            sb.append("- " + pizza.getPizzaType() + " - " + pizza.getPrice() + " kr.\n");
        }
        sb.append("Total: " + calculateTotalPrice() + " kr.\n");

        //StringBuilder er ikke en string så vi skal skrive:
        return sb.toString();
    }

}
