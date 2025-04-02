package org.jokeoa.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

//pls someone explain me what's wrong with my life
public class Task10 {
    /**
     * Calculates the greatest common divisor (GCD) of two integers using Euclidean algorithm.
     * 
     * Time Complexity: O(log(min(a, b)))
     * The time complexity is logarithmic because in each recursive call, 
     * the values decrease by a factor proportional to their ratio.
     *
     * @param a first integer
     * @param b second integer
     * @return the GCD of a and b
     */
    public static int gcd(int a, int b)
    {
        if (b != 0)
            return gcd(b, a % b);
        else
            return a;
    }
    public static void main(String[] args) {
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);

        System.out.println("Enter two numbers to find their GCD:");
        Operator<Integer> operator1 = factory.createOperator();
        Operator<Integer> operator2 = factory.createOperator();

        int a = operator1.getValue();
        int b = operator2.getValue();

        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }
}
