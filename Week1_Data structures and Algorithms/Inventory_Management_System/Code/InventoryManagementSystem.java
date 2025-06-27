package Code;

import java.util.*;

public class InventoryManagementSystem {
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Product{id=%d, name='%s', quantity=%d, price=%.2f}", productId, productName, quantity, price);
        }
    }

    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.productId)) {
            inventory.put(product.productId, product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) == null) {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. Display Inventory\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    ims.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String uname = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int uqty = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double uprice = scanner.nextDouble();
                    ims.updateProduct(new Product(uid, uname, uqty, uprice));
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int did = scanner.nextInt();
                    ims.deleteProduct(did);
                    break;
                case 4:
                    ims.displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
