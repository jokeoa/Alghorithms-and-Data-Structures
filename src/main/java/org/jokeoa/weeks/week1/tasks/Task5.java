package org.jokeoa.weeks.week1.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;
/**
 * O(2^n)
 */
public class Task5 {

    public static Integer findFibonacci(Integer value) {
        if (value <= 1) {
            return value;
        }
        return findFibonacci(value - 1) + findFibonacci(value - 2);
    }
    /**
     * Main method to demonstrate the use of the Task5 class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Task 5:");
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);

        Operator<Integer> sizeOperator = factory.createOperator();
        int n = sizeOperator.getValue();

        Integer fibonacci = findFibonacci(n);
        System.out.println("The Fibonacci number at position " + n + " is: " + fibonacci);
    }
}
