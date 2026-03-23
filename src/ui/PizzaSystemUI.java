package ui;

import model.*;
import service.PizzaSystem;
import util.BestillingSorter;


import java.util.Scanner;
import java.util.*;

import static service.PizzaSystem.askForPizzaCount;

public class PizzaSystemUI {

    private Scanner scanner;
    PizzaSystem pizzaSystem = new PizzaSystem();


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
            System.out.println("4. Sorter efter tid");
            System.out.println("5. Sorter efter ordernr");
            System.out.println("6. Fjern order");


            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println(pizzaSystem.menuCard);
                    break;

                case 2:
                    int count = askForPizzaCount(scanner);
                    pizzaSystem.addPizza(count,scanner);
                    break;

                case 3:
                    System.out.println(pizzaSystem.activeMultiOrder);
                    break;

                case 4:
                    BestillingSorter.sortByTime(pizzaSystem.activeMultiOrder);
                    System.out.println(pizzaSystem.activeMultiOrder);
                    break;

                case 5:
                    BestillingSorter.sortByOrderNumber(pizzaSystem.activeMultiOrder);
                    System.out.println(pizzaSystem.activeMultiOrder);
                    break;

                case 6:
                    Collections.sort(pizzaSystem.activeMultiOrder, Comparator.comparing(Order::getOrderNumber));
                    System.out.println(pizzaSystem.activeMultiOrder);
                    pizzaSystem.removeOrder(scanner);
                    break;

            }

        }

    }


}
