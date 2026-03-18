package main;

import file.FileHandler;
import model.Pizza;

import java.util.ArrayList;

public class PizzaBarApp {
    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();
        ArrayList<Pizza> arrayList = fileHandler.loadPizzas();
        System.out.println(arrayList);
        //test

    }
}
