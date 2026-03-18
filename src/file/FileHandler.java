package file;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_NAME = "pizzas.csv";

    public ArrayList<Pizza> loadPizzas() {

        ArrayList<Pizza> pizzas = new ArrayList<>();

        try
                (BufferedReader reader =
                         new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int number = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                double weight = Double.parseDouble(parts[3]);
                Color color = Color.valueOf(parts[4]);
                Breed breed = Breed.valueOf(parts[5]);
            }
}
