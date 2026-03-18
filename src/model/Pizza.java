package model;

public class Pizza {

    private int number;
    private PizzaType pizzaType;
    private double price;

    public Pizza(int number, PizzaType pizzaType, double price) {
        this.number = number;
        this.pizzaType = pizzaType;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza number: " + number + "\nPizza type: " + pizzaType + "\nPizza price: " + price;
    }
}
