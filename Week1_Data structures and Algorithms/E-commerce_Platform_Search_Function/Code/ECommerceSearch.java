package Code;

import java.util.*;

public class ECommerceSearch {
    static class Product implements Comparable<Product> {
        int productId;
        String productName;
        String category;
        double price;

        public Product(int productId, String productName, String category, double price) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Product{id=%d, name='%s', category='%s', price=%.2f}", productId, productName, category, price);
        }

        @Override
        public int compareTo(Product o) {
            return Integer.compare(this.productId, o.productId);
        }
    }

    // Linear search by productId
    public static Product linearSearch(Product[] products, int productId) {
        for (Product p : products) {
            if (p.productId == productId) return p;
        }
        return null;
    }

    // Binary search by productId (array must be sorted by productId)
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == productId) return products[mid];
            if (products[mid].productId < productId) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Apple iPhone 15", "Electronics", 999.00),
            new Product(2, "Samsung Galaxy S24", "Electronics", 899.00),
            new Product(3, "Nike Running Shoes", "Footwear", 120.00),
            new Product(4, "Levi's Jeans", "Clothing", 60.00),
            new Product(5, "Sony Headphones", "Electronics", 199.00)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose search method: 1. Linear Search 2. Binary Search");
        int method = scanner.nextInt();
        System.out.print("Enter Product ID to search: ");
        int searchId = scanner.nextInt();

        Product found = null;
        if (method == 1) {
            found = linearSearch(products, searchId);
        } else if (method == 2) {
            Arrays.sort(products); // Ensure sorted for binary search
            found = binarySearch(products, searchId);
        } else {
            System.out.println("Invalid method.");
            return;
        }

        if (found != null) {
            System.out.println("Product found: " + found);
        } else {
            System.out.println("Product not found.");
        }
    }
}
