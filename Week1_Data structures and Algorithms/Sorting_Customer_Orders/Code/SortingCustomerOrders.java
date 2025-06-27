package Sorting_Customer_Orders.Code;

import java.util.*;

public class SortingCustomerOrders {
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return String.format("Order{id=%d, customer='%s', totalPrice=%.2f}", orderId, customerName, totalPrice);
        }
    }

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 250.50),
            new Order(102, "Bob", 99.99),
            new Order(103, "Charlie", 500.00),
            new Order(104, "Diana", 150.75),
            new Order(105, "Eve", 320.20)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) System.out.println(o);

        // Bubble Sort
        Order[] bubbleSorted = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleSorted);
        System.out.println("\nOrders sorted by Bubble Sort:");
        for (Order o : bubbleSorted) System.out.println(o);

        // Quick Sort
        Order[] quickSorted = Arrays.copyOf(orders, orders.length);
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        for (Order o : quickSorted) System.out.println(o);

        // Analysis
        System.out.println("\nAnalysis:");
        System.out.println("Bubble Sort: O(n^2) time complexity. Simple but inefficient for large datasets.");
        System.out.println("Quick Sort: O(n log n) average time complexity. Much faster for large datasets and generally preferred.");
    }
}
