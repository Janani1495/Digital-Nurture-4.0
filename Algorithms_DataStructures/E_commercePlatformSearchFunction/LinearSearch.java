package Week1.Algorithms_DataStructures.E_commercePlatformSearchFunction;

public class LinearSearch {
    public static Product linearSearchByName(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
}
