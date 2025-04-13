package org.jokeoa.weeks.week1.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

public class Task6 {
    /**
     * Calculates the power of a number using recursion.
     * 
     * Time Complexity: O(n)
     *
     * @param base     the base number
     * @param exponent the exponent
     * @return the result of base raised to the power of exponent
     */
    public static Integer calculatePower(Integer base, Integer exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * calculatePower(base, exponent - 1);
    }
    /**
     * Main method to demonstrate the use of the Task6 class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);

        Operator<Integer> baseOperator = factory.createOperator();
        int base = baseOperator.getValue();

        Operator<Integer> exponentOperator = factory.createOperator();
        int exponent = exponentOperator.getValue();

        Integer power = calculatePower(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + power);
    }
}
