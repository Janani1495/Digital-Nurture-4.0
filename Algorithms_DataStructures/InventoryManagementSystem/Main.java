package Algorithms_DataStructures.InventoryManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.addProduct(new Product(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    String updateId = sc.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();
                    inventory.updateProduct(updateId, newQty, newPrice);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = sc.nextLine();
                    inventory.deleteProduct(deleteId);
                    break;

                case 4:
                    inventory.showInventory();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}