package com.example.calculadora;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MathFunctionsTest {

    private FibonacciActivity mathFunctions;

    @Before
    public void setUp() {
        mathFunctions = new FibonacciActivity();
    }

    @Test
    public void testCalcularFibonacci_CasoBase() {
        assertEquals("Secuencia de Fibonacci hasta el término 0: ", mathFunctions.calcularFibonacci(0));
    }

    @Test
    public void testCalcularFibonacci_HastaTres() {
        assertEquals("Secuencia de Fibonacci hasta el término 3: 0, 1, 1, ", mathFunctions.calcularFibonacci(3));
    }

}
