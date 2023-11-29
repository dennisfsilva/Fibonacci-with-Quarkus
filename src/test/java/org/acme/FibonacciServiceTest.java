package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class FibonacciServiceTest {

    @Inject
    FibonacciService fibonacciService;

    @Test
    public void testCalculateFibonacci() {
        long result = fibonacciService.calculateFibonacci(5);
        assertEquals(5, result);
    }

    @Test
    public void testCalculateFibonacciWithZeroInput() {
        long result = fibonacciService.calculateFibonacci(0);
        assertEquals(0, result);
    }

    @Test
    public void testCalculateFibonacciWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciService.calculateFibonacci(-1);
        });
    }
}
