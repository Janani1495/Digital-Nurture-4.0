package Algorithms_DataStructures.InventoryManagementSystem;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> productMap;

    public Inventory() {
        productMap = new HashMap<>();
    }

    public void addProduct(Product p) {
        if (productMap.containsKey(p.productId)) {
            System.out.println("Product ID already exists. Use update instead.");
        } else {
            productMap.put(p.productId, p);
            System.out.println("Product added.");
        }
    }

    public void updateProduct(String id, int quantity, double price) {
        Product p = productMap.get(id);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String id) {
        if (productMap.remove(id) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void showInventory() {
        if (productMap.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : productMap.values()) {
                System.out.println(p);
            }
        }
    }
}

