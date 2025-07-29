package Algorithms_DataStructures.E_commercePlatformSearchFunction;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "T-shirt", "Apparel"),
            new Product(103, "Coffee Maker", "Home Appliances"),
            new Product(104, "Notebook", "Stationery")
        };

        // Linear Search
        Product foundLinear = LinearSearch.linearSearchByName(products, "T-shirt");
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Product not found"));

        // Binary Search
        Product foundBinary = BinarySearch.binarySearchByName(products, "T-shirt");
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Product not found"));
    }
}
