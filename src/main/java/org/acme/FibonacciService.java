package org.acme;

import java.util.HashMap;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FibonacciService {

    private Map<Long, Long> cache = new HashMap<>();

    public Long calculateFibonacci(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci numbers are defined for non-negative indices only.");
        }
    
        // Base cases: Fibonacci of 0 or 1 is the number itself
        if (n == 0 || n == 1) {
            return n;
        }
    
        // Check if the calculated number is already in the cache
        if (cache.containsKey(n)) {
            // Return the result from the cache to avoid redundant calculations
            return cache.get(n);
        }
    
        // Recursive calculation of the Fibonacci number
        Long result = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    
        // Cache the result before returning
        cache.put(n, result);
    
        return result;
    }    
}
