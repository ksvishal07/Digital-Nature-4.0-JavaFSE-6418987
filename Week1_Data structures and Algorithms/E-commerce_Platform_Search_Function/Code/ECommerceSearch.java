package Code;

import java.util.*;

public class ECommerceSearch {
    static class Product {
        int id;
        String name;
        String category;
        double price;

        public Product(int id, String name, String category, double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Product{id=%d, name='%s', category='%s', price=%.2f}", id, name, category, price);
        }
    }

    public static List<Product> search(List<Product> products, String keyword, String category, Double minPrice, Double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            boolean matches = (keyword != null && p.name.toLowerCase().contains(keyword.toLowerCase()))
                    && (category != null && p.category.equalsIgnoreCase(category))
                    && (minPrice != null && p.price >= minPrice)
                    && (maxPrice != null && p.price <= maxPrice);
            if (matches) {
                result.add(p);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Apple iPhone 15", "Electronics", 999.00),
                new Product(2, "Samsung Galaxy S24", "Electronics", 899.00),
                new Product(3, "Nike Running Shoes", "Footwear", 120.00),
                new Product(4, "Levi's Jeans", "Clothing", 60.00),
                new Product(5, "Sony Headphones", "Electronics", 199.00 )
        );

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter keyword (or leave blank): ");
            String keyword = scanner.nextLine();
            if (keyword.isEmpty()) keyword = null;
            System.out.print("Enter category (or leave blank): ");
            String category = scanner.nextLine();
            if (category.isEmpty()) category = null;

            Double minPrice = null;
            while (true) {
                System.out.print("Enter min price (or leave blank): ");
                String minPriceStr = scanner.nextLine();
                if (minPriceStr.isEmpty()) break;
                try {
                    minPrice = Double.parseDouble(minPriceStr);
                    if (minPrice < 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid min price. Please enter a valid non-negative number or leave blank.");
                }
            }

            Double maxPrice = null;
            while (true) {
                System.out.print("Enter max price (or leave blank): ");
                String maxPriceStr = scanner.nextLine();
                if (maxPriceStr.isEmpty()) break;
                try {
                    maxPrice = Double.parseDouble(maxPriceStr);
                    if (maxPrice < 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid max price. Please enter a valid non-negative number or leave blank.");
                }
            }

            List<Product> searchResult = search(products, keyword, category, minPrice, maxPrice);
            System.out.println("Search Results:");
            for (Product p : searchResult) {
                System.out.println(p);
            }
        } finally {
            scanner.close();
        }
    }
}
