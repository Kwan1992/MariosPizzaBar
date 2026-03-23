package service;

import model.*;
import file.FileHandler;
import model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.*;




public class PizzaSystem {
    private FileHandler fileHandler = new FileHandler();
    private Order activeOrder;
    public ArrayList<Order> activeMultiOrder = new ArrayList<Order>();
    public ArrayList<Pizza> menuCard = fileHandler.loadPizzas();
    private Random random = new Random();
    public static int askForPizzaCount(Scanner sc) {

        int count = 0;

        while (true) {

            System.out.print("How many Pizzas do you want to order? ");

            if (sc.hasNextInt()) {
                count = sc.nextInt();
                sc.nextLine(); // Clear buffer

                if (count > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number!");
                }
            } else {
                System.out.println("That wasn't a number, try again!");
                sc.nextLine(); // Clear invalid input
            }
        }

        return count;
    }

    public void addPizza(int count,Scanner scanner) {
        int orderNumber = random.nextInt(10000);


        System.out.println("Customer name");
        String name = scanner.nextLine();

        Customer customerType;
        while(true) {
            System.out.println("Customer Type (Normal, VIP, Employee): ");
            String customerTypeString = scanner.nextLine();
            if (customerTypeString.equalsIgnoreCase("VIP")) {
                customerType = new VIPCustomer(name);
                break;
            } else if (customerTypeString.equalsIgnoreCase("Employee")) {
                customerType = new EmployeeCustomer(name);
                break;
            } else if (customerTypeString.equalsIgnoreCase("Normal")) {
                customerType = new NormalCustomer(name);
                break;
            } else {
                System.out.println("invalid input");
            }
        }
        LocalTime orderTime = LocalTime.now().withNano(0);
        activeOrder = (new Order(orderNumber, customerType, orderTime));

        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + ". Pizza");
            System.out.println("Pizza number: 1-30 ");
            int pizzaNumber = scanner.nextInt() - 1; // minus 1 fordi arraylist er 0 indexeret


            activeOrder.addPizza(menuCard.get(pizzaNumber));
            System.out.println("Pizza added.");
        }
        activeMultiOrder.add(activeOrder);
        fileHandler.saveOrder(activeOrder);


    }
    private Order findOrder(int orderNumber) {

        for (Order order : activeMultiOrder) {
            if (Objects.equals(order.getOrderNumber(), orderNumber)) {
                return order;
            }
        }
        return null;
    }

    public void removeOrder(Scanner scanner) {

        System.out.print("Enter order number to remove: ");
        int orderNumber = scanner.nextInt();

        Order found = findOrder(orderNumber);

        if (found != null) {
            activeMultiOrder.remove(found);
            System.out.println("Order removed.");
        } else {
            System.out.println("Order not found.");
        }
    }
}
