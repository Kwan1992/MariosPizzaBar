package ui;

import model.*;
import service.PizzaSystem;
import util.BestillingSorter;


import java.util.Scanner;
import java.util.*;

import static service.PizzaSystem.askForPizzaCount;
import static util.ConsoleColors.*;

public class PizzaSystemUI {

    Scanner scanner = new Scanner(System.in);
    PizzaSystem pizzaSystem = new PizzaSystem();

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println(red +"\nPizzaBar" + green + "System");
            System.out.println(reset + "1. Vis menukort");
            System.out.println(blue + "2. Opret Order");
            System.out.println(purple + "3. Vis liste over aktive bestillinger");
            System.out.println(yellow + "4. Sorter efter tid");
            System.out.println(cyan + "5. Sorter efter ordernr");
            System.out.println(reset + "6. Fjern order");

            int choice = 0;
            if(scanner.hasNextInt())
            {
                choice = scanner.nextInt();
            } else {
                System.out.println("invalid input");
                scanner.nextLine();
            }

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
                    BestillingSorter.sortByOrderNumber(pizzaSystem.activeMultiOrder);
                    System.out.println(pizzaSystem.activeMultiOrder);
                    pizzaSystem.removeOrder(scanner);
                    break;

            }

        }

    }


}
