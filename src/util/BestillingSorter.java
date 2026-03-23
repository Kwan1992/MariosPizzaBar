package util;

import model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BestillingSorter {

    public static void sortByTime(ArrayList<Order> activeMultiOrder) {

        Collections.sort(activeMultiOrder, Comparator.comparing(Order::getOrderTime));

    }

    public static void sortByOrderNumber(ArrayList<Order> activeMultiOrder) {

        Collections.sort(activeMultiOrder, Comparator.comparing(Order::getOrderNumber));

    }

}
