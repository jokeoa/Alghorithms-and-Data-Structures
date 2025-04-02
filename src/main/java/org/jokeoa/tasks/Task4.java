package org.jokeoa.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;
/**
 * O(n)
 *
 */
public class Task4 {
    public static Integer findFactorial(Integer value) {
        if (value == 2){
            return value;
        }
        return value * findFactorial(value - 1);
    }
    /**
     * Main method to demonstrate finding the factorial of a number.
     *
     */
    public static void main(String[] args) {
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);

        System.out.println("Task 4:");
        Operator<Integer> sizeOperator = factory.createOperator();
        int n = sizeOperator.getValue();


        Integer factorial = findFactorial(n);
        System.out.println("The factorial of " + n + " is: " + factorial);
    }
}
