package org.jokeoa.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

public class Task9 {
    /**
     * Calculates the binomial coefficient C(n,k).
     * 
     * Time Complexity: O(2^n)
     * @param n the total number of items
     * @param k the number of items to choose
     * @return the binomial coefficient C(n,k)
     */
    public static long binomCoeff(int n, int k) {
        return binomCoeffHelper(n, k, 0);
    }
    
    /**
     * Helper method for calculating binomial coefficient recursively.
     * Time Complexity: O(2^n)
     * @param n the total number of items
     * @param k the number of items to choose
     * @param offset accumulator for the result
     * @return the binomial coefficient C(n,k) plus the offset
     */
    private static long binomCoeffHelper(int n, int k, long offset) {
        if (n == k) {
            return 1+offset;
        }
        if (k > n) {
            return offset;
        }
        if (k == 0) {
            return 1+offset;
        }
        offset += binomCoeffHelper(n-1, k-1, 0);
        return binomCoeffHelper(n - 1, k, offset);
    }
    public static void main(String[] args) {
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);

        Operator<Integer> operator = factory.createOperator();
        Operator<Integer> operator2 = factory.createOperator();
        //TODO: add validation for n and k

        int n = operator.getValue();
        int k = operator2.getValue();
        System.out.println(binomCoeff(n, k));


    }
}
