package org.jokeoa.weeks.week1.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

/**
 * Task3.
 *
 */
public class Task3 {
    
    /**
     * Checks if the given number is prime.
     * O(√n)
     * @param number
     * @return true if the number is prime or not
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        if (number == 2) {
            return true;
        }
        
        if (number % 2 == 0) {
            return false;
        }
        
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        
     
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);
        
        System.out.println("Enter a number to check:");
        Operator<Integer> operator = factory.createOperator();
        int n = operator.getValue();
        
        boolean isPrimeNumber = isPrime(n);
        
        if (isPrimeNumber) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
} 