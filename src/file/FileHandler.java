package file;

import model.Order;
import model.Pizza;
import model.PizzaType;
import util.ExceptionHandler;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String MENU_FILE = "pizzas.csv";
    private static final String FILE_NAME = "Orders.csv";

    public ArrayList<Pizza> loadPizzas() {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        File file = new File(MENU_FILE);

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(MENU_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int number = Integer.parseInt(parts[0]);
                PizzaType pizzaType = PizzaType.valueOf(parts[1]);
                double price = Double.parseDouble(parts[2]);
                pizzas.add(new Pizza(number, pizzaType, price));
            }

        } catch (IOException e) {
            ExceptionHandler.handle(new ExceptionHandler.FileReadException("Could not read this file: " + MENU_FILE));

        }

        return pizzas;
    }

    public void saveOrder(Order order) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            for (Pizza p : order.getPizzas()) {
                writer.write(order.getOrderNumber() + "," +
                        order.getCustomer().getName() + "," +
                        order.getCustomer().getCustomerType() + "," +
                        p.getNumber() + "," +
                        p.getPizzaType() + "," +
                        p.getPrice() + "," +
                        order.calculateTotalPrice());

                writer.newLine();
            }

        } catch (IOException e) {
            ExceptionHandler.handle(new ExceptionHandler.FileWriteException("Could not write this file: " + FILE_NAME));
        }
    }
}