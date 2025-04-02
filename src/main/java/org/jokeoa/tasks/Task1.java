package org.jokeoa.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

/**
 * Task1: Find the minimum element in an array of numbers.
 * O(n)
 */
public class Task1 {
    
    /**
     * Finds the minimum value in the given operator's array.
     * 
     * @param <T> The type of comparable values
     * @param operator The operator containing the array of values
     * @return The minimum value
     * @throws IllegalArgumentException if the array is empty
     */
    public static <T extends Comparable<T>> T findMinimum(Operator<T> operator) {
        T[] array = operator.getArray();
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        
        return min;
    }
    
    /**
     * Main method to demonstrate finding the minimum element.
     */
    public static void main(String[] args) {
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);
        
        Operator<Integer> sizeOperator = factory.createOperator();
        int n = sizeOperator.getValue();
        
        Operator<Integer> arrayOperator = factory.createOperatorWithArray(n);
        
        Integer minimum = findMinimum(arrayOperator);
        System.out.println("The minimum element in the array is: " + minimum);
        
    }
} 