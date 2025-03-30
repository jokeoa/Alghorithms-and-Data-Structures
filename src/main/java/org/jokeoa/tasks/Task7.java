package org.jokeoa.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

public class Task7 {
    public static void reverseArrayInPlace(Integer[] array) {
        reverseArrayHelper(array, 0, array.length - 1);
    }

    private static void reverseArrayHelper(Integer[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        reverseArrayHelper(array, left + 1, right - 1);
    }

    public static void main(String[] args) {
        ConsoleInputProvider<Integer> inputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> factory = new OperatorFactory<>(inputProvider);

        System.out.println("Enter the size of the array:");
        Operator<Integer> sizeOperator = factory.createOperator();
        int n = sizeOperator.getValue();

        System.out.println("Enter " + n + " values:");
        Operator<Integer> arrayOperator = factory.createArrayOperator(n);

        Integer[] array = arrayOperator.getArray();
        reverseArrayInPlace(array);
        System.out.println("Reversed array:");
        for (Integer value : array) {
            System.out.print(value + " ");
        }
    }
}