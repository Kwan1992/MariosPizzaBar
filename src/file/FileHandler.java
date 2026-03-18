package file;

import model.Pizza;
import model.PizzaType;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String MENU_FILE = "pizzas.csv";
    private static final String FILE_NAME = "activeOrders.txt";

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
            e.printStackTrace();
        }

        return pizzas;
    }

    public void saveOrder(ArrayList<Pizza> pizzas) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Pizza p : pizzas) {
                writer.write(p.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}