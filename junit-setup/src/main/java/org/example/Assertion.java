package org.example;

public class Assertion {
    public static void main(String[] args) {
        try {
            // Assert equals
            if (2 + 3 != 5) throw new AssertionError("2 + 3 should equal 5");

            // Assert true
            if (!(5 > 3)) throw new AssertionError("5 should be greater than 3");

            // Assert false
            if (5 < 3) throw new AssertionError("5 should not be less than 3");

            // Assert null
            Object obj1 = null;
            if (obj1 != null) throw new AssertionError("obj1 should be null");

            // Assert not null
            Object obj2 = new Object();
            if (obj2 == null) throw new AssertionError("obj2 should not be null");

            System.out.println("✅ All assertions passed!");
        } catch (AssertionError e) {
            System.err.println("❌ Assertion failed: " + e.getMessage());
        }
    }
}
