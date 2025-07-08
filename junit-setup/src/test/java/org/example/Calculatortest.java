package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class Calculatortest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(3, 4);
        assertEquals(7, result);
    }
}
