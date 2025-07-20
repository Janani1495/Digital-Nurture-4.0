package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class calculator2test {

    private calculator2 calculator;

    @Before
    public void setUp() {
        calculator = new calculator2();
        System.out.println("Setup done");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown done");
    }

    @Test
    public void testAddition() {
        int result = calculator.add(5, 3);
        assertEquals("Addition should be correct", 8, result);
    }

    @Test
    public void testMultiplication() {
        int result = calculator.multiply(4, 6);
        assertEquals("Multiplication should be correct", 24, result);
    }
}
