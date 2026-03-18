package ui;

import file.FileHandler;
import model.Pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaSystemUI {

    private Scanner scanner;
    private FileHandler fileHandler = new FileHandler();


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
                    ArrayList<Pizza> arrayList = fileHandler.loadPizzas();
                    System.out.println(arrayList);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;
            }

        }

    }
}
