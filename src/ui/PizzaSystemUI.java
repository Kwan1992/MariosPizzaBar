package ui;

import file.FileHandler;
import model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalTime;

public class PizzaSystemUI {

    private Scanner scanner;
    private FileHandler fileHandler = new FileHandler();
    private Order activeOrder;
    private ArrayList<Order> activeMultiOrder = new ArrayList<Order>();
    ArrayList<Pizza> menuCard = fileHandler.loadPizzas();
    Random random = new Random();


    public PizzaSystemUI() {

        scanner = new Scanner(System.in);
    }


    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("\nPizzaBar System");
            System.out.println("1. Vis menukort");
            System.out.println("2. Opret Order");
            System.out.println("3. Vis liste over aktive bestillinger");
            System.out.println("4. Fjern og gem order");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println(menuCard);
                    break;

                case 2:
                    int count=askForPizzaCount(scanner);
                    addPizza(count);
                    break;

                case 3:
                    System.out.println(activeMultiOrder);
                    break;

                case 4:

                    break;
            }

        }

    }

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

    private void addPizza(int count) {
        int orderNumber= random.nextInt(10000);


        System.out.println("Customer name");
        String name = scanner.nextLine();


        System.out.println("Customer Type (Normal, VIP, Employee): ");
        String customerTypeString = scanner.nextLine();
        Customer customerType;
        if (customerTypeString.equalsIgnoreCase("VIP")) {
            customerType = new VIPCustomer(name);
        } else if (customerTypeString.equalsIgnoreCase("Employee")) {
            customerType = new EmployeeCustomer(name);
        } else {
            customerType = new NormalCustomer(name);
        }

        LocalTime orderTime = LocalTime.now();
        activeOrder = (new Order(orderNumber, customerType, orderTime));

        for (int i = 0; i < count; i++) {
            System.out.println(i+1 + ". Pizza");
            System.out.println("Pizza number: 1-30 ");
            int pizzaNumber = scanner.nextInt() - 1; // minus 1 fordi arraylist er 0 indexeret


            activeOrder.addPizza(menuCard.get(pizzaNumber));
            activeMultiOrder.add(activeOrder);
            System.out.println("Pizza added.");
        }

    }
}
