package org.jokeoa.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

public class Task2 {
    
    /**
     * Calculates the average of  values in the given operator's array.
     * O(n)
     * @param <T> The type of values
     * @param operator The operator containing the array of values
     * @return The average as a double
     */
    public static <T extends Number> double calculateAverage(Operator<T> operator) {
        T[] array = operator.getArray();
        if (array == null || array.length == 0) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (T value : array) {
            sum += value.doubleValue();
        }
        
        return sum / array.length;
    }
    
    /**
     * Main method to demonstrate the average calculation.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Create an input provider for Integer values
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        
        // Create factory and operator
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);
        
        // Get the number of elements
        System.out.println("Task 1: Calculate the average of an array of numbers");
        Operator<Integer> sizeOperator = factory.createOperator();
        int n = sizeOperator.getValue();
        
        // Get the array of n elements
        Operator<Integer> arrayOperator = factory.createOperatorWithArray(n);
        
        // Calculate average
        double average = calculateAverage(arrayOperator);
        System.out.println("The average of the array elements is: " + average);

    }
}
