package org.jokeoa.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

public class Task7 {
    /**
     * Prints elements of an operator in reverse order using recursion.
     * 
     * Time Complexity: O(n)
     * Where n is the number of elements in the operator.
     * The method makes exactly n recursive calls, one for each element.
     *
     * @param operator the operator containing elements to be reversed
     */
    public static void reverseOrder(Operator<Integer> operator) {
        if (operator.hasNext()) {
            int value = operator.next();
            reverseOrder(operator);
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);

        System.out.println("Enter the size of the array:");
        Operator<Integer> sizeOperator = factory.createOperator();
        int n = sizeOperator.getValue();

        System.out.println("Enter " + n + " values:");
        Operator<Integer> arrayOperator = factory.createArrayOperator(n);

        System.out.println("Reversed order:");
        reverseOrder(arrayOperator);
    }
}
