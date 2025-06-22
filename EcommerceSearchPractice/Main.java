public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "Watch", "Accessories")
        };

        System.out.println("🔍 Linear Search:");
        Product linearResult = LinearSearch.search(products, "Mobile");
        if (linearResult != null)
            System.out.println("Product Found: " + linearResult);
        else
            System.out.println("Product not found");

        System.out.println("\n🔍 Binary Search:");
        Product binaryResult = BinarySearch.search(products, "Mobile");
        if (binaryResult != null)
            System.out.println("Product Found: " + binaryResult);
        else
            System.out.println("Product not found");
    }
}
