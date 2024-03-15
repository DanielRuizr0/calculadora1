package com.example.calculadora;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialCalculatorTest {

    private factorisActivity calculator;

    @Before
    public void setUp() {
        calculator = new factorisActivity();
    }

    @Test
    public void testCalcularFactorial_CasoBase() {
        assertEquals(1, calculator.calcularFactorial(0));
    }

    @Test
    public void testCalcularFactorial_NumeroPositivo() {
        assertEquals(120, calculator.calcularFactorial(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularFactorial_NumeroNegativo() {
        calculator.calcularFactorial(-5);
    }
}
