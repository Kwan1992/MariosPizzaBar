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

            System.out.print("Hvor mange pizzaer vil du bestille? ");

            if (sc.hasNextInt()) {
                count = sc.nextInt();
                sc.nextLine(); // Clear buffer

                if (count > 0) {
                    break;
                } else {
                    System.out.println("Vær så venlig at indtaste et positivt nummer!");
                }
            } else {
                System.out.println("Det var ikke et nummer, prøv igen!");
                sc.nextLine(); // Clear invalid input
            }
            sc.nextLine();
        }

        return count;
    }

    public void addPizza(int count,Scanner scanner) {
        int orderNumber = random.nextInt(10000);


        System.out.println("Kunde navn: ");
        String name = scanner.nextLine();

        Customer customerType;
        while(true) {
            System.out.println("Kunde Type (Normal, VIP, Employee): ");
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
                System.out.println("invalidt input");
            }
        }
        LocalTime orderTime = LocalTime.now().withNano(0);
        activeOrder = (new Order(orderNumber, customerType, orderTime));

        for (int i = 0; i < count; i++) {
            int pizzaNumber;
            while (true) {
                System.out.println(i + 1 + ". Pizza");
                System.out.println("Pizza number: 1-30 ");
                pizzaNumber = scanner.nextInt() - 1; // minus 1 fordi arraylist er 0 indexeret
                if (pizzaNumber > 30 | pizzaNumber < 1) {
                    System.out.println("invalid input");
                } else {
                    scanner.nextLine();
                    break;
                }
            }
            activeOrder.addPizza(menuCard.get(pizzaNumber));
            System.out.println("Pizza tilføjet.");
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

        System.out.print("Indtast ordre nummer du vil fjerne: ");
        int orderNumber = scanner.nextInt();

        Order found = findOrder(orderNumber);

        if (found != null) {
            activeMultiOrder.remove(found);
            System.out.println("Ordre fjernet.");
        } else {
            System.out.println("Ordre ikke fundet.");
        }
    }
}
