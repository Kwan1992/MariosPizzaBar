package file;

import model.Pizza;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_NAME = "pizzas.txt";

    public ArrayList<Pizza> showPizzas() {

        ArrayList<Pizza> pizzas = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return pizzas;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int number = Integer.parseInt(parts[0]);
                String PizzaType = parts[1];
                double price = Double.parseDouble(parts[2]);
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